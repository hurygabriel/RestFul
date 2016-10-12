package persistence;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author hury
 *
 * @param <T>
 */
public abstract interface GenericDao<T> {

	void inclui(T obj) throws SQLException;

	List<T> pesquisa() throws SQLException;

	//T pesquisaUnico(Object obj) throws SQLException;
	
	void altera(T obj) throws SQLException;

	void exclui(T obj) throws SQLException;

	

}
