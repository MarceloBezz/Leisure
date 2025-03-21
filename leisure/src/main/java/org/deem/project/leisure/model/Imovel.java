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
@Table(name="imovel")
public class Imovel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="id_vendedor" ,nullable = false)
	public Usuario usuario;
	
	@Column(name="qtde_quarto")
	private Integer numQuartos;
	
	@Column(name="qtde_banheiro")
	private Integer numBanheiros;
	
	@Column(name="qtde_vaga_garagem")
	private Integer vagasGaragem;
	
	@Column(name="cep")
	private String cep;
	
	@Column(name="bairro")
	private String bairro;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="num_residencia")
	private Integer numero;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="preco")
	private Double preco;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="sustentabilidade")
	private String sustentabilidade;
	
	@Column(name="iptu")
	private Double iptu;
	
	@Column(name="area")
	private Integer area;

	@Column(name="caminho_imagem")
	private String caminho_imagem;
	
	
	public Imovel() {	
	}
	
	public Imovel(long id, Usuario usuario, Integer numQuartos, Integer numBanheiros, int vagasGaragem, String cep,
			String bairro, String cidade, int numero, String descricao, Double preco, String tipo,
			String sustentabilidade, double iptu, Integer area) {
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



	public String getCaminho_Imagem(){
		return caminho_imagem;
	}

	public void setCaminho_Imagem(String caminho_imagem){
		this.caminho_imagem = caminho_imagem;
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

	public Double getIptu() {
		return iptu;
	}

	public void setIptu(Double iptu) {
		this.iptu = iptu;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
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

	public Integer getNumQuartos() {
		return numQuartos;
	}

	public void setNumQuartos(Integer numQuartos) {
		this.numQuartos = numQuartos;
	}

	public Integer getNumBanheiros() {
		return numBanheiros;
	}

	public void setNumBanheiros(Integer numBanheiros) {
		this.numBanheiros = numBanheiros;
	}

	public Integer getVagasGaragem() {
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
	
	public Integer getNumero() {
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
