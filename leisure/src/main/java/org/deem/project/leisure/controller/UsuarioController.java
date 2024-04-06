package org.deem.project.leisure.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.deem.project.leisure.model.Usuario;
import org.deem.project.leisure.repository.UsuarioRepository;
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
	
	private static String pathImage = "C:\\Leisure\\leisure-crud-main\\leisure\\src\\main\\resources\\imagens\\";
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

//	Página direcionada após o login bem sucedido		
	@GetMapping("/perfil")
	public String perfil(Model model) {		
		Usuario usuario = usuarioService.getAuthenticatedUser();
		model.addAttribute("usuario", usuario);
		return "perfil";
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
			
			Usuario usuarioBD = usuarioService.findById(usuario.getId());
			usuarioService.atualizacao(usuario, usuarioBD); //PASSAR OS DADOS ENVIADOS DO FORMS PARA O BANCO
			usuarioService.save(usuarioBD);
			redirect.addAttribute("usuario", usuarioBD);
			redirect.addFlashAttribute("mensagem", "Dados atualizados com sucesso!");
			return "redirect:/usuario/perfil";
			
	}
		
		@PostMapping("/salvar-foto")
		public String salvarFoto(Usuario usuario, @RequestParam("file") MultipartFile file, RedirectAttributes redirect) {
			Usuario usuario_ = usuarioService.findById(usuario.getId());
			try {
				if(!file.isEmpty()) {
					byte[] bytes = file.getBytes();
					Path caminho = Paths.get(pathImage + String.valueOf(usuario_.getId()) +"fotoPerfil.png");
					Files.write(caminho, bytes);
					
					usuario_.setNomeImagem(String.valueOf(caminho).replace(".png", ""));
					usuarioService.atualizar(usuario_);
				}
			} catch(IOException e){
				e.printStackTrace();
			}
			return "redirect:/perfil/meusdados";
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