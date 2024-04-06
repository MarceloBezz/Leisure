package org.deem.project.leisure.controller;

import org.deem.project.leisure.model.Usuario;
import org.deem.project.leisure.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PerfilController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/perfil/anunciar")
    public String getAnunciar(Model model) {
		Usuario usuario = usuarioService.getAuthenticatedUser();
		model.addAttribute("usuario", usuario);
		model.addAttribute("selecao", "anunciar");        
        return "perfil";
    }
 
    @GetMapping("/perfil/anuncio")
    public String getAnuncio(Model model) {
    	Usuario usuario = usuarioService.getAuthenticatedUser();
		model.addAttribute("usuario", usuario);
        model.addAttribute("selecao", "anuncio");
        return "perfil";
    }
 
    @GetMapping("/perfil/meusdados")
    public String getMeusdados(Model model) {
    	Usuario usuario = usuarioService.getAuthenticatedUser();
		model.addAttribute("usuario", usuario);
        model.addAttribute("selecao", "meusdados");
        return "perfil";
    }
}
