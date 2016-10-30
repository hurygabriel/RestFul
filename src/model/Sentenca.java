package model;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Atributos de uma sentnca a um jogador, time.
 * @author Thiago
 *
 */

@XmlRootElement
public class Sentenca {
	
	private BigDecimal valorPena;
	private int pontos;
	private Date dataSentenca;
	private String motivo;
	private String descricao;
	private int jogosPena;
	private int jogosPagos; // contador dos jogos que ja foram compridos;
	
	public BigDecimal getValorPena() {
		return valorPena;
	}
	public void setValorPena(BigDecimal valorPena) {
		this.valorPena = valorPena;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public Date getDataSentenca() {
		return dataSentenca;
	}
	public void setDataSentenca(Date dataSentenca) {
		this.dataSentenca = dataSentenca;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getJogosPena() {
		return jogosPena;
	}
	public void setJogosPena(int jogosPena) {
		this.jogosPena = jogosPena;
	}
	public int getJogosPagos() {
		return jogosPagos;
	}
	public void setJogosPagos(int jogosPagos) {
		this.jogosPagos = jogosPagos;
	}
	
	

}
