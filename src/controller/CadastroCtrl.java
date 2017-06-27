package controller;

import java.sql.SQLException;

import exception.UsuarioException;
import model.Cadastro;
import persistence.CadastroDao;
import persistence.CadastroDaoImpl;

public class CadastroCtrl {
	
	CadastroDao cDao = new CadastroDaoImpl();
	
	public boolean insereCadastro(Cadastro cadastro) throws SQLException, UsuarioException{
			return cDao.insereCadastro(cadastro);
		
	}

}
