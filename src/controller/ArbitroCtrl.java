package controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import enumeration.SituacaoJuiz;
import enumeration.UF;
import model.Arbitro;
import persistence.ArbitroDao;
import persistence.ArbitroDaoImpl;

public class ArbitroCtrl {
	
	ArbitroDao aDao = new ArbitroDaoImpl();
	
	public List<Arbitro> listaTodos() throws SQLException, ParseException{
		return aDao.listaTodos();
	}
	
	public List<Arbitro> listaPorNome(String nome)throws SQLException, ParseException{
		return aDao.pesquisaPorNome(nome);
	}
	
	public List<Arbitro> listaPorUF(UF uf)throws SQLException, ParseException{
		return aDao.pesquisaPorUF(uf);
	}
	
	public List<Arbitro> listaPorSituacao(SituacaoJuiz situacao)throws SQLException, ParseException{
		return aDao.pesquisaPorSituacao(situacao);
	}
}
