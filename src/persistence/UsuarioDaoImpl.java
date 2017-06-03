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
	public Usuario login(String usuario, String senha) throws SQLException, UsuarioException {
		Chave chave = new Chave();
		Usuario u = new Usuario();
		String query = "SELECT id, usuario, senha, datacriacao FROM usuario WHERE usuario = ? and senha = ?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, usuario);
		ps.setString(2, senha);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			u.setId(rs.getLong("id"));
			u.setUsuario(rs.getString("usuario"));
			u.setDataCriacao(rs.getDate("datacriacao"));
			u.setChave(chave.gerarChave());
			
			insereChave(u);
		}else{
			throw new UsuarioException("Aten��o!! Usu�rio n�o cadastrado no sistema");
		}
		
		ps.close();
		return u;
	}

	@Override
	public void logoff(Usuario usuario) throws SQLException {
		String query = "UPDATE usuario SET chave = '' WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setLong(1, usuario.getId());
		ps.execute();
		ps.close();

	}

	@Override
	public void insereChave(Usuario usuario) throws SQLException {
		String query = "UPDATE usuario SET chave = ? WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, usuario.getChave());
		ps.setLong(2, usuario.getId());
		ps.execute();
		ps.close();
	}

}
