package persistence;

import java.sql.SQLException;

import exception.UsuarioException;
import model.Usuario;

public interface UsuarioDao {
	
	Usuario login(String usuario, String senha) throws SQLException, UsuarioException;
	void logoff(Usuario usuario) throws SQLException;
	void insereChave(Usuario usuario) throws SQLException;
	boolean criaUsuario(String usuario, String senha) throws SQLException;
	
}
