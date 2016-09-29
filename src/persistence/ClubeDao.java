package persistence;

import java.sql.SQLException;

import model.Clube;

public interface ClubeDao extends GenericDao<Clube> {
	
	ClubeDao pesquisaUnico (String obj)throws SQLException;

}
