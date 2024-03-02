package org.deem.project.leisure.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;

	//@JoinColumn(name="PROPRIETARIO_ID", nullable=true)
    @OneToMany(mappedBy="usuario", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Imovel> imoveis; 
	
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
	private int numResidencia;
	
	@Column(name="COMPLEMENTO", nullable=true)
	private String complemento;
	
	@Lob
	@Column(name="FOTO_PERFIL")
	private byte[] foto_perfil;
	
	public Usuario() {
	}

	public Usuario(long id, List<Imovel> imoveis, String nome, String data, String email, String senha, String telefone,
			String cpf, String cep, int numResidencia, String complemento, byte[] foto_perfil) {
		super();
		this.id = id;
		this.imoveis = imoveis;
		this.nome = nome;
		this.data = data;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.cpf = cpf;
		this.cep = cep;
		this.numResidencia = numResidencia;
		this.complemento = complemento;
		this.foto_perfil = foto_perfil;
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

	public int getNumResidencia() {
		return numResidencia;
	}

	public void setNumResidencia(int i) {
		this.numResidencia = i;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}

	public byte[] getFoto_perfil() {
		return foto_perfil;
	}

	public Usuario setFoto_perfil(byte[] foto_perfil) {
		this.foto_perfil = foto_perfil;
		return this;
	}
	
	
	
}
