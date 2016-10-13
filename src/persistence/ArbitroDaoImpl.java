package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import java.util.ArrayList;

import java.util.List;

import connection.ConnectionImpl;
import connection.GenericConnection;
import enumeration.SituacaoJuiz;
import enumeration.UF;
import model.Arbitro;
import model.Sentenca;

public class ArbitroDaoImpl implements ArbitroDao {
	
	private Connection c;
	
	public ArbitroDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	@Override
	public List<Arbitro> pesquisaPorUF(UF uf) throws SQLException {
		List<Arbitro> lista = new ArrayList<Arbitro>();
		String query = "Select * from arbitro arb left join sentenca sent "
				+ "on arb.id = sent.idArbitro WHERE uf = ? ORDER BY arb.nome";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, uf.toString());
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			Arbitro a = new Arbitro();
			Sentenca sentenca= new Sentenca();
			a.setId(rs.getInt("id"));
			a.setNome(rs.getString("nome"));
			a.setDataNascimento(rs.getDate("dataNascimento"));
			a.setUf(UF.valueOf(rs.getString("uf")));
			a.setUfDescricao(a.getUf().getDescricao());
			a.setSituacao(SituacaoJuiz.valueOf(rs.getString("situacao")));
			a.setSituaçãoDescritivo(a.getSituacao().getDescricao());
			sentenca.setDataSentenca(rs.getDate("dataSentenca"));
			sentenca.setDescricao(rs.getString("descricao"));
			sentenca.setJogosPagos(rs.getInt("jogosPagos"));
			sentenca.setJogosPena(rs.getInt("jogosPena"));
			sentenca.setMotivo(rs.getString("motivo"));
			sentenca.setPontos(rs.getInt("pontos"));
			sentenca.setValorPena(rs.getBigDecimal("valorPena"));
			a.getListaSentenca().add(sentenca);
			lista.add(a);
		}
		
		ps.close();
		
		return lista;
	}

	@Override
	public List<Arbitro> pesquisaPorSituacao(SituacaoJuiz situacao) throws SQLException {
		List<Arbitro> lista = new ArrayList<Arbitro>();
		String query = "Select * from arbitro arb left join sentenca sent "
				+ "on arb.id = sent.idArbitro WHERE situacao = ? ORDER BY arb.nome";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, situacao.toString());
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			Arbitro a = new Arbitro();
			Sentenca sentenca= new Sentenca();
			a.setId(rs.getInt("id"));
			a.setNome(rs.getString("nome"));
			a.setDataNascimento(rs.getDate("dataNascimento"));
			a.setUf(UF.valueOf(rs.getString("uf")));
			a.setUfDescricao(a.getUf().getDescricao());
			a.setSituacao(SituacaoJuiz.valueOf(rs.getString("situacao")));
			a.setSituaçãoDescritivo(a.getSituacao().getDescricao());
			sentenca.setDataSentenca(rs.getDate("dataSentenca"));
			sentenca.setDescricao(rs.getString("descricao"));
			sentenca.setJogosPagos(rs.getInt("jogosPagos"));
			sentenca.setJogosPena(rs.getInt("jogosPena"));
			sentenca.setMotivo(rs.getString("motivo"));
			sentenca.setPontos(rs.getInt("pontos"));
			sentenca.setValorPena(rs.getBigDecimal("valorPena"));
			a.getListaSentenca().add(sentenca);
			lista.add(a);
		}
		
		ps.close();
		
		return lista;
	}

	@Override
	public List<Arbitro> pesquisaPorNome(String nome) throws SQLException {
		List<Arbitro> lista = new ArrayList<Arbitro>();
		String query = "Select * from arbitro arb left join sentenca sent "
				+ "on arb.id = sent.idArbitro WHERE nome LIKE ? ORDER BY arb.nome";
		
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + nome + "%" );
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			Arbitro a = new Arbitro();
			Sentenca sentenca= new Sentenca();
			a.setId(rs.getInt("id"));
			a.setNome(rs.getString("nome"));
			a.setDataNascimento(rs.getDate("dataNascimento"));
			a.setUf(UF.valueOf(rs.getString("uf")));
			a.setUfDescricao(a.getUf().getDescricao());
			a.setSituacao(SituacaoJuiz.valueOf(rs.getString("situacao")));
			a.setSituaçãoDescritivo(a.getSituacao().getDescricao());
			sentenca.setDataSentenca(rs.getDate("dataSentenca"));
			sentenca.setDescricao(rs.getString("descricao"));
			sentenca.setJogosPagos(rs.getInt("jogosPagos"));
			sentenca.setJogosPena(rs.getInt("jogosPena"));
			sentenca.setMotivo(rs.getString("motivo"));
			sentenca.setPontos(rs.getInt("pontos"));
			sentenca.setValorPena(rs.getBigDecimal("valorPena"));
			a.getListaSentenca().add(sentenca);
			lista.add(a);
		}
		
		ps.close();
		
		return lista;
	}

	@Override
	public List<Arbitro> listaTodos() throws SQLException, ParseException {
		List<Arbitro> lista = new ArrayList<Arbitro>();
		String query = "Select * from arbitro arb left join sentenca sent "
				+ "on arb.id = sent.idArbitro ORDER BY arb.nome";

		PreparedStatement ps = c.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()){
			Sentenca sentenca= new Sentenca();
			Arbitro a = new Arbitro();
			
			a.setId(rs.getInt("id"));
			a.setNome(rs.getString("nome"));
			a.setDataNascimento(rs.getDate("dataNascimento"));
			a.setUf(UF.valueOf(rs.getString("uf")));
			a.setUfDescricao(a.getUf().getDescricao());
			a.setSituacao(SituacaoJuiz.valueOf(rs.getString("situacao")));
			a.setSituaçãoDescritivo(a.getSituacao().getDescricao());
			sentenca.setDataSentenca(rs.getDate("dataSentenca"));
			sentenca.setDescricao(rs.getString("descricao"));
			sentenca.setJogosPagos(rs.getInt("jogosPagos"));
			sentenca.setJogosPena(rs.getInt("jogosPena"));
			sentenca.setMotivo(rs.getString("motivo"));
			sentenca.setPontos(rs.getInt("pontos"));
			sentenca.setValorPena(rs.getBigDecimal("valorPena"));
			a.getListaSentenca().add(sentenca);
			lista.add(a);
		}
		
		ps.close();
		
		return lista;
	}
}
