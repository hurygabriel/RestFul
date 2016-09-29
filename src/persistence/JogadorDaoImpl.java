package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import model.Jogador;

public class JogadorDaoImpl implements JogadorDao {
	private Connection c;
	
	public JogadorDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	
	//@Override
	public void inclui(Jogador obj) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Jogador> pesquisa() throws SQLException, ParseException {
		List<Jogador> lista = new ArrayList<Jogador>();
		String query = "SELECT * FROM jogador"; 

		PreparedStatement ps = c.prepareStatement(query);
		ResultSet rs = ps.executeQuery();


		while (rs.next()) {
			
			Jogador j = new Jogador();
			j.setNome(rs.getString("nome"));
			j.setApelido(rs.getString("apelido"));
			
			j.setDatanasc(rs.getDate("datanasc"));//TODO formatar
			
			j.setPeso(rs.getFloat("peso"));
			j.setAltura(rs.getFloat("altura"));
			j.setNaturalidade(rs.getString("naturalidade"));
			
			lista.add(j);
		}
		ps.close();

		return lista;
	}

	//@Override
	public void altera(Jogador obj) throws SQLException {
		// TODO Auto-generated method stub

	}

	//@Override
	public void exclui(Jogador obj) throws SQLException {
		// TODO Auto-generated method stub

	}

}
