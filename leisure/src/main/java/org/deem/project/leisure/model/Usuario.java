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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario implements UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;

    @OneToMany(mappedBy="usuario", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Imovel> imoveis = new ArrayList<>(); 
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="NASCIMENTO")
	private String data;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="SENHA")
	private String senha;
	
	@Column(name="TELEFONE")
	private String telefone;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="PERFIL")
	private String role_usuario;
	
	@Column(name="CAMINHO_IMAGEM")
	private String nomeImagem;

	// FetchType.EAGER => Busca também os relacionados
	// FetchType.Lazy => Traz somente o referido
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USUARIO_PERFIL",
			   joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName="id"),
			   inverseJoinColumns = @JoinColumn(name = "id_perfil", referencedColumnName="id"))
	private Collection<Roles> roles;
	
	
	public Usuario() {
		
	}
	
	
	

	public Usuario(long id,List<Imovel> imoveis, String nome, String data, String email, String senha, String telefone,
			String cpf,String role_usuario, Collection<Roles> roles, String nomeImagem) {
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
		this.nomeImagem = nomeImagem;
	}
	
	public Usuario(long id, String nome, String telefone, String cep, int numResidencia, String complemento,
			String role_usuario, String nomeImagem, Collection<Roles> roles) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.role_usuario = role_usuario;
		this.nomeImagem = nomeImagem;
		this.roles = roles;
	}




	public Usuario(String nome, String email, String senha, String cpf, Collection<Roles> roles) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.roles = roles;
	}

	


	public String getNomeImagem() {
		return nomeImagem;
	}




	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
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
