package org.deem.project.leisure.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

    @OneToMany(mappedBy="usuario", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Imovel> imoveis = new ArrayList<>(); 
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="nascimento")
	private String data;
	
	@Column(name="email")
	private String email;
	
	@Column(name="senha")
	private String senha;

	@Column(name="senha_descriptografada")
	private String senha_descriptografada;
	
	@Column(name="celular")
	private String telefone;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="perfil_principal")
	private String role_usuario;
	

	// FetchType.EAGER => Busca também os relacionados
	// FetchType.Lazy => Traz somente o referido
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_perfil",
			   joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName="id"),
			   inverseJoinColumns = @JoinColumn(name = "id_perfil", referencedColumnName="id"))
	private Collection<Roles> roles;
	
	
	public Usuario() {
		
	}
	
	
	

	public Usuario(long id, List<Imovel> imoveis, String nome, String data, String email, String senha,
			String senha_descriptografada, String telefone, String cpf, String role_usuario, Collection<Roles> roles) {
		this.id = id;
		this.imoveis = imoveis;
		this.nome = nome;
		this.data = data;
		this.email = email;
		this.senha = senha;
		this.senha_descriptografada = senha_descriptografada;
		this.telefone = telefone;
		this.cpf = cpf;
		this.role_usuario = role_usuario;
		this.roles = roles;
	}




	public Usuario(long id,List<Imovel> imoveis, String nome, String data, String email, String senha, String telefone,
			String cpf,String role_usuario, Collection<Roles> roles) {
		this.id = id;
		this.imoveis = imoveis;
		this.nome = nome;
		this.data = data;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.cpf = cpf;
		this.role_usuario = role_usuario;
		this.roles = roles;
	}
	
	public Usuario(long id, String nome, String telefone, String cep, int numResidencia, String complemento,
			String role_usuario, Collection<Roles> roles) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.role_usuario = role_usuario;
		this.roles = roles;
	}




	public Usuario(String nome, String email, String senha, String cpf, Collection<Roles> roles) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.roles = roles;
	}


	public String getRole_usuario() {
		return role_usuario;
	}

	public void setRole_usuario(String role) {
		this.role_usuario = role;
	}

	public Collection<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.nome;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}




	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public String getSenha_descriptografada() {
		return senha_descriptografada;
	}




	public void setSenha_descriptografada(String senha_descriptografada) {
		this.senha_descriptografada = senha_descriptografada;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return id == other.id;
	}
	
	
	
}
