package org.deem.project.leisure.controller;

import java.util.List;

import org.deem.project.leisure.model.Imovel;
import org.deem.project.leisure.model.Usuario;
import org.deem.project.leisure.repository.UsuarioRepository;
import org.deem.project.leisure.service.ImovelService;
import org.deem.project.leisure.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/leisure")
public class LeisureController {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@Autowired
	private ImovelService imovelService;
	
	@GetMapping("/index")
	public String getIndex(Usuario usuario, RedirectAttributes redirect, Model model) {
		usuario = usuarioService.getAuthenticatedUser(); //Puxar os dados do usuário logado(se nulo, não há usuário logado)
		model.addAttribute("usuario", usuario);
		return "index";
	}
	@GetMapping("/pesquisa")
	public String getPesquisa() {
		return "anuncio";
	}
	@GetMapping("/premium")
	public String getPremium() {
		return "premium";
	}
	
	@GetMapping("/duvidas")
	public String getDuvidas() {
		return "duvidas";
	}
	
	@PostMapping("/filtragem")
	public List<Imovel> filtro(String tipo, Double precoMinimo, Double precoMaximo, String cidade, String bairro, Integer numQuartos) {
		List<Imovel> imoveisFiltrados = imovelService.filtragemDeImoveis(tipo, precoMinimo, precoMaximo, cidade, bairro, numQuartos);
		return imoveisFiltrados;
	}
	
}
