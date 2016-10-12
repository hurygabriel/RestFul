package controller;

import java.sql.SQLException;
import java.util.List;

import model.Estadio;
import persistence.EstadioDao;
import persistence.EstadioDaoImpl;

/**
 * Classe responsável pelo controle do estaadio, junto a sua percistencia.
 * @author hury
 *
 */
public class EstadioCtrl {

	EstadioDao edao = new EstadioDaoImpl();
	
	public List<Estadio> listaTodos() throws SQLException{
		return edao.pesquisa();
	}
	
	public Estadio pesquisaUnico(String nome) throws SQLException{
		return edao.pesquisaUnico(nome);
	}
}
