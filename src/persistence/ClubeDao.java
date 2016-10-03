package persistence;

import java.sql.SQLException;

import model.Clube;

public interface ClubeDao extends GenericDao<Clube> {
	
	Clube pesquisaUnico (int obj)throws SQLException;

}
