package model;

import javax.xml.bind.annotation.XmlRootElement;

import enumeration.TipoContrato;

/**
 * 
 * @author hury
 *
 */

@XmlRootElement
public class Contrato {
	
	private int numero;
	private TipoContrato tipo;
	private String datainicio;
	private String datafim;
	private Clube clube;
	private Jogador jogador;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public TipoContrato getTipo() {
		return tipo;
	}
	public void setTipo(TipoContrato tipo) {
		this.tipo = tipo;
	}
	public String getDatainicio() {
		return datainicio;
	}
	public void setDatainicio(String datainicio) {
		this.datainicio = datainicio;
	}
	public String getDatafim() {
		return datafim;
	}
	public void setDatafim(String datafim) {
		this.datafim = datafim;
	}
	public Clube getClube() {
		return clube;
	}
	public void setClube(Clube clube) {
		this.clube = clube;
	}
	public Jogador getJogador() {
		return jogador;
	}
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
	@Override
	public String toString() {
		return "Contrato [numero=" + numero + ", tipo=" + tipo + ", datainicio=" + datainicio + ", datafim=" + datafim
				+ ", clube=" + clube + ", jogador=" + jogador + "]";
	}
	

	
	
	
}
