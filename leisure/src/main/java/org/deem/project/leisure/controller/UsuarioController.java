package org.deem.project.leisure.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.deem.project.leisure.model.Usuario;
import org.deem.project.leisure.repository.RoleRepository;
import org.deem.project.leisure.repository.UsuarioRepository;
import org.deem.project.leisure.service.FotoService;
//import org.deem.project.leisure.repository.UsuarioRepository;
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
@RequestMapping("/usuario")
public class UsuarioController{
	
	
	private static String pathImage = "src\\main\\resources\\Imagens\\ImagensPerfil\\";

	@Autowired
	FotoService fotoService;
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

@PostMapping("/login")
public String getMethodName(@RequestParam String param) {
    return "redirect:/leisure/index";
}


//  ------------------------------------------- LOGIN BEM-SUCEDIDO -------------------------------------------------------------	
	@GetMapping("/perfil")
	public String perfil(Model model, RedirectAttributes redirect) {	
		try{	
		Usuario usuario = usuarioService.getAuthenticatedUser();
		model.addAttribute("usuario", usuario);
		return "perfil";
		}catch(Exception e){
			redirect.addFlashAttribute("login", "Faça login ou se cadastre primeiro para entrar");
			return "redirect:/leisure/login";
		}
	}
	
	//  ------------------------------------------- DELETAR USUÁRIO -------------------------------------------------------------	
		@PostMapping("/deletar/{id}")
		public ResponseEntity<Map<String, String>> deletar(@PathVariable Long id, RedirectAttributes redirect) throws IOException {
			Usuario usuario = usuarioService.findById(id);
			String usuarioNome = usuario.getNome();
			usuarioService.deleteById(id);
			
			Map<String, String> response = new HashMap<>();
			response.put("mensagem", "O usuário " + usuarioNome + " foi deletado com sucesso!");
			return ResponseEntity.ok(response);
		}
		

		// ------------------------------------------------ ATUALIZAR DADOS ---------------------------------------------------------
		@PostMapping("/atualizacao")
		public String updateAll(RedirectAttributes redirect, 
								Usuario usuario, 
								String mensagem) throws IOException {
			
			Usuario usuarioBD = usuarioService.getAuthenticatedUser();
			usuarioService.atualizar(usuario,usuarioBD);

			redirect.addFlashAttribute("mensagem", "Dados atualizados com sucesso!");
			return "redirect:/usuario/perfil/meusdados";
			
	}
		
// 				---------------------- SALVAR IMAGEM DE PERFIL ------------------------------------
		@PostMapping("/salvar-foto")
		public String salvarFoto(Usuario usuario, @RequestParam("file") MultipartFile file, RedirectAttributes redirect) {
			usuario = usuarioService.getAuthenticatedUser();
			try {
				if(!file.isEmpty()) {
					String imagemUrl = fotoService.uploadImageToApiPic(file, (int) usuario.getId(), "fotoPerfil");
					usuario.setCaminho_Imagem(imagemUrl);
					usuarioRepository.save(usuario);
				}
			} catch(IOException e){
				e.printStackTrace();
			}
			
			return "redirect:/usuario/perfil/meusdados";
		}


		// // --------------------------------------- VISUALIZAR IMAGEM DE PERFIL ------------------------------------------------------
		@GetMapping("/imagem/{id}")
        public ResponseEntity<Resource> downloadImage(Usuario usuario) {
			usuario = usuarioService.getAuthenticatedUser();
            // String imageUrl = "https://suntech.eco.br/api/uploads/fotoPerfil" + usuario.getId() + ".png";
			String imageUrl = usuario.getCaminho_Imagem();
            Resource image = fotoService.getImageFromApi(imageUrl);
    
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "image/png"); // Ajuste o tipo de conteúdo conforme necessário
    
            return new ResponseEntity<>(image, headers, HttpStatus.OK);
        }


	
}
