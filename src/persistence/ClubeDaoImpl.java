package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import model.Clube;

public class ClubeDaoImpl implements ClubeDao{
	private Connection c;
	
	public ClubeDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	@Override
	public void inclui(Clube obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Clube> pesquisa() throws SQLException {
		List<Clube> lista = new ArrayList<Clube>();
		String query = "SELECT * FROM clube"; 
		
		PreparedStatement ps = c.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		EstadioDao edao = new EstadioDaoImpl();
		
		while (rs.next()) {
			Clube c = new Clube();
			//pesquisa o estadio, traz todos seus atributos
			c.setEstadio(edao.pesquisaUnico(rs.getString("estadio")));
			c.setId(rs.getInt("id"));
			c.setNome(rs.getString("nome"));
			c.setDataFundacao(rs.getString("dataFundacao"));
			
			lista.add(c);
		}
		
		ps.close();
		return lista;
	}

	@Override
	public void altera(Clube obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exclui(Clube obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Clube pesquisaUnico(int obj) throws SQLException {
		Clube cb = new Clube();
		String query = "SELECT * FROM clube WHERE id = ?";
		
		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, obj);
		ResultSet rs = ps.executeQuery();
		
		EstadioDao edao = new EstadioDaoImpl();
		if (rs.next()) {
			cb.setEstadio(edao.pesquisaUnico(rs.getString("estadio")));
			cb.setId(rs.getInt("id"));
			cb.setNome(rs.getString("nome"));
			cb.setDataFundacao(rs.getString("dataFundacao"));
		}
		
		ps.close();
		return cb;
	}

}
