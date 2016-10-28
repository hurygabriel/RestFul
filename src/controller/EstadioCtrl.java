package controller;

import java.sql.SQLException;
import java.util.List;

import model.Estadio;
import persistence.EstadioDao;
import persistence.EstadioDaoImpl;

/**
 * Classe responsável pelo controle do estadio, junto a sua percistencia.
 * @author hury
 *
 */
public class EstadioCtrl {

	EstadioDao edao = new EstadioDaoImpl();
	
	/**
	 * Retorna uma lista com todos os estadios cadastrados no banco de dados
	 * @return
	 * @throws SQLException
	 */
	public List<Estadio> listaTodos() throws SQLException{
		return edao.pesquisa();
	}
	
	/**
	 * Retorna um único Estadio, cadastrado no banco de dados, a partir de um nome fornecido
	 * @param nome
	 * @return
	 * @throws SQLException
	 */
	public Estadio pesquisaUnico(String nome) throws SQLException{
		return edao.pesquisaUnico(nome);
	}
}
