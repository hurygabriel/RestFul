package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Clube;

public interface ClubeDao extends GenericDao<Clube> {
	
	Clube pesquisaUnico (int id)throws SQLException;
	
	List<Clube> pesquisaNome(String nome)throws SQLException;

}
