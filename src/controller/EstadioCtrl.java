package controller;

import java.sql.SQLException;
import java.util.List;

import model.Estadio;
import persistence.EstadioDao;
import persistence.EstadioDaoImpl;


public class EstadioCtrl {

	EstadioDao edao = new EstadioDaoImpl();
	
	public List<Estadio> listaTodos() throws SQLException{
		return edao.pesquisa();
	}
	
}
