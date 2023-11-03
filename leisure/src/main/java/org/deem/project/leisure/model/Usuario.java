package org.deem.project.leisure.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="DATA")
	private String data;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="SENHA")
	private String senha;
	
	@Column(name="TELEFONE")
	private String telefone;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="CEP_ENDERECO")
	private String cep;
	
	@Column(name="NUM_RESIDENCIA")
	private short numResidencia;
	
	@Column(name="COMPLEMENTO")
	private String complemento;
	
	@Column(name="ATIVO")
	private boolean ativo = true;
	
	public Usuario() {
	}

	public Usuario(long id, String nome, String data, String email, String senha, String telefone, String cpf, String cep,
			short numResidencia, String complemento, boolean ativo) {
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.cpf = cpf;
		this.cep = cep;
		this.numResidencia = numResidencia;
		this.complemento = complemento;
		this.ativo = ativo;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public short getNumResidencia() {
		return numResidencia;
	}

	public void setNumResidencia(short numResidencia) {
		this.numResidencia = numResidencia;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
