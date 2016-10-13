package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionImpl;
import connection.GenericConnection;
import enumeration.PosicaoJogador;
import enumeration.UF;
import model.Jogador;

public class JogadorDaoImpl implements JogadorDao {
	private Connection c;

	public JogadorDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	
	private List<Jogador> constructor(ResultSet rs) throws SQLException {
		List<Jogador> lista = new ArrayList<Jogador>();
		while (rs.next()) {

			Jogador j = new Jogador();
			j.setId(rs.getInt("id"));
			j.setNome(rs.getString("nome"));
			j.setApelido(rs.getString("apelido"));
			j.setDatanasc(rs.getString("datanasc"));
			j.setPeso(rs.getFloat("peso"));
			j.setAltura(rs.getFloat("altura"));
			j.setNaturalidade(rs.getString("naturalidade"));
			j.setUf(UF.valueOf(rs.getString("uf")));
			j.setPosicao(PosicaoJogador.valueOf(rs.getString("posicao")));
			lista.add(j);
		}
		return lista;
	}

	@Override
	public List<Jogador> pesquisa() throws SQLException {
		List<Jogador> lista = new ArrayList<Jogador>();
		String query = "SELECT * FROM jogador";

		PreparedStatement ps = c.prepareStatement(query);
		ResultSet rs = ps.executeQuery();

        lista=constructor(rs);

		ps.close();

		return lista;
	}

	@Override
	public void altera(Jogador obj) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void exclui(Jogador obj) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void inclui(Jogador obj) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Jogador pesquisaUnico(int obj) throws SQLException {
		Jogador j = new Jogador();
		String query = "SELECT * FROM jogador WHERE id = ?";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, obj);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			j.setId(rs.getInt("id"));
			j.setNome(rs.getString("nome"));
			j.setApelido(rs.getString("apelido"));
			j.setDatanasc(rs.getString("datanasc"));
			j.setPeso(rs.getFloat("peso"));
			j.setAltura(rs.getFloat("altura"));
			j.setNaturalidade(rs.getString("naturalidade"));
			j.setUf(UF.valueOf(rs.getString("uf")));
			j.setPosicao(PosicaoJogador.valueOf(rs.getString("posicao")));

		}
		ps.close();
		return j;
	}

	@Override
	public List<Jogador> pesquisaPorClube(int id) throws SQLException {
		List<Jogador> lista = new ArrayList<Jogador>();
		String query = "SELECT * FROM v_jogadorClube WHERE idclube = ?";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			Jogador j = new Jogador();
			j.setId(rs.getInt("id"));
			j.setNome(rs.getString("nome"));
			j.setApelido(rs.getString("apelido"));
			j.setDatanasc(rs.getString("datanasc"));
			j.setPeso(rs.getFloat("peso"));
			j.setAltura(rs.getFloat("altura"));
			j.setNaturalidade(rs.getString("naturalidade"));
			j.setUf(UF.valueOf(rs.getString("uf")));
			j.setPosicao(PosicaoJogador.valueOf(rs.getString("posicao")));

			lista.add(j);

		}
		ps.close();

		return lista;
	}

	@Override
	public List<Jogador> pesquisaPorNome(String nome) throws SQLException {
		List<Jogador> lista = new ArrayList<Jogador>();
		String query = "SELECT * FROM jogador WHERE nome LIKE ?";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + nome + "%");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			Jogador j = new Jogador();
			j.setId(rs.getInt("id"));
			j.setNome(rs.getString("nome"));
			j.setApelido(rs.getString("apelido"));
			j.setDatanasc(rs.getString("datanasc"));
			j.setPeso(rs.getFloat("peso"));
			j.setAltura(rs.getFloat("altura"));
			j.setNaturalidade(rs.getString("naturalidade"));
			j.setUf(UF.valueOf(rs.getString("uf")));
			j.setPosicao(PosicaoJogador.valueOf(rs.getString("posicao")));

			lista.add(j);

		}
		ps.close();

		return lista;

	}

	@Override
	public List<Jogador> pesquisaPorUF(String uf) throws SQLException {
		List<Jogador> lista = new ArrayList<Jogador>();
		String query = "SELECT * FROM jogador WHERE uf LIKE ?";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + uf + "%");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			Jogador j = new Jogador();
			j.setId(rs.getInt("id"));
			j.setNome(rs.getString("nome"));
			j.setApelido(rs.getString("apelido"));
			j.setDatanasc(rs.getString("datanasc"));
			j.setPeso(rs.getFloat("peso"));
			j.setAltura(rs.getFloat("altura"));
			j.setNaturalidade(rs.getString("naturalidade"));
			j.setUf(UF.valueOf(rs.getString("uf")));
			j.setPosicao(PosicaoJogador.valueOf(rs.getString("posicao")));

			lista.add(j);

		}
		ps.close();

		return lista;

	}

	@Override
	public List<Jogador> pesquisaPorPosicao(String posicao) throws SQLException {
		List<Jogador> lista = new ArrayList<Jogador>();
		String query = "SELECT * FROM jogador WHERE posicao LIKE ?";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + posicao + "%");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			Jogador j = new Jogador();
			j.setId(rs.getInt("id"));
			j.setNome(rs.getString("nome"));
			j.setApelido(rs.getString("apelido"));
			j.setDatanasc(rs.getString("datanasc"));
			j.setPeso(rs.getFloat("peso"));
			j.setAltura(rs.getFloat("altura"));
			j.setNaturalidade(rs.getString("naturalidade"));
			j.setUf(UF.valueOf(rs.getString("uf")));
			j.setPosicao(PosicaoJogador.valueOf(rs.getString("posicao")));

			lista.add(j);

		}
		ps.close();

		return lista;
	}

}
