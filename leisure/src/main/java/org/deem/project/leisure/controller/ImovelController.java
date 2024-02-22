package org.deem.project.leisure.controller;

import org.deem.project.leisure.model.Imovel;
import org.deem.project.leisure.repository.UsuarioRepository;
import org.deem.project.leisure.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario/perfil")
public class ImovelController {
	
	@Autowired
	private ImovelService service;
	
	

	public String cadastrarImovel(Imovel imovel, RedirectAttributes redirect) {
		boolean save = existsByCepAndNumero(imovel.getCep(), imovel.getNumero());
		if(save == false) {
		redirect.addFlashAttribute("mensagem", "Imóvel cadastrado com sucesso!");
		return "usuario/perfil";
	}else {
		redirect.addFlashAttribute("mensagem", "Endereço do imóvel já cadastrado!")
	}

}
	

}
