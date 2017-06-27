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
	
	/**
	 * Lista de todos os jogadores cadastrados no banco de dados.
	 * @return
	 * @throws SQLException
	 */
	public List<Jogador> listaTodos() throws SQLException{
		return jdao.pesquisa();
	}

	/**
	 * Lista de jogadores pelo clube
	 * @param id do clube
	 * @return
	 * @throws SQLException
	 */
	public List<Jogador> listarPorClubeId(int id)throws SQLException{
		return jdao.pesquisaPorClube(id);
	}
	
	/**
	 * Lista de jogadores pelo clube
	 * @param nome do clube
	 * @return
	 * @throws SQLException
	 */
	public List<Jogador> listarPorClubeNome(String nome)throws SQLException{
		return jdao.pesquisaPorClube(nome);
	}
	
	/**
	 * Lista de jogadores pelo nome, parcial ou total.
	 * @param nome
	 * @return
	 * @throws SQLException
	 */
	public List<Jogador> listarPorNome(String nome)throws SQLException{
		return jdao.pesquisaPorNome(nome);
	}
	
	/**
	 * Lista de jogadores pela sua UF de origem
	 * @param uf
	 * @return
	 * @throws SQLException
	 */
	public List<Jogador> listarPorUF(String uf)throws SQLException{
		return jdao.pesquisaPorUF(uf);
	}
	
	/**
	 * Lista de jogadores por posisao de jogo
	 * @param posicao
	 * @return
	 * @throws SQLException
	 */
	public List<Jogador> listarPorPosicao(String posicao)throws SQLException{
		return jdao.pesquisaPorPosicao(posicao);
	}
	
	/**
	 * Pesquisa um unico jogador a partir de seu id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Jogador pesquisaUnico(int id) throws SQLException{
		return jdao.pesquisaUnico(id);
	}
	
	/**
	 * Inclui um jogador
	 * @param jog
	 * @throws SQLException
	 */
	public void inclui(Jogador jog) throws SQLException{
		jdao.inclui(jog);
	}
	
}
