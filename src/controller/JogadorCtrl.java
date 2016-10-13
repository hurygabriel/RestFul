package controller;

import java.sql.SQLException;
import java.util.List;

import model.Jogador;
import persistence.JogadorDao;
import persistence.JogadorDaoImpl;
/**
 * Classe responsável pelo controle do jogador, junto a sua percistencia.
 * @author hury
 *
 */
public class JogadorCtrl {

	JogadorDao jdao = new JogadorDaoImpl();
	
	public List<Jogador> listaTodos() throws SQLException{
		return jdao.pesquisa();
	}

	public List<Jogador> listarPorClube(int id)throws SQLException{
		return jdao.pesquisaPorClube(id);
	}
	
	public List<Jogador> listarPorNome(String nome)throws SQLException{
		return jdao.pesquisaPorNome(nome);
	}
	
	public List<Jogador> listarPorUF(String uf)throws SQLException{
		return jdao.pesquisaPorUF(uf);
	}
	
	public List<Jogador> listarPorPosicao(String posicao)throws SQLException{
		return jdao.pesquisaPorPosicao(posicao);
	}
	
}
