package org.deem.project.leisure.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.deem.project.leisure.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuarioController {
	private static List<Usuario> lista = new ArrayList<>();
	private static int proxId = 1;

	static {
		lista.add(new Usuario(1, "Marcelo", "@email.com", "11 970757430", "123.456.789-00", "rua 123", "senha123"));
	}
	

	// CRIAR USUÁRIO
	@GetMapping("/usuario/criar")
	public String novo(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario/criar-usuario";
	}

	// ATUALIZAR DADOS
	@GetMapping("/usuario/{id}/atualizar")
	public String atualizacao(@PathVariable int id, Model model, RedirectAttributes redirect) {
		Usuario usuario = buscarPorId(id);
		if (usuario != null) {
			model.addAttribute("usuario", usuario);
			return "usuario/criar-usuario";
		}
		redirect.addFlashAttribute("mensagem", "Usuario não existente");
		return "uasuario/criar-usuario";
	}

	// DELETAR USUÁRIO
	@GetMapping("/usuario/{id}/deletar")
	public ModelAndView deletar(@PathVariable int id, RedirectAttributes redirect) {
		ModelAndView modelView = new ModelAndView("redirect:/usuario/criar");
		if (id < proxId) {
			remover(id);
			redirect.addFlashAttribute("mensagem", "Usuario deletado com sucesso!");
			if (lista.size() == 0) {
				return modelView;
			}
		} else {
			redirect.addFlashAttribute("mensagem", "Usuário selecionado não existente!");
		}
		return modelView;
	}

	// MÉTODO PARA ANALISAR O ID
	public static Usuario buscarPorId(int id) {
		for (Usuario usuario : lista) {
			if (usuario.getId() == id) {
				return usuario;
			}
		}
		return null;
	}

//	@GETMAPPING("/LOGIN")
//	PUBLIC STRING LOGIN(MODEL MODEL) {
////		MODEL.ADDATTRIBUTE("LOGIN", LISTA);
//		RETURN "LOGIN/LOGIN";
//	}

// ---------------------------------------- MÉTODOS ------------------------------------//

	private static void remover(int id) {
		ListIterator<Usuario> iterator = lista.listIterator();
		while (iterator.hasNext()) {
			Usuario usuario = iterator.next();
			if (usuario.getId() == id) {
				iterator.remove();
				break;
			}
		}
	}

	public static void inserir(Usuario usuario) {
		usuario.setId(proxId++);
		lista.add(usuario);
	}

	public static void atualizar(Usuario usuario) {
		ListIterator<Usuario> iterator = lista.listIterator();
		while (iterator.hasNext()) {
			Usuario usuario_desatualizado = iterator.next();
			if (usuario_desatualizado.getId() == usuario.getId()) {
				iterator.set(usuario);
				break;
			}
		}
	}

	public Usuario buscarUsuario(String nome, String senha) {
		ListIterator<Usuario> iterator = lista.listIterator();
		while (iterator.hasNext()) {
			Usuario usuario = iterator.next();
			if (nome.equals(usuario.getNome()) && senha.equals(usuario.getSenha())) {
				return usuario;
			}
		}
		return null;
	}

//-------------------- MÉTODO CHAMADO ATRAVÉS DO FORM ACTION E METHOD, NO HTML --------//
	@PostMapping("/login/cadastrar-atualizar")
	public ModelAndView criarOuAtualizar(Usuario usuario, RedirectAttributes redirect) {
		ModelAndView modelView = new ModelAndView("usuario/login");
		if (usuario.getId() == 0) {
			inserir(usuario);
			redirect.addFlashAttribute("mensagem", "Usuario criado com sucesso!");
		} else {
			atualizar(usuario);
			redirect.addFlashAttribute("mensagem", "Usuario atualizado com sucesso!");
		}
//	redirect.addFlashAttribute("login", login);
		modelView.addObject("usuario", usuario);
		return modelView;
	}

	@GetMapping("login/usuarios")
	public ModelAndView usuarios() {
		ModelAndView modelView = new ModelAndView("usuario/usuarios");
		modelView.addObject("usuarios", lista);
		return modelView;
	}

	
	@GetMapping("/cadastro")
	public String cadastrar(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario/logar-ou-cadastrar";
	}
	
	@PostMapping("/cadastro")
	public String cadastro(@RequestParam String nome, @RequestParam String senha, Model model) {
//		ModelAndView modelView = new ModelAndView("/cadastro");
		Usuario usuarioEncontrado = buscarUsuario(nome, senha);
		if (usuarioEncontrado != null) {
			model.addAttribute("usuario", usuarioEncontrado);
			return "usuario/login";
		}
		return "usuario-senha-invalido";
	}

}
