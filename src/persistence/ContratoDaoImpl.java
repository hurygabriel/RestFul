package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import model.Contrato;

public class ContratoDaoImpl implements ContratoDao {
	private Connection c;

	public ContratoDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public void inclui(Contrato obj) throws SQLException {
		List<Contrato> lista = new ArrayList<Contrato>();
		

	}

	@Override
	public List<Contrato> pesquisa() throws SQLException {
		// TODO Auto-generated method stub
		return null;
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
