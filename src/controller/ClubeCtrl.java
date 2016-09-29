package controller;

import persistence.ClubeDao;
import persistence.ClubeDaoImpl;

import java.sql.SQLException;
import java.util.List;

import model.Clube;

public class ClubeCtrl {

	ClubeDao cdao = new ClubeDaoImpl();
	
	public List<Clube> listaTodos() throws SQLException{
		return cdao.pesquisa();
	}
	
}
