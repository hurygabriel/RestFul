package controller;

import java.sql.SQLException;
import java.util.List;

import model.Contrato;
import persistence.ContratoDao;
import persistence.ContratoDaoImpl;

public class ContratoCtrl {

	ContratoDao cdao = new ContratoDaoImpl();
	
	public List<Contrato>listaTodos()throws SQLException{
		return cdao.pesquisa();
	}
	
	
}
