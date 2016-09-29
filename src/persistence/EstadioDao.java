package persistence;

import java.sql.SQLException;

import model.Estadio;

public interface EstadioDao extends GenericDao<Estadio>{

	
	Estadio pesquisaUnico(String obj) throws SQLException ;

	
	
}
