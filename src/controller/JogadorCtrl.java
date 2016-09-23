package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Jogador;
import persistence.GenericDao;
import persistence.JogadorDao;
import persistence.JogadorDaoImpl;

public class JogadorCtrl {

	JogadorDao jdao = new JogadorDaoImpl();
	
	public List<Jogador> listaTodos() throws SQLException{
		
		return jdao.pesquisa();
	}

	
	
}
