package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import enumeration.UF;
import model.Clube;
import model.Tecnico;

/**
 * Persistencia do tecnico de um clube.
 * 
 * @author hury
 *
 */
public class TecnicoDaoImpl implements TecnicoDao {

	private Connection c;

	public TecnicoDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public void inclui(Tecnico obj) throws SQLException {
		String query = "INSERT INTO tecnico VALUES (?)";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setString(1, obj.getNome());

		ps.execute();
		ps.close();

	}

	@Override
	public List<Tecnico> pesquisa() throws SQLException {
		List<Tecnico> lista = new ArrayList<Tecnico>();
		String query = "SELECT * FROM tecnico";

		PreparedStatement ps = c.prepareStatement(query);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Tecnico tec = new Tecnico();

			tec.setId(rs.getInt("id"));
			tec.setNome(rs.getString("nome"));

			lista.add(tec);
		}
		ps.close();
		return lista;

	}

	@Override
	public void altera(Tecnico obj) throws SQLException {
		String query = "UPDATE tecnico SET nome = ? WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setString(1, obj.getNome());
		ps.setInt(2, obj.getId());

		ps.execute();
		ps.close();

	}

	@Override
	public void exclui(Tecnico obj) throws SQLException {
		String query = "DELETE tecnico WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setInt(1, obj.getId());

		ps.execute();
		ps.close();

	}

	@Override
	public Tecnico pesquisaUnicoId(int id) throws SQLException {

		String query = "SELECT * FROM tecnico WHERE id = ?";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Tecnico tec = new Tecnico();

		if (rs.next()) {

			tec.setId(rs.getInt("id"));
			tec.setNome(rs.getString("nome"));
		}

		ps.close();
		return tec;
	}

	@Override
	public List<Tecnico> pesquisaNome(String nome) throws SQLException {
		
		List<Tecnico> lista = new ArrayList<Tecnico>();
		String query = "SELECT * FROM tecnico WHERE nome like ?";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + nome + "%");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Tecnico cb = new Tecnico();
			cb.setId(rs.getInt("id"));
			cb.setNome(rs.getString("nome"));
			lista.add(cb);
		}

		ps.close();
		return lista;
	}

}
