package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import model.Escalacao;


/**
 * 
 * @author hury
 *
 */
public class EscalacaoDaoImpl implements EscalacaoDao {

	private Connection c;
	
	public EscalacaoDaoImpl(){
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}
	
	
	@Override
	public void inclui(Escalacao obj) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Escalacao> pesquisa() throws SQLException {
		List<Escalacao> lista = new ArrayList<Escalacao>();
		String query = "SELECT * FROM escalacao";
		
		PreparedStatement ps = c.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			Escalacao e = new Escalacao();
			ClubeDao cb = new ClubeDaoImpl();
			
			e.setClube(cb.pesquisaUnico(rs.getInt("clube")));
			
		   // private List<Jogador> titulares;
		   // private List<Jogador> reservas;
		    //posicao camisa
			//private Clube clube;
			
			
			lista.add(e);
		}
		ps.close();
		return lista;
	}

	@Override
	public void altera(Escalacao obj) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void exclui(Escalacao obj) throws SQLException {
		// TODO Auto-generated method stub

	}

}
