package org.deem.project.leisure.service;

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
}
