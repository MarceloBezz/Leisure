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
	@JoinColumn(name="USUARIO", nullable = false)
	public Usuario usuario;
	
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
	
	@Column(name="TIPO")
	private String tipo;
	
	@Column(name="SUSTENTABILIDADE")
	private String sustentabilidade;
	
	public Imovel() {	
	}
	
	public Imovel(long id, Usuario usuario, int numQuartos, int numBanheiros, int vagasGaragem, int cep, String rua,
			String cidade, String estado, int numero, String descricao, int valor, String tipo, String sustentabilidade) {
		super();
		this.id = id;
		this.usuario = usuario;
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
		this.tipo = tipo;
		this.sustentabilidade = sustentabilidade;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSustentabilidade() {
		return sustentabilidade;
	}

	public void setSustentabilidade(String sustentabilidade) {
		this.sustentabilidade = sustentabilidade;
	}

	
	

}
