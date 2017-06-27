package persistence;

import java.sql.SQLException;

import exception.UsuarioException;
import model.Cadastro;
public interface CadastroDao {
	
	boolean insereCadastro(Cadastro cadastro) throws SQLException, UsuarioException;

}
