package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Tecnico;

public interface TecnicoDao extends GenericDao<Tecnico> {

	Tecnico pesquisaUnicoId(int id)throws SQLException;
	List<Tecnico> pesquisaNome(String nome)throws SQLException;
	
}
