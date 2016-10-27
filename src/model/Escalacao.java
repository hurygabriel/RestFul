package model;

import java.util.List;

/**
 * Class responsável pelos atributos da escalação dos jogadores
 *  de um time para determinada partida de futebol
 * @author hury
 *
 */
public class Escalacao {

    private List<Jogador> titulares;
    private List<Jogador> reservas;
	private Clube clube;
	
	public List<Jogador> getTitulares() {
		return titulares;
	}
	public void setTitulares(List<Jogador> titulares) {
		this.titulares = titulares;
	}
	public List<Jogador> getReservas() {
		return reservas;
	}
	public void setReservas(List<Jogador> reservas) {
		this.reservas = reservas;
	}
	public Clube getClube() {
		return clube;
	}
	public void setClube(Clube clube) {
		this.clube = clube;
	}
	
	@Override
	public String toString() {
		return "Escalacao [titulares=" + titulares + ", reservas=" + reservas + ", clube=" + clube + "]";
	}
	
	
	
	
}
