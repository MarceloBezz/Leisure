package org.deem.project.leisure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="IMOVEL")
public class Imovel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="USUARIO" ,nullable = false)
	public Usuario usuario;
	
	@Column(name="NUM_QUARTOS")
	private int numQuartos;
	
	@Column(name="NUM_BANHEIROS")
	private int numBanheiros;
	
	@Column(name="VAGAS_GARAGEM")
	private int vagasGaragem;
	
	@Column(name="CEP")
	private String cep;
	
	@Column(name="BAIRRO")
	private String bairro;
	
	@Column(name="CIDADE")
	private String cidade;
	
	@Column(name="NUMERO")
	private int numero;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="PRECO")
	private Double preco;
	
	@Column(name="TIPO")
	private String tipo;
	
	@Column(name="SUSTENTABILIDADE")
	private String sustentabilidade;
	
	//@Column
	private double iptu;
	private double area;
	
	public Imovel() {	
	}
	
	public Imovel(long id, Usuario usuario, int numQuartos, int numBanheiros, int vagasGaragem, String cep,
			String bairro, String cidade, int numero, String descricao, Double preco, String tipo,
			String sustentabilidade, double iptu, double area) {
		this.id = id;
		this.usuario = usuario;
		this.numQuartos = numQuartos;
		this.numBanheiros = numBanheiros;
		this.vagasGaragem = vagasGaragem;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numero = numero;
		this.descricao = descricao;
		this.preco = preco;
		this.tipo = tipo;
		this.sustentabilidade = sustentabilidade;
		this.iptu = iptu;
		this.area = area;
	}







	public String getBairro() {
		return bairro;
	}




	public void setBairro(String bairro) {
		this.bairro = bairro;
	}




	public String getSustentabilidade() {
		return sustentabilidade;
	}

	public void setSustentabilidade(String sustentabilidade) {
		this.sustentabilidade = sustentabilidade;
	}

	public double getIptu() {
		return iptu;
	}

	public void setIptu(double iptu) {
		this.iptu = iptu;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	
	

}
