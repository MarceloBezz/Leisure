package org.deem.project.leisure.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.deem.project.leisure.model.Imovel;
import org.deem.project.leisure.model.Usuario;
import org.deem.project.leisure.service.FotoService;
import org.deem.project.leisure.service.ImovelService;
import org.deem.project.leisure.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario/perfil")
public class ImovelController {
	
	private static String pathImage = "src\\main\\resources\\Imagens\\ImagensImovel\\";

	@Autowired
	private ImovelService imovelService;
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	FotoService fotoService;
	
//				---------------------- CADASTRAR IMÓVEL -----------------------------
	@PostMapping("/cadastrar")
	public String cadastrarImovel(Imovel imovel, String mensagem, RedirectAttributes redirect,@RequestParam("file") MultipartFile file) {
		boolean save = imovelService.existsByCepAndNumero(imovel.getCep(), imovel.getNumero());

		
		if(save == false) { //VERIFICA SE OS DADOS DO IMÓVEL JÁ ESTÃO CADASTRADOS OU NÃO
			try {
				imovel.setUsuario(usuarioService.getAuthenticatedUser());
				Imovel _imovel = imovelService.save(imovel);
				redirect.addAttribute("imovel", _imovel);
				redirect.addFlashAttribute("mensagem", "Imóvel cadastrado com sucesso!");
				if(!file.isEmpty()) {
					// byte[] bytes = file.getBytes();
					// Path caminho = Paths.get(pathImage + String.valueOf(imovel.getId()) + "fotoImovel.png");
					// Files.write(caminho, bytes);
					String imagemUrl = fotoService.uploadImageToApiPic(file, (int) imovel.getId(), "fotoImovel");
				}
			} catch(IOException e){
				e.printStackTrace();
			}

		return "redirect:/usuario/perfil";
	}else {
		redirect.addFlashAttribute("erro", "Erro no cadastro \nEndereço do imóvel já cadastrado!");
		return "redirect:/usuario/perfil/anuncio";
	}
}

		// --------------------------------------- VISUALIZAR IMAGEM DO IMÓVEL ------------------------------------------------------
		@GetMapping("/imovel/imagem/{id}")
		public ResponseEntity<Resource> getImagem(@PathVariable int id, Usuario usuario, Imovel imovel) throws IOException {
			try{
            String imageUrl = "https://suntech.eco.br/api/uploads/fotoImovel" + imovel.getId() + ".png";
            Resource image = fotoService.getImageFromApi(imageUrl);
    
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "image/*"); // Ajuste o tipo de conteúdo conforme necessário
    
            return new ResponseEntity<>(image, headers, HttpStatus.OK);
			}catch(Exception e){
				return null;
			}
			}

	
//				--------------------- DEVOLVER IMÓVEL ATUALIZADO -----------------------------------
	@PostMapping("/atualizar")
	public String atualizarImovel(Imovel imovel,@RequestParam("id") int id, String mensagem, RedirectAttributes redirect) {
		Imovel novoImovel = imovelService.findById(id);
		imovelService.atualizar(imovel,novoImovel);
		redirect.addFlashAttribute("mensagem","Imóvel atualizado com sucesso!");
		return "redirect:/usuario/perfil/anuncio";
	}
	
// 				---------------------- DELETAR IMÓVEL ------------------------------------
	@PostMapping("/deletar-imovel")
	public String deletar(Imovel imovel, RedirectAttributes redirect,@RequestParam("id") Long id) throws IOException {
		//Path caminho = Paths.get(pathImage + id +"fotoImovel.png");
		//Files.delete(caminho);
		imovelService.deleteById(id);
		redirect.addFlashAttribute("mensagem", "Imóvel deletado com sucesso!");
		return "redirect:/usuario/perfil/anuncio";
	}


// 				---------------------- SALVAR FOTO ------------------------------------
@PostMapping("/salvar-foto")
public String salvarFoto(Usuario usuario,@RequestParam("id")int id, @RequestParam("file") MultipartFile file, RedirectAttributes redirect, Imovel imovel) {
	Imovel imovel_ = imovelService.findById(id);
	usuario = usuarioService.getAuthenticatedUser();
	try {
		if(!file.isEmpty()) {
			String imagemUrl = fotoService.uploadImageToApiPic(file, (int) imovel.getId(), "fotoImovel");
			imovel_.setCaminho_Imagem(imagemUrl);
			imovelService.save(imovel_);
		}
	} catch(IOException e){
		e.printStackTrace();
	}
	
	return "redirect:/usuario/perfil/editar-imovel/" + id;
}

// 				---------------------- ACESSAR PÁGINA DE EDIÇÃO DO IMÓVEL ------------------------------------
@GetMapping("/editar-imovel/{id}")
public String editarImovel(@PathVariable int id ,Model model, Usuario usuario, RedirectAttributes redirect) {
	usuario = usuarioService.getAuthenticatedUser();
	Imovel imovel = imovelService.findById(id);
	if(!usuario.getImoveis().contains(imovel)){
		return "redirect:/usuario/perfil/anuncio";
	}
    model.addAttribute("imovel", imovel);
	model.addAttribute("usuario", usuario);
	redirect.addAttribute("imovel", imovel);
	redirect.addAttribute("usuario", usuario);
	return "edicaoImovel";
}

// @GetMapping("/editar-imovel/{id}")
// public String editarImovel(@PathVariable int id ,Model model, Usuario usuario, RedirectAttributes redirect) {
// 	usuario = usuarioService.getAuthenticatedUser();
// 	Imovel imovel = imovelService.findById(id);
//     model.addAttribute("imovel", imovel);
// 	model.addAttribute("usuario", usuario);
// 	redirect.addAttribute("imovel", imovel);
// 	redirect.addAttribute("usuario", usuario);
// 	return "redirect:/usuario/perfil/editar-imovel";
// }

@GetMapping("/editar-imovel")
public String editarImovelSemId(){
	return "edicaoImovel";
}


}
