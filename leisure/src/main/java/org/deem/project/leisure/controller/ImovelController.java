package org.deem.project.leisure.controller;

import org.deem.project.leisure.model.Imovel;
import org.deem.project.leisure.model.Usuario;
import org.deem.project.leisure.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuario/perfil")
public class ImovelController {
	
	@Autowired
	private ImovelService service;
	
//				---------------------- CADASTRAR IMÓVEL ----------------------------- pazzzzzzzzzzzzzz
	@PostMapping("/cadastrar")
	public String cadastrarImovel(Imovel imovel, String mensagem, RedirectAttributes redirect) {
		boolean save = service.existsByCepAndNumero(imovel.getCep(), imovel.getNumero());
		
		if(save == false) { //VERIFICA SE OS DADOS DO IMÓVEL JÁ ESTÃO CADASTRADOS OU NÃO
		Imovel _imovel = service.save(imovel);
		redirect.addAttribute("imovel", _imovel);
		redirect.addFlashAttribute("mensagem", "Imóvel cadastrado com sucesso!");
		return "redirect:/usuario/perfil";
	}else {
		redirect.addFlashAttribute("mensagem", "Erro no cadastro \nEndereço do imóvel já cadastrado!");
		return "redirect:/usuario/perfil";
	}
}
	
//				--------------------- ATUALIZAR IMÓVEL -----------------------------------
	@PostMapping("/atualizar")
	public String atualizarImovel(Imovel imovel, String mensagem, RedirectAttributes redirect) {
		
		Imovel novoImovel = service.save(imovel);
		redirect.addAttribute("imovel", novoImovel);
		return "redirect:/usuario/perfil";
	}
	
//				----------------------- PÁGINA DE VISUALIZAÇÃO DOS IMÓVEIS ----------------	
	@GetMapping("/imovel")
	public String imovel(Usuario usuario, RedirectAttributes redirect) {
		if(usuario.getId() != 0) {
			return "/usuario/perfil"; //FALTA O ID DO FRAGMENTO DA TELA DOS IMÓVEIS
		}
		else {
			redirect.addFlashAttribute("mensagem", "Erro ao tentar acessar esta página. Faça login primeiro!");
			return "redirect:leisure/index";
		}
	}
	
// 				---------------------- DELETAR IMÓVEL ------------------------------------
	@GetMapping("/deletar-imovel")
	public String deletar(Imovel imovel, RedirectAttributes redirect) {
		redirect.addFlashAttribute("mensagem", "Imóvel deletado!");
		//imovel.setAtivo(false);
		service.save(imovel);
		
		return "redirect:/usuario/perfil/imovel";
	}
	

}
