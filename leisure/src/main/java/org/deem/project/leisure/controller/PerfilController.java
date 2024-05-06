package org.deem.project.leisure.controller;


import java.util.List;
import org.deem.project.leisure.model.Imovel;
import org.deem.project.leisure.model.Usuario;
import org.deem.project.leisure.service.ImovelService;
import org.deem.project.leisure.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class PerfilController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ImovelService imovelService;
	
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
        
    
		List<Imovel> imovelPorId = imovelService.findByUsuarioId(usuario.getId());
		model.addAttribute("imovelPorId", imovelPorId);
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
