package org.deem.project.leisure.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import org.deem.project.leisure.model.Roles;
import org.deem.project.leisure.model.Usuario;
import org.deem.project.leisure.repository.RoleRepository;
import org.deem.project.leisure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//@Lazy
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	//Método utilizado pelo Spring para validar o usuário quando ele
	//tenta acessar um recurso protegido
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Nome de usuário ou senha inválido(s)");
		}
		return new org.springframework.security.core.userdetails.User(usuario.getEmail(), 
                usuario.getPassword(), mapRolesToAuthorities(usuario.getRoles()));
	}

	
	//Método para o Security verificar quais roles são usadas na validação do usuário
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Roles> roles) {		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}

	
	//MÉTODO PARA SALVAR USUÁRIO
	@Override
	public Usuario save(Usuario usuario) {
		usuario = new Usuario(usuario.getId(),
							  usuario.getImoveis(),
							  usuario.getNome(),
							  usuario.getData(),
							  usuario.getEmail(),
							  passwordEncoder.encode(usuario.getSenha()),
							  usuario.getTelefone(),
							  usuario.getCpf(),
							  usuario.getRole_usuario(),
							  new ArrayList<>(),
							  usuario.getNomeImagem()); 
		usuario.setRole_usuario("ROLE_USER");
		usuarioRepository.save(usuario);
		this.addRoleToUser(usuario.getEmail(), "ROLE_USER");
		return usuario;
	}
	
	@Override
	public Usuario atualizar(Usuario usuario) {
		usuarioRepository.save(usuario);
		return usuario;
	}


	//ADICIONAR A ROLE DO USUÁRIO NA TABELA ASSOCIATIVA
	@Override
	public void addRoleToUser(String email, String roleName) {
		Usuario usuario = usuarioRepository.findByEmail(email);
	 	Roles role = roleRepository.findByName(roleName);
		
		usuario.getRoles().add(role);
		usuarioRepository.save(usuario);
	}
	
	
	//OBTER OS DADOS DO USUÁRIO AUTENTICADO
	@Override
	public Usuario getAuthenticatedUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if(principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}else {
			username = principal.toString();
		}
		Usuario usuario = usuarioRepository.findByEmail(username);
		return usuario;
	}

	@Override
	public Usuario findByNome(String nome) {
		return usuarioRepository.findByNome(nome);
	}

	@Override
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	@Override
	public Roles saveRole(Roles role) {
		return roleRepository.save(role);
	}
	
	@Override
	public Usuario findById(long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public Usuario findByEmailAndSenha(String email, String senha) {
		return usuarioRepository.findByEmailAndSenha(email, senha);
	}

	@Override
	public void delete(Long id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public void takeOffMask(Usuario usuario) {
		String email = usuario.getEmail().trim();
		usuario.setEmail(email);
		String cpf = usuario.getCpf().replaceAll("[^0-9]", "");
		usuario.setCpf(cpf);
		String telefone = usuario.getTelefone().replaceAll("[^0-9]", "");
		usuario.setTelefone(telefone);
	}

	@Override
	public boolean existsByEmailOrCpf(Usuario usuario) {
		String email = usuario.getEmail();
		String cpf = usuario.getCpf();
		
		List<Usuario> usuarioByEmailOrCpf = usuarioRepository.findByEmailOrCpf(email, cpf);
		for (Usuario _usuario : usuarioByEmailOrCpf) {
			if (_usuario != null && _usuario.getId() != usuario.getId() ) {
				return false; //NÃO EXISTE
			}
		}	
		return true; //EXISTE
	}

	@Override
	public void atualizacao(Usuario usuarioDes, Usuario usuarioNovo) {
		//COMPLETAR
	}

}
