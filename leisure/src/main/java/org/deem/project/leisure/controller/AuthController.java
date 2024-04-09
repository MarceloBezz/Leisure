package org.deem.project.leisure.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.deem.project.leisure.model.Usuario;
import org.deem.project.leisure.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario")
public class AuthController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	/*@GetMapping("/cadastrar")
	public String cadastro(Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "perfil";
	}*/
	
	@PostMapping("/cadastrar")
	public String registrar(Usuario usuario, RedirectAttributes redirect, Model model) {
		usuarioService.save(usuario);

	UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
		            usuario.getEmail(), usuario.getPassword(), usuario.getAuthorities());
		    Authentication authentication = authenticationManager.authenticate(authenticationToken);
		    SecurityContextHolder.getContext().setAuthentication(authentication);

		model.addAttribute("usuario", usuario);
		redirect.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso!");
		return "redirect:/usuario/perfil";
	}
	
	
}
