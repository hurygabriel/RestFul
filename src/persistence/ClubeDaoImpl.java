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

/**
 * Persistencia do clube
 * @author hury
 *
 */
public class ClubeDaoImpl implements ClubeDao {
	private Connection c;
	EstadioDao edao = new EstadioDaoImpl();
	TecnicoDao tdao = new TecnicoDaoImpl();

	public ClubeDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	
	@Override
	public void inclui(Clube obj) throws SQLException {
		String query = "INSERT INTO clube VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(query);


		ps.setString(1, obj.getDataFundacao());
		ps.setString(2, obj.getNome());
		ps.setString(3, obj.getEstadio().getNome());
		ps.setString(4, obj.getUf().name());
		ps.setInt(5, obj.getTecnico().getId());
		ps.setString(6, obj.getCaminhoimg());

		ps.execute();
		ps.close();
	}

	@Override
	public List<Clube> pesquisa() throws SQLException {
		List<Clube> lista = new ArrayList<Clube>();
		String query = "SELECT * FROM clube";

		PreparedStatement ps = c.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Clube cb = new Clube();
			// pesquisa o estadio, traz todos seus atributos
			cb.setEstadio(edao.pesquisaUnico(rs.getString("estadio")));
			cb.setId(rs.getInt("id"));
			cb.setNome(rs.getString("nome"));
			cb.setDataFundacao(rs.getString("dataFundacao"));
			cb.setUf(UF.valueOf(rs.getString("uf")));
			cb.setTecnico(tdao.pesquisaUnicoId(rs.getInt("tecnico")));
			cb.setCaminhoimg(rs.getString("caminhoimg"));
			
			lista.add(cb);
		}

		ps.close();
		return lista;
	}

	@Override
	public void altera(Clube obj) throws SQLException {
	
		String query = "UPDATE clube SET datafundacao = ?, nome = ?, estadio = ?,"
				+ " uf = ?, tecnico = ?, caminhoimg = ? WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(query);


		ps.setString(1, obj.getDataFundacao());
		ps.setString(2, obj.getNome());
		ps.setString(3, obj.getEstadio().getNome());
		ps.setString(4, obj.getUf().name());
		ps.setInt(5, obj.getTecnico().getId());
		ps.setString(6, obj.getCaminhoimg());
		ps.setInt(7, obj.getId());
		
		ps.execute();
		ps.close();
	}

	@Override
	public void exclui(Clube obj) throws SQLException {
		String query = "DELETE clube WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setInt(1, obj.getId());

		ps.execute();
		ps.close();
	}

	@Override
	public Clube pesquisaUnico(int obj) throws SQLException {
		Clube cb = new Clube();
		String query = "SELECT * FROM clube WHERE id = ?";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, obj);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			cb.setEstadio(edao.pesquisaUnico(rs.getString("estadio")));
			cb.setId(rs.getInt("id"));
			cb.setNome(rs.getString("nome"));
			cb.setDataFundacao(rs.getString("dataFundacao"));
			cb.setUf(UF.valueOf(rs.getString("uf")));
			cb.setTecnico(tdao.pesquisaUnicoId(rs.getInt("tecnico")));
			cb.setCaminhoimg(rs.getString("caminhoimg"));
		}

		ps.close();
		return cb;
	}

	@Override
	public List<Clube> pesquisaNome(String nome) throws SQLException {
		List<Clube> lista = new ArrayList<Clube>();
		String query = "SELECT * FROM clube WHERE nome like ?";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + nome + "%");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Clube cb = new Clube();
			// pesquisa o estadio, traz todos seus atributos
			cb.setEstadio(edao.pesquisaUnico(rs.getString("estadio")));
			cb.setId(rs.getInt("id"));
			cb.setNome(rs.getString("nome"));
			cb.setDataFundacao(rs.getString("dataFundacao"));
			cb.setUf(UF.valueOf(rs.getString("uf")));
			cb.setTecnico(tdao.pesquisaUnicoId(rs.getInt("tecnico")));
			cb.setCaminhoimg(rs.getString("caminhoimg"));
			
			lista.add(cb);
		}

		ps.close();
		return lista;
	}

}
