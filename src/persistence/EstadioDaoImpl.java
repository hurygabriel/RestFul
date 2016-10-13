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
import model.Estadio;

/**
 * 
 * @author hury
 *
 */
public class EstadioDaoImpl implements EstadioDao {
	private Connection c;
	
	public EstadioDaoImpl(){
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	//pesquisa todos
	@Override
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
			e.setUf(UF.valueOf(rs.getString("uf")));
			lista.add(e);
		}
		ps.close();
		return lista;
	}
	
	@Override
	public Estadio pesquisaUnico(String nome) throws SQLException{
		Estadio e = new Estadio();
		String query = "SELECT * FROM estadio WHERE nome LIKE ?";
		
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, nome);
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			e.setNome(rs.getString("nome"));
			e.setCapacidade(rs.getInt("capacidade"));
			e.setDataInauguracao(rs.getString("dataInauguracao"));
			e.setEndereco(rs.getString("endereco"));
			e.setUf(UF.valueOf(rs.getString("uf")));
		}
		
		ps.close();
		return e;
		
	}

	@Override
	public void inclui(Estadio obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void altera(Estadio obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exclui(Estadio obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
}
