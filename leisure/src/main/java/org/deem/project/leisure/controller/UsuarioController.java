package org.deem.project.leisure.controller;

import org.deem.project.leisure.model.Usuario;
import org.deem.project.leisure.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
//	---------------------------------------------- CADASTRO E ATUALIZAÇÃO DE DADOS ------------------------------------------
	@PostMapping("/cadastrar-atualizar")
	public String cadastrarOuAtualizar(Usuario usuario, String mensagem, String redirecionamento, RedirectAttributes redirect) {
		service.takeOffMask(usuario);
		boolean save = service.existsByEmailOrCpf(usuario);
		
		if (usuario.getId() == 0) {
			if (save) {
				redirect.addFlashAttribute("mensagem", "Cadastro realizado com sucesso.\nSeja bem vindo, " + usuario.getNome());
			} else {
				redirect.addFlashAttribute("mensagem", "Não foi possível concluir seu cadastro.\nEmail ou cpf já está sendo usado.");
				return "redirect:/leisure/index";
			}
		} else {
			if (save) {
				redirect.addFlashAttribute("mensagem", "Atualização realizada com sucesso.");
			} else {
				redirect.addFlashAttribute("mensagem", "Não foi possível realizar a atualização.\nEmail ou cpf já está sendo usado.");
				redirect.addAttribute("usuario", usuario);
			}
		}
		
		if (save) {
			Usuario _usuario = service.save(usuario);
			redirect.addAttribute("usuario", _usuario);
		}
		
		return "redirect:/usuario/perfil";
	}

//	------------------------------------------------ LOGIN ------------------------------------------------------------------
	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String senha, RedirectAttributes redirect) {
		Usuario usuario = service.findByEmailAndSenha(email, senha);
		if (usuario != null && usuario.isAtivo() == true) {
			redirect.addFlashAttribute("mensagem", "Seja bem vindo, " + usuario.getNome());
			redirect.addAttribute("usuario", usuario);
			return "redirect:/usuario/perfil";
		}
		redirect.addFlashAttribute("mensagem", "Email ou senha inválidos.\nCertifique-se de que seus dados estão corretos.");
		return "redirect:/leisure/index";
	}
	
	
//  ------------------------------------------- ACESSO AO PERFIL ------------------------------------------------------------
	@GetMapping("/perfil")
	public String getPerfil(Usuario usuario, RedirectAttributes redirect) {
		if (usuario.getId() != 0) {
			return "usuario/perfil";
		}
		redirect.addFlashAttribute("mensagem", "Erro ao tentar acessar esta página. Faça login primeiro!");
		return "redirect:/leisure/index";
	}
	
//  ------------------------------------------- DELETAR USUÁRIO -------------------------------------------------------------	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletar(@PathVariable int id, RedirectAttributes redirect) {
		ModelAndView modelView = new ModelAndView("redirect:/leisure/index");
		Usuario usuario = service.findById(id);
		if (usuario != null && usuario.isAtivo() == true) {
			redirect.addFlashAttribute("mensagem", "Sua conta foi deletada!");
			usuario.setAtivo(false);
			service.save(usuario);
		} else {
			redirect.addFlashAttribute("mensagem", "Este usuário não existe.\nVerifique se os dados estão corretos.");
		}
		return modelView;
	}  
	
// --------------------------------------- VISUALIZAR DADOS DAS CONTAS ------------------------------------------------------
	@GetMapping("/contas")
	public ModelAndView usuarios() {
		ModelAndView modelView = new ModelAndView("usuario/usuario-beta/usuarios");
		modelView.addObject("usuarios", service.findAll());
		return modelView;
	}

	
	
	
	
	
	
	
	/* 
	// ATUALIZAR DADOS
	@GetMapping("/usuario/{id}/atualizar")
	public String atualizacao(@PathVariable int id, Model model, RedirectAttributes redirect) {
		Usuario usuario = buscarPorId(id);
		if (usuario != null) {
			model.addAttribute("usuario", usuario);
			return "usuario/perfil";
		}
		redirect.addFlashAttribute("mensagem", "Usuario não existente");
		return "usuario/perfil";
	}

//-------------------- MÉTODO CHAMADO ATRAVÉS DO FORM ACTION E METHOD, NO HTML --------//
	
	@GetMapping("/cadastro")
	public String cadastrar(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario/meus-dados";
	} */
}
