package persistence;

import java.sql.SQLException;

import exception.UsuarioException;
import model.Cadastro;
import model.Usuario;

public interface CadastroDao {
	
	Usuario insereCadastro(Cadastro cadastro) throws SQLException, UsuarioException;

}
