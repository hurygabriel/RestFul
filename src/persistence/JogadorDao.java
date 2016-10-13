package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Jogador;

public interface JogadorDao extends GenericDao<Jogador> {

	Jogador pesquisaUnico(int obj) throws SQLException;
	
	List<Jogador> pesquisaPorClube(int id) throws SQLException; 
	List<Jogador> pesquisaPorClube(String nome) throws SQLException; 
	List<Jogador> pesquisaPorNome(String nome)throws SQLException; 
	List<Jogador> pesquisaPorUF(String uf)throws SQLException; 
	List<Jogador> pesquisaPorPosicao(String posicao)throws SQLException; 
	
}
