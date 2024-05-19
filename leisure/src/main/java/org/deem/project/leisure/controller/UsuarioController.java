package org.deem.project.leisure.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.deem.project.leisure.model.Usuario;
//import org.deem.project.leisure.repository.UsuarioRepository;
import org.deem.project.leisure.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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
	private UsuarioService usuarioService;

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
		@PostMapping("/deletar")
		public String deletar(@RequestParam(value = "id") Long id, RedirectAttributes redirect) {
			Usuario usuario = usuarioService.findById(id);
			usuarioService.deleteById(id);
			return "redirect:/usuario/logout";
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
			Usuario usuario_ = usuarioService.findById(usuario.getId());
			try {
				if(!file.isEmpty()) {
					byte[] bytes = file.getBytes();
					Path caminho = Paths.get(pathImage + String.valueOf(usuario_.getId()) +"fotoPerfil.png");
					Files.write(caminho, bytes);
					usuarioService.atualizar(usuario, usuario_);
				}
			} catch(IOException e){
				e.printStackTrace();
			}
			
			return "redirect:/usuario/perfil/meusdados";
		}


		// --------------------------------------- VISUALIZAR IMAGEM DE PERFIL ------------------------------------------------------
		@GetMapping("/imagem/{id}")
		public ResponseEntity<byte[]> getImagem(@PathVariable int id, Usuario usuario) throws IOException {
			Usuario usuario_ = usuarioService.findById(id);
			String path = pathImage + usuario_.getId() + "fotoPerfil.png";
			Path caminho = Paths.get(path);
			byte[] bytes = Files.readAllBytes(caminho);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.IMAGE_PNG);
			return new ResponseEntity<>(bytes, header, HttpStatus.OK);
			}


	
}
