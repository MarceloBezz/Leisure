package org.deem.project.leisure.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="IMOVEL")
public class Imovel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="PROPRIETARIO")
	public Usuario proprietario;
	
	@Column(name="NUM QUARTOS")
	private int numQuartos;
	
	@Column(name="NUM BANHEIROS")
	private int numBanheiros;
	
	@Column(name="VAGAS GARAGEM")
	private int vagasGaragem;
	
	@Column(name="CEP")
	private int cep;

	@Column(name="RUA")
	private String rua;
	
	@Column(name="CIDADE")
	private String cidade;
	
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name="NUMERO")
	private int numero;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="VALOR")
	private int valor;
	
	@Column(name="ATIVO")
	private boolean ativo = true;
	
	public Imovel() {	
	}
	
	public Imovel(long id, Usuario proprietario, int numQuartos, int numBanheiros, int vagasGaragem, int cep,
			String rua, String cidade, String estado, int numero, String descricao, int valor, boolean ativo) {
		this.id = id;
		this.proprietario = proprietario;
		this.numQuartos = numQuartos;
		this.numBanheiros = numBanheiros;
		this.vagasGaragem = vagasGaragem;
		this.cep = cep;
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
		this.descricao = descricao;
		this.valor = valor;
		this.ativo = ativo;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}

	public int getNumQuartos() {
		return numQuartos;
	}

	public void setNumQuartos(int numQuartos) {
		this.numQuartos = numQuartos;
	}

	public int getNumBanheiros() {
		return numBanheiros;
	}

	public void setNumBanheiros(int numBanheiros) {
		this.numBanheiros = numBanheiros;
	}

	public int getVagasGaragem() {
		return vagasGaragem;
	}

	public void setVagasGaragem(int vagasGaragem) {
		this.vagasGaragem = vagasGaragem;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	
	

}
