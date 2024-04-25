package org.deem.project.leisure.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.deem.project.leisure.model.Imovel;
import org.deem.project.leisure.model.Usuario;
import org.deem.project.leisure.service.ImovelService;
import org.deem.project.leisure.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.JpaSort.Path;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	private ImovelService Imovelservice;
	
	@Autowired
	private UsuarioService usuarioService;
	
//				---------------------- CADASTRAR IMÓVEL -----------------------------
	@PostMapping("/cadastrar")
	public String cadastrarImovel(Imovel imovel, String mensagem, RedirectAttributes redirect,@RequestParam("file") MultipartFile file) {
		boolean save = Imovelservice.existsByCepAndNumero(imovel.getCep(), imovel.getNumero());
		Usuario usuario_ = usuarioService.getAuthenticatedUser();
		
		if(save == false) { //VERIFICA SE OS DADOS DO IMÓVEL JÁ ESTÃO CADASTRADOS OU NÃO
			// try {
			// 	if(!file.isEmpty()) {
			// 		byte[] bytes = file.getBytes();
			// 		Path caminho = Paths.get(pathImage + String.valueOf(usuario_.getId()) + "fotoPerfil.png");
			// 		Files.write(caminho, bytes);
			// 		usuarioService.atualizar(usuario_);
			// 	}
			// } catch(IOException e){
			// 	e.printStackTrace();
			// }
		imovel.setUsuario(usuarioService.getAuthenticatedUser());
		Imovel _imovel = Imovelservice.save(imovel);
		redirect.addAttribute("imovel", _imovel);
		redirect.addFlashAttribute("mensagem", "Imóvel cadastrado com sucesso!");
		return "redirect:/usuario/perfil";
	}else {
		redirect.addFlashAttribute("mensagem", "Erro no cadastro \nEndereço do imóvel já cadastrado!");
		return "redirect:/usuario/perfil";
	}
}
	
//				--------------------- ATUALIZAR IMÓVEL -----------------------------------
	@PostMapping("/atualizar")
	public String atualizarImovel(Imovel imovel, String mensagem, RedirectAttributes redirect) {
		
		Imovel novoImovel = Imovelservice.save(imovel);
		redirect.addAttribute("imovel", novoImovel);
		return "redirect:/usuario/perfil";
	}
	
// 				---------------------- DELETAR IMÓVEL ------------------------------------
	@GetMapping("/deletar-imovel")
	public String deletar(Imovel imovel, RedirectAttributes redirect,@RequestParam("id") Long id) {
		Imovelservice.deleteById(id);
		return "redirect:/usuario/perfil/anuncio";
	}
}
