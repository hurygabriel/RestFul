package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionImpl;
import connection.GenericConnection;
import exception.UsuarioException;
import model.Cadastro;
import model.Usuario;

public class CadastroDaoImpl implements CadastroDao {

	private Connection c;

	public CadastroDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public boolean insereCadastro(Cadastro cadastro) throws SQLException, UsuarioException {
		UsuarioDao uDao = new UsuarioDaoImpl();
		Usuario usuario = new Usuario();
		
		uDao.criaUsuario(cadastro.getUsuario().getUsuario(), cadastro.getUsuario().getSenha());
		
		usuario = uDao.login(cadastro.getUsuario().getUsuario(), cadastro.getUsuario().getSenha());
		cadastro.setUsuario(usuario);
		String query = "INSERT INTO cadastro(nome, idUsuario, cpf, tipo, registro) VALUES (?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setString(1, cadastro.getNome());
		ps.setLong(2, cadastro.getUsuario().getId());
		ps.setString(3, cadastro.getCpf());
		ps.setString(4, cadastro.getTipo().name());
		ps.setString(5, cadastro.getRegistro());

		ps.execute();
		ps.close();
		return true;

	}

}
