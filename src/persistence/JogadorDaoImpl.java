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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
			
			//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			//String data = sdf.format(rs.getDate("datanasc"));
			//System.out.println(data);
			j.setDatanasc(rs.getString("datanasc"));
			
			j.setPeso(rs.getFloat("peso"));
			j.setAltura(rs.getFloat("altura"));
			j.setNaturalidade(rs.getString("naturalidade"));
			
			System.out.println(j.toString());
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
