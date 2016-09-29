package model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Jogador {

	private String nome;
	private String apelido;
	private String datanasc;
	private float peso;
	private float altura;
	private String naturalidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	
	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", apelido=" + apelido + ", datanasc=" + datanasc + ", peso=" + peso
				+ ", altura=" + altura + ", naturalidade=" + naturalidade + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(altura);
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		result = prime * result + ((datanasc == null) ? 0 : datanasc.hashCode());
		result = prime * result + ((naturalidade == null) ? 0 : naturalidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + Float.floatToIntBits(peso);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (Float.floatToIntBits(altura) != Float.floatToIntBits(other.altura))
			return false;
		if (apelido == null) {
			if (other.apelido != null)
				return false;
		} else if (!apelido.equals(other.apelido))
			return false;
		if (datanasc == null) {
			if (other.datanasc != null)
				return false;
		} else if (!datanasc.equals(other.datanasc))
			return false;
		if (naturalidade == null) {
			if (other.naturalidade != null)
				return false;
		} else if (!naturalidade.equals(other.naturalidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Float.floatToIntBits(peso) != Float.floatToIntBits(other.peso))
			return false;
		return true;
	}

	
	
	
	
	
}
