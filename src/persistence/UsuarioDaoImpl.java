package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.ConnectionImpl;
import connection.GenericConnection;
import exception.UsuarioException;
import model.Usuario;
import util.Chave;

public class UsuarioDaoImpl implements UsuarioDao {
	
	private Connection c;
	
	public UsuarioDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public Usuario login(Usuario usuario) throws SQLException, UsuarioException {
		Chave chave = new Chave();
		String query = "SELECT id, usuario, senha, datacriacao FROM usuario WHERE usuario = ? and senha = ?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, usuario.getUsuario());
		ps.setString(2, usuario.getSenha());
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			usuario.setId(rs.getLong("id"));
			usuario.setDataCriacao(rs.getDate("datacriacao"));
			usuario.setChave(chave.gerarChave());
		}else{
			throw new UsuarioException("Atenção!! Usuário não cadastrado no sistema");
		}
		
		ps.close();
		return usuario;
	}

	@Override
	public void logoff(Usuario usuario) throws SQLException {
		String query = "DELETE chave FROM usuario WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setLong(1, usuario.getId());
		ps.execute();
		ps.close();

	}

}
