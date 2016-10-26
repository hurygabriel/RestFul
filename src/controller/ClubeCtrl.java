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
	
	public List<Clube> listaPorNome(String nome) throws SQLException{
		return cdao.pesquisaNome(nome);
	}
	
	public Clube listaPorId(int id) throws SQLException{
		return cdao.pesquisaUnico(id);
	}
	
}
