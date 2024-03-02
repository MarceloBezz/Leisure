package org.deem.project.leisure.service;

import java.util.List;

import org.deem.project.leisure.model.Usuario;
import org.deem.project.leisure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	private UsuarioRepository repository;
		
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	public Usuario findById(long id) {
		return repository.findById(id);
	}
	
	public Usuario findByEmailAndSenha(String email, String senha) {
		return repository.findByEmailAndSenha(email, senha);
	}
	
	public void takeOffMask(Usuario usuario) {
		String email = usuario.getEmail().trim();
		usuario.setEmail(email);
		String cpf = usuario.getCpf().replaceAll("[^0-9]", "");
		usuario.setCpf(cpf);
		String telefone = usuario.getTelefone().replaceAll("[^0-9]", "");
		usuario.setTelefone(telefone);
		String cep = usuario.getCep().replaceAll("[^0-9]", "");
		usuario.setCep(cep);
	}
	
	public boolean existsByEmailOrCpf(Usuario usuario) {
		String email = usuario.getEmail();
		String cpf = usuario.getCpf();
		
		List<Usuario> usuarioByEmailOrCpf = repository.findByEmailOrCpf(email, cpf);
		for (Usuario _usuario : usuarioByEmailOrCpf) {
			if (_usuario != null && _usuario.getId() != usuario.getId() ) {
				return false; //NÃO EXISTE
			}
		}	
		return true; //EXISTE
	}
	
	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}

	public void delete(Long id) {
	 repository.deleteById(id);
}
	
	public void atualizacao(Usuario usuarioDes, Usuario usuarioNovo) {
		if(usuarioDes.getCep() != null) {
			usuarioNovo.setCep(usuarioDes.getCep());
		}
		if(usuarioDes.getComplemento() != null) {
			usuarioNovo.setComplemento(usuarioDes.getComplemento());
		}
		if(usuarioDes.getTelefone() != null) {
			usuarioNovo.setTelefone(usuarioDes.getTelefone());
		}
		if(usuarioDes.getSenha() != null) {
			usuarioNovo.setSenha(usuarioDes.getSenha());
		}
	/*	if(usuarioDes.getNumResidencia() != null) {
			usuarioNovo.setNumResidencia(usuarioDes.getNumResidencia());
		}*/
}
	
}
