package model;

/**
 * Classe responsável pelos atributos do técnico de um clube
 * @author hury
 *
 */
public class Tecnico {

	private int id;
	private String nome;
	
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
	
	@Override
	public String toString() {
		return "Tecnico [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
}
