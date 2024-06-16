package org.deem.project.leisure.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.deem.project.leisure.model.Imovel;
import org.deem.project.leisure.model.Usuario;
import org.deem.project.leisure.repository.UsuarioRepository;
import org.deem.project.leisure.service.FiltroService;
import org.deem.project.leisure.service.FotoService;
import org.deem.project.leisure.service.ImovelService;
import org.deem.project.leisure.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/leisure")
public class LeisureController {
	private static String pathImage = "src\\main\\resources\\Imagens\\ImagensImovel\\";
	@Autowired
	private UsuarioServiceImpl usuarioService;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ImovelService imovelService;

	@Autowired
	private FiltroService filtroService;

	@Autowired
	private FotoService fotoService;
	
	@GetMapping("/index")
	public String getIndex(Usuario usuario, RedirectAttributes redirect, Model model) {
		usuario = usuarioService.getAuthenticatedUser(); //Puxar os dados do usuário logado(se nulo, não há usuário logado)
		model.addAttribute("usuario", usuario);
		return "index";
	}
	@GetMapping("/pesquisa")
	public String getPesquisa(Usuario usuario, Model model) {
		usuario = usuarioService.getAuthenticatedUser(); //Puxar os dados do usuário logado(se nulo, não há usuário logado)
		model.addAttribute("usuario", usuario);
		return "anuncio";
	}
	@GetMapping("/premium")
	public String getPremium(Usuario usuario, Model model) {
		usuario = usuarioService.getAuthenticatedUser();
		model.addAttribute("usuario", usuario);
		return "premium";
	}
	
	@GetMapping("/duvidas")
	public String getDuvidas(Usuario usuario, Model model) {
		usuario = usuarioService.getAuthenticatedUser();
		model.addAttribute("usuario", usuario);
		return "duvidas";
	}

	@PostMapping("/filtragem")
	public String filtro(Usuario usuario, Long id,String tipo, Double precoMinimo, Double precoMaximo, String cidade, String bairro, Integer numQuartos,
						 String sustentabilidade, Double area, Integer vagasGaragem, Model model) {
		List<Imovel> imoveisFiltrados = filtroService.filtragemDeImoveis(tipo, precoMinimo, precoMaximo, cidade, bairro, numQuartos, sustentabilidade, area, vagasGaragem);
		usuario = usuarioService.getAuthenticatedUser();	
		model.addAttribute("imovelPorId", imoveisFiltrados);
		model.addAttribute("usuario", usuario);
		return "anuncio";
}

	@GetMapping("/filtragem")
	public String retorno(Model model, RedirectAttributes redirect){
		return "redirect:/leisure/index";
	}

	//ADICIONADO POR DANILO PARA TESTES
	@GetMapping("/detalhes-imovel/{id}")
	public String getDetalhesImovel(Usuario usuario, Model model,@PathVariable int id, Imovel imovel) {
		usuario = usuarioService.getAuthenticatedUser();
		imovel = imovelService.findById(id);
		model.addAttribute("usuario", usuario);
		model.addAttribute("imovel", imovel);
		return "detalhes-imovel";
	}

	@GetMapping("/login")
	public String getMethodName(Usuario usuario, Model model) {
		usuario = usuarioService.getAuthenticatedUser(); //Puxar os dados do usuário logado(se nulo, não há usuário logado)
		model.addAttribute("usuario", usuario);
		return "LoginCadastro";
	}


//----------------------------------------- VISUALIZAR FOTO(PARA USUÁRIOS NÃO LOGADOS) ---------------------------------------------
		@GetMapping("/imovel/imagem/{id}")
		public ResponseEntity<Resource> getImagem(@PathVariable int id, Usuario usuario, Imovel imovel) throws IOException {
			try{
			imovel = imovelService.findById(id);
			 String imageUrl = "https://suntech.eco.br/api/uploads/fotoImovel" + id + ".png";
            Resource image = fotoService.getImageFromApi(imageUrl);
    
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "image/*"); // Ajuste o tipo de conteúdo conforme necessário
			return new ResponseEntity<>(image, headers, HttpStatus.OK);
			}catch(Exception e){
				return null;
			}
			}
	
			
//--------------------------------------------- VERIFICAR SE OS DADOS JÁ ESTÃO CADDSTRADOS ---------------------------------------------------------------
	@PostMapping("/checar")
	public ResponseEntity<Map<String, Boolean>> checkField(@RequestBody Map<String, String> request){
		String field = request.get("field");
		String value = request.get("value");
		boolean exists = false;

		switch(field){
			case "email":
			exists = usuarioRepository.existsByEmail(value);
			break;

			case "telefone":
			exists = usuarioRepository.existsByTelefone(value.replaceAll("[^0-9]", ""));
			break;

			case "cpf":
			exists = usuarioRepository.existsByCpf(value.replaceAll("[^0-9]", ""));
			break;
		}
	
		Map<String, Boolean> response = new HashMap<>();
		response.put("exists",exists);
		return ResponseEntity.ok(response);
	}

}
