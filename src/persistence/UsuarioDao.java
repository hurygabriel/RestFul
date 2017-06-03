package persistence;

import java.sql.SQLException;

import exception.UsuarioException;
import model.Usuario;

public interface UsuarioDao {
	
	Usuario login(Usuario usuario) throws SQLException, UsuarioException;
	void logoff(Usuario usuario) throws SQLException;
	
}
