package org.deem.project.leisure.controller;

import java.io.IOException;

import org.deem.project.leisure.model.Usuario;
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
	
	@Autowired
	private UsuarioService usuarioService;

//	Página direcionada após o login bem sucedido		
	@GetMapping("/perfil")
	public String perfil(Model model) {		
		Usuario usuario = usuarioService.getAuthenticatedUser();
		model.addAttribute("usuario", usuario);
		return "perfil";
	}
	
	// --------------------------------------- VISUALIZAR IMAGEM DE PERFIL ------------------------------------------------------
		@GetMapping("/imagem/{id}")
		public ResponseEntity<byte[]> getImagem(@PathVariable int id) {
			Usuario usuario = usuarioService.findById(id);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.IMAGE_PNG);
			return new ResponseEntity<>(usuario.getFoto_perfil(), header, HttpStatus.OK);
			}
		
	//  ------------------------------------------- DELETAR USUÁRIO -------------------------------------------------------------	
		@PostMapping("/deletar/{id}")
		public String deletar(@PathVariable(value = "id") Long id, RedirectAttributes redirect) {
			Usuario usuario = usuarioService.findById(id);
			if (usuario != null) {
				redirect.addFlashAttribute("mensagem", "Sua conta foi deletada!");
				usuarioService.delete(usuario.getId());
			} else {
				redirect.addFlashAttribute("mensagem", "Este usuário não existe.\nVerifique se os dados estão corretos.");
			}
			return "redirect:/leisure/index";
		}  
		
		// ------------------------------------------------ ATUALIZAR DADOS ---------------------------------------------------------
		@PostMapping("/atualizacao")
		public String updateAll(RedirectAttributes redirect, 
								Usuario usuario, 
								@RequestParam(name = "fotoPerfil", required = false) MultipartFile fotoPerfil,
								String mensagem) throws IOException {
			
//			MUDAR SOMENTE FOTO DE PERFIL
			if(fotoPerfil != null) {
				Usuario usuarioBd = usuarioService.findById(usuario.getId());
				usuarioBd.setFoto_perfil(fotoPerfil.getBytes());
				 usuarioService.save(usuarioBd);
				 redirect.addAttribute("usuario", usuarioBd);
				 return "redirect:/usuario/perfil";
			}

			Usuario usuarioBD = usuarioService.findById(usuario.getId());
			usuarioService.atualizacao(usuario, usuarioBD); //PASSAR OS DADOS ENVIADOS DO FORMS PARA O BANCO
			usuarioService.save(usuarioBD);
			redirect.addAttribute("usuario", usuarioBD);
			redirect.addFlashAttribute("mensagem", "Dados atualizados com sucesso!");
			return "redirect:/usuario/perfil";
			
	}

	
}