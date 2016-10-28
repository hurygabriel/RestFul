package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Escalacao;
import model.Jogador;

public interface EscalacaoDao extends GenericDao<Escalacao> {

	List<Jogador> pesquisaTitulares(int idEscalacao)throws SQLException;
	List<Jogador> pesquisaReservas(int idEscalacao)throws SQLException;
	
	Escalacao pesquisaPorClube(int idClube)throws SQLException;
	Escalacao pesquisaUnicoId(int idEscalacao)throws SQLException;
}
