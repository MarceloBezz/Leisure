package org.deem.project.leisure.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

import org.deem.project.leisure.model.Roles;
import org.deem.project.leisure.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService extends UserDetailsService{
	Usuario findById(long id);
	Usuario findByEmailAndSenha(String email, String senha);
	Usuario save(Usuario usuario);
	void deleteById(Long id);
	void takeOffMask(Usuario usuario);
	boolean existsByEmailOrCpf(Usuario usuario);
	void atualizacao(Usuario usuarioDes, Usuario usuarioNovo);
	void addRoleToUser(String email, String roleName);
	Usuario findByNome(String nome);
	Usuario findByEmail(String email);
	Roles saveRole(Roles role);
	Usuario getAuthenticatedUser();
	Usuario atualizar(Usuario usuarioDes, Usuario usuarioAtt);
	List<Usuario> findAll();
}
