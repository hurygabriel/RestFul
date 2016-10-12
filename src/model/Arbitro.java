package model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import enumeration.SituacaoJuiz;
import enumeration.UF;

/**
 * 
 * @author Thiago
 *
 */

@XmlRootElement
public class Arbitro {

	private int id;
	private String nome;
	private Date dataNascimento;
	private UF uf;
	private String ufDescricao;
	private SituacaoJuiz situacao;
	private String situaçãoDescritivo;
	
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
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public UF getUf() {
		return uf;
	}
	public void setUf(UF uf) {
		this.uf = uf;
	}
	public SituacaoJuiz getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoJuiz situacao) {
		this.situacao = situacao;
	}
	public String getUfDescricao() {
		return ufDescricao;
	}
	public void setUfDescricao(String ufDescricao) {
		this.ufDescricao = ufDescricao;
	}
	public String getSituaçãoDescritivo() {
		return situaçãoDescritivo;
	}
	public void setSituaçãoDescritivo(String situaçãoDescritivo) {
		this.situaçãoDescritivo = situaçãoDescritivo;
	}
	
	
}
