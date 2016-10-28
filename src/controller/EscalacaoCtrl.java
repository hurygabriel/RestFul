package controller;

import java.sql.SQLException;
import java.util.List;
import model.Escalacao;
import persistence.EscalacaoDao;
import persistence.EscalacaoDaoImpl;

/**
 * Classe responsável pelo controle da escalacao de jogadores, junto a sua percistencia.
 * @author hury
 *
 */
public class EscalacaoCtrl {

	EscalacaoDao edao = new EscalacaoDaoImpl();
	
	/**
	 * Lista todas as escalações disponíveis no BD
	 * @return um List de Escalacao
	 * @throws SQLException
	 */
	public List<Escalacao> listaTodos() throws SQLException{
		return edao.pesquisa();
	}
	
	/**
	 * Pesquisa uma única escalaçao
	 * @param idEscalacao 
	 * @return retorna a Escalacao referende ao id fornecido
	 * @throws SQLException
	 */
	public Escalacao listaPorId(int idEscalacao) throws SQLException{
		return edao.pesquisaUnicoId(idEscalacao);
	}
	
	/**
	 * Pesquisa uma escalacao por clube
	 * @param idClube
	 * @return
	 * @throws SQLException
	 */
	
	// FIXME o retorno deve ser List<Escalacao> pois haverá mais de uma escalacao por clube
	public Escalacao listaPorClube(int idClube) throws SQLException{
		return edao.pesquisaPorClube(idClube);
	}
	
}
