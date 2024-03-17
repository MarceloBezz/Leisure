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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
//	---------------------------------------------- CADASTRO E ATUALIZAÇÃO DE DADOS ------------------------------------------
	@PostMapping("/cadastrar-atualizar")
	public String cadastrarOuAtualizar(Long id, Usuario usuario,@RequestParam(name = "foto_perfil", required = false)MultipartFile fotoPerfil, String mensagem, String redirecionamento, RedirectAttributes redirect,HttpSession session) throws IOException {
		
//		CADASTRO
		if (usuario.getId() == 0) {
			if (service.existsByEmailOrCpf(usuario)) {
				redirect.addFlashAttribute("mensagem", "Cadastro realizado com sucesso.\nSeja bem vindo, " + usuario.getNome());
			} else {
				redirect.addFlashAttribute("mensagem", "Não foi possível concluir seu cadastro.\nEmail ou cpf já está sendo usado.");
				return "redirect:/leisure/index";
			}	
		} 
		
//		ATUALIZAÇÃO
		else {
			if (service.existsByEmailOrCpf(usuario)) {
				redirect.addFlashAttribute("mensagem", "Atualização realizada com sucesso.");
			} else {
				redirect.addFlashAttribute("mensagem", "Não foi possível realizar a atualização.\nEmail ou cpf já está sendo usado.");
				redirect.addAttribute("usuario", usuario);
			}
		}
		
//		SALVAMENTO DOS DADOS
		if (service.existsByEmailOrCpf(usuario)) {
			service.save(usuario);
			redirect.addAttribute("usuario", usuario);
			session.setAttribute("user", usuario);
		}		
		return "redirect:/usuario/perfil";
	}
	
// ------------------------------------------------ ATUALIZAR DADOS ---------------------------------------------------------
	@PostMapping("/atualizacao")
	public String updateAll(RedirectAttributes redirect, 
							Usuario usuario, 
							@RequestParam(name = "fotoPerfil", required = false) MultipartFile fotoPerfil,
							String mensagem) throws IOException {
		
//		MUDAR SOMENTE FOTO DE PERFIL
		if(fotoPerfil != null) {
			Usuario usuarioBd = service.findById(usuario.getId());
			usuarioBd.setFoto_perfil(fotoPerfil.getBytes());
			 service.save(usuarioBd);
			 redirect.addAttribute("usuario", usuarioBd);
			 return "redirect:/usuario/perfil";
		}

		Usuario usuarioBD = service.findById(usuario.getId());
		service.atualizacao(usuario, usuarioBD); //PASSAR OS DADOS ENVIADOS DO FORMS PARA O BANCO
		service.save(usuarioBD);
		redirect.addAttribute("usuario", usuarioBD);
		redirect.addFlashAttribute("mensagem", "Dados atualizados com sucesso!");
		return "redirect:/usuario/perfil";
		
	}
//	------------------------------------------------ LOGIN ------------------------------------------------------------------
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam(value="email") String email, @RequestParam(value="senha") String senha, RedirectAttributes redirect) {
		Usuario usuario = service.findByEmailAndSenha(email, senha);
		if (usuario != null) {
			redirect.addFlashAttribute("mensagem", "Seja bem vindo, " + usuario.getNome());
			redirect.addAttribute("usuario", usuario);
			session.setAttribute("user", usuario);
			return "redirect:/usuario/perfil";
		}
		redirect.addFlashAttribute("mensagem", "Email ou senha inválidos.\nCertifique-se de que seus dados estão corretos.");
		return "redirect:/leisure/index";
	}
	
	
//  ------------------------------------------- ACESSO AO PERFIL ------------------------------------------------------------
	@GetMapping("/perfil")
	public String getPerfil(Usuario usuario, RedirectAttributes redirect) {
		if( usuario.getId() == 0) {
		redirect.addFlashAttribute("mensagem", "Erro ao tentar acessar esta página. Faça login primeiro!");
		return "redirect:/leisure/index";
		}else {
			//redirect.addAttribute("usuario", usuario);
			return "perfil";
		}
	} 
	
//  ------------------------------------------- DELETAR USUÁRIO -------------------------------------------------------------	
	@PostMapping("/deletar/{id}")
	public String deletar(@PathVariable(value = "id") Long id, RedirectAttributes redirect) {
		Usuario usuario = service.findById(id);
		if (usuario != null) {
			redirect.addFlashAttribute("mensagem", "Sua conta foi deletada!");
			service.delete(usuario.getId());
		} else {
			redirect.addFlashAttribute("mensagem", "Este usuário não existe.\nVerifique se os dados estão corretos.");
		}
		return "redirect:/leisure/index";
	}  
	
// --------------------------------------- VISUALIZAR IMAGEM DE PERFIL ------------------------------------------------------
	@GetMapping("/imagem/{id}")
	public ResponseEntity<byte[]> getImagem(@PathVariable int id) {
		Usuario usuario = service.findById(id);
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<>(usuario.getFoto_perfil(), header, HttpStatus.OK);
	}
	
// ------------------------------------------ LOGOUT ----------------------------------------------------------------------
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		//session.invalidate();
		return "redirect:/leisure/index";
	}
}
