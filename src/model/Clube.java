package model;

import javax.xml.bind.annotation.XmlRootElement;

import enumeration.UF;

/**
 * Classe responsável por guardar os atributos de clube
 * 
 * @author hury
 *
 */

@XmlRootElement
public class Clube {

	private int id;
	private String dataFundacao;
	private String nome;
	private Estadio estadio;
	private UF uf;
	private Tecnico tecnico;
	private String caminhoimg;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(String dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public String getCaminhoimg() {
		return caminhoimg;
	}

	public void setCaminhoimg(String caminhoimg) {
		this.caminhoimg = caminhoimg;
	}

	@Override
	public String toString() {
		return "Clube [id=" + id + ", dataFundacao=" + dataFundacao + ", nome=" + nome + ", estadio=" + estadio
				+ ", uf=" + uf + ", tecnico=" + tecnico + ", caminhoimg=" + caminhoimg + "]";
	}



}
