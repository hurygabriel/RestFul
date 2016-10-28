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

	/**
	 * CRUD Incluir.
	 * @param obj
	 * @throws SQLException
	 */
	void inclui(T obj) throws SQLException;

	/**
	 * CRUD Pesquisar.
	 * @return
	 * @throws SQLException
	 */
	List<T> pesquisa() throws SQLException;
	
	/**
	 * CRUD Alterar.
	 * @param obj
	 * @throws SQLException
	 */
	void altera(T obj) throws SQLException;

	/**
	 * CRUD Excluir.
	 * @param obj
	 * @throws SQLException
	 */
	void exclui(T obj) throws SQLException;

	

}
