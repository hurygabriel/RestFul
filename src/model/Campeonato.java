
package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe responsável pelos atributos do campeonato
 * 
 * @author hury
 *
 */
@XmlRootElement
public class Campeonato {
	
	private int id;
	private String nome;
	private String ano;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	@Override
	public String toString() {
		return "Campeonato [id=" + id + ", nome=" + nome + ", ano=" + ano + "]";
	}
	
	
	
}
