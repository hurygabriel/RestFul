package model;

import javax.xml.bind.annotation.XmlRootElement;

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

	@Override
	public String toString() {
		return "Clube [id=" + id + ", dataFundacao=" + dataFundacao + ", nome=" + nome + ", estadio=" + estadio + "]";
	}

}
