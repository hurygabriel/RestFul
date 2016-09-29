package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import model.Estadio;

public class EstadioDaoImpl {
	private Connection c;
	
	public EstadioDaoImpl(){
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	//pesquisa todos
	public List<Estadio> pesquisa() throws SQLException{
		List<Estadio> lista = new ArrayList<Estadio>();
		String query = "SELECT * FROM estadio";
		
		PreparedStatement ps = c.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			Estadio e = new Estadio();
			
			e.setNome(rs.getString("nome"));
			e.setCapacidade(rs.getInt("capacidade"));
			e.setDataInauguracao(rs.getString("dataInauguracao"));
			e.setEndereco(rs.getString("endereco"));
			e.setUf(rs.getString("uf"));
			
			lista.add(e);
		}
		ps.close();
		return lista;
	}
	
}
