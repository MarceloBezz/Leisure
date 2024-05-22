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
import org.deem.project.leisure.service.ImovelService;
import org.deem.project.leisure.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
	public String getPremium() {
		return "premium";
	}
	
	@GetMapping("/duvidas")
	public String getDuvidas() {
		return "duvidas";
	}

	@PostMapping("/filtragem")
	public String filtro(Usuario usuario, Long id,String tipo, Double precoMinimo, Double precoMaximo, String cidade, String bairro, Integer numQuartos, Model model) {
		List<Imovel> imoveisFiltrados = filtroService.filtragemDeImoveis(tipo, precoMinimo, precoMaximo, cidade, bairro, numQuartos);
		usuario = usuarioService.getAuthenticatedUser();	
		model.addAttribute("imovelPorId", imoveisFiltrados);
		model.addAttribute("usuario", usuario);
		return "anuncio";
}

	@GetMapping("/filtragem")
	public String retorno(Model model, RedirectAttributes redirect){
		redirect.addFlashAttribute("get","Preencha o formulário de filtro para acessar o resultado da filtragem");
		return "redirect:/leisure/index";
	}

	@GetMapping("/login")
	public String getMethodName(Usuario usuario, Model model) {
		usuario = usuarioService.getAuthenticatedUser(); //Puxar os dados do usuário logado(se nulo, não há usuário logado)
		model.addAttribute("usuario", usuario);
		return "LoginCadastro";
	}


//----------------------------------------- VISUALIZAR FOTO(PARA USUÁRIOS NÃO LOGADOS) ---------------------------------------------
			@GetMapping("/imovel/imagem/{id}")
		public ResponseEntity<byte[]> getImagem(@PathVariable int id, Usuario usuario, Imovel imovel) throws IOException {
			try{
			imovel = imovelService.findById(id);
			String path = pathImage + imovel.getId() + "fotoImovel.png";
			Path caminho = Paths.get(path);
			byte[] bytes = Files.readAllBytes(caminho);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.IMAGE_PNG);
			return new ResponseEntity<>(bytes, header, HttpStatus.OK);
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

		System.out.println("Campo recebido: " + field);
        System.out.println("Valor recebido: " + value);


		switch(field){
			case "email":
			exists = usuarioRepository.existsByEmail(value);
			break;

			case "telefone":
			exists = usuarioRepository.existsByTelefone(value);
			break;

			case "cpf":
			exists = usuarioRepository.existsByCpf(value);
			break;
		}
	
		Map<String, Boolean> response = new HashMap<>();
		response.put("exists",exists);
		return ResponseEntity.ok(response);
	}

}
