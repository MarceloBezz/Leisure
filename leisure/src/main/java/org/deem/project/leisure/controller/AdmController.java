package org.deem.project.leisure.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.deem.project.leisure.model.Usuario;
import org.deem.project.leisure.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/adm")
public class AdmController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/index")
    public String getMethodName(Model model) {
        Usuario usuario = usuarioService.getAuthenticatedUser();
        List<Usuario> usuarios = usuarioService.findAll();
		model.addAttribute("usuario", usuario);
        model.addAttribute("selecao", "usuarios");
        model.addAttribute("listUsuarios", usuarios);
        return "perfil";
    }

    @PostMapping("/deletar/{id}")
	public ResponseEntity<Map<String, String>> deletar(@PathVariable Long id, RedirectAttributes redirect) throws IOException {
			Usuario usuario = usuarioService.findById(id);
			String usuarioNome = usuario.getNome();
			usuarioService.deleteById(id);
			
			Map<String, String> response = new HashMap<>();
			response.put("mensagem", "O usuário " + usuarioNome + "(id " + id + ") foi deletado com sucesso!");
			return ResponseEntity.ok(response);
		}
    
}
