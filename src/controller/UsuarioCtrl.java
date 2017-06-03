package controller;

import java.sql.SQLException;

import exception.UsuarioException;
import model.Usuario;
import persistence.UsuarioDao;
import persistence.UsuarioDaoImpl;

public class UsuarioCtrl {
	
	UsuarioDao dao = new UsuarioDaoImpl();
	
	public Usuario login(String usuario, String senha) throws SQLException, UsuarioException{
		return dao.login(usuario, senha);
	}
	
	public void logoff(Usuario usuario) throws SQLException{
		dao.logoff(usuario);
	}

}
