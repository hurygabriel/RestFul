package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import java.util.ArrayList;

import java.util.List;

import connection.ConnectionImpl;
//import connection.ConnectionImplMySQL;
import connection.GenericConnection;
import enumeration.SituacaoJuiz;
import enumeration.UF;
import model.Arbitro;
import model.Situacao;

public class ArbitroDaoImpl implements ArbitroDao {
	
	private Connection c;
	
	public ArbitroDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public List<Arbitro> pesquisaPorUF(UF UF) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Arbitro> pesquisaPorSituacao(Situacao situacao) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Arbitro> pesquisaPorNome(String nome) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Arbitro> listaTodos() throws SQLException, ParseException {
		List<Arbitro> lista = new ArrayList<Arbitro>();
		String query = "SELECT * FROM arbitro";

		PreparedStatement ps = c.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			Arbitro a = new Arbitro();
			a.setId(rs.getInt("id"));
			a.setNome(rs.getString("nome"));
			a.setDataNascimento(rs.getDate("dataNascimento"));
			a.setUf(UF.valueOf(rs.getString("uf")));
			a.setUfDescricao(a.getUf().getDescricao());
			a.setSituacao(SituacaoJuiz.valueOf(rs.getString("situacao")));
			a.setSituaçãoDescritivo(a.getSituacao().getDescricao());
			lista.add(a);
		}
		
		ps.close();
		
		return lista;
	}

}
