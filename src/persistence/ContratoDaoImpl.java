package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import enumeration.TipoContrato;
import model.Contrato;

public class ContratoDaoImpl implements ContratoDao {
	private Connection c;

	public ContratoDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public void inclui(Contrato obj) throws SQLException {

	}

	@Override
	public List<Contrato> pesquisa() throws SQLException {
		List<Contrato> lista = new ArrayList<Contrato>();
		String query = "SELECT * FROM contrato";

		PreparedStatement ps = c.prepareStatement(query);
		ResultSet rs = ps.executeQuery();

		ClubeDao cdao = new ClubeDaoImpl();
		JogadorDao jdao = new JogadorDaoImpl();

		while (rs.next()) {
			Contrato cont = new Contrato();

			cont.setNumero(rs.getInt("numero"));
			cont.setDatainicio(rs.getString("datainicio"));
			cont.setDatafim(rs.getString("datafim"));
			cont.setTipo(TipoContrato.valueOf(rs.getString("tipo")));
			cont.setClube(cdao.pesquisaUnico(rs.getInt("idclube")));
			cont.setJogador(jdao.pesquisaUnico(rs.getInt("idjogador")));

			lista.add(cont);
		}
		ps.close();

		return lista;
	}

	@Override
	public void altera(Contrato obj) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void exclui(Contrato obj) throws SQLException {
		// TODO Auto-generated method stub

	}

}
