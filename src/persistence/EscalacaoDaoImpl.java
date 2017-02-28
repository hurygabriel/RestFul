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
import model.Jogador;

/**
 * Persistencia da escalação de jogadores, de um clube, a uma partida.
 * @author hury
 *
 */
public class EscalacaoDaoImpl implements EscalacaoDao {

	private Connection c;
	JogadorDao jdao = new JogadorDaoImpl();
	ClubeDao cb = new ClubeDaoImpl();
	
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

			e.setClube(cb.pesquisaUnico(rs.getInt("clube")));
			e.setTitulares(pesquisaTitulares(rs.getInt("id")));
			e.setReservas(pesquisaReservas(rs.getInt("id")));
			e.setData(rs.getString("data"));

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
		

	}


	@Override
	public List<Jogador> pesquisaTitulares(int idEscalacao) throws SQLException {
		
		List<Jogador> lista = new ArrayList<Jogador>();
		String query = "SELECT * FROM listajog WHERE idescalacao = ? and posto LIKE ?";
		
		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, idEscalacao);
		ps.setString(2, "TITULAR");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			Jogador jog = new Jogador(); 
			
			jog = jdao.pesquisaUnico(rs.getInt("idjogador"));
			//camisa
			
			lista.add(jog);
		}
		ps.close();
		return lista;
	}


	@Override
	public List<Jogador> pesquisaReservas(int idEscalacao) throws SQLException {
		List<Jogador> lista = new ArrayList<Jogador>();
		String query = "SELECT * FROM listajog WHERE idescalacao = ? and posto LIKE ?";
		
		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, idEscalacao);
		ps.setString(2, "RESERVA");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			Jogador jog = new Jogador(); 
			
			jog = jdao.pesquisaUnico(rs.getInt("idjogador"));
			//camisa
			
			lista.add(jog);
		}
		ps.close();
		return lista;
	}


	@Override
	public Escalacao pesquisaUnicoId(int idEscalacao) throws SQLException {
		Escalacao e = new Escalacao();
		String query = "SELECT * FROM escalacao WHERE id = ?";
		
		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, idEscalacao);
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()){
			e.setClube(cb.pesquisaUnico(rs.getInt("clube")));
			e.setTitulares(pesquisaTitulares(rs.getInt("id")));
			e.setReservas(pesquisaReservas(rs.getInt("id")));
			e.setData(rs.getString("data"));
		}
		
		ps.close();
		
		return e;
	}


	@Override
	public Escalacao pesquisaPorClube(int idClube) throws SQLException {
		Escalacao e = new Escalacao();
		String query = "SELECT * FROM escalacao WHERE idclube = ?";
		
		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, idClube);
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()){
			e.setClube(cb.pesquisaUnico(rs.getInt("clube")));
			e.setTitulares(pesquisaTitulares(rs.getInt("id")));
			e.setReservas(pesquisaReservas(rs.getInt("id")));
			e.setData(rs.getString("data"));
		}
		
		ps.close();
		
		return e;
	}

}
