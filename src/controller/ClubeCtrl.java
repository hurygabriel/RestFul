package controller;

import persistence.ClubeDao;
import persistence.ClubeDaoImpl;

import java.sql.SQLException;
import java.util.List;

import model.Clube;

/**
 * Classe responsável pelo controle dos clubes, junto a sua percistencia.
 * @author hury
 *
 */
public class ClubeCtrl {

	ClubeDao cdao = new ClubeDaoImpl();
	
	/**
	 * Lista todos os clubes cadastrados no banco de dados.
	 * @return
	 * @throws SQLException
	 */
	public List<Clube> listaTodos() throws SQLException{
		return cdao.pesquisa();
	}
	
	/**
	 * Lista de clubes a partir de um determinado nome, parcial ou total.
	 * @param nome
	 * @return
	 * @throws SQLException
	 */
	public List<Clube> listaPorNome(String nome) throws SQLException{
		return cdao.pesquisaNome(nome);
	}
	
	/**
	 * Lista de clubes a partir de um determinado ID referente ao registro no BD.
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Clube listaPorId(int id) throws SQLException{
		return cdao.pesquisaUnico(id);
	}
	
}
