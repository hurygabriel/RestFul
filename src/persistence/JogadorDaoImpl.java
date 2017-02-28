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

/**
 * Persistencia do Jogador
 * 
 * @author Hury
 *
 */
public class JogadorDaoImpl implements JogadorDao {
	private Connection c;

	public JogadorDaoImpl() {
		GenericConnection gc = new ConnectionImpl();
		c = gc.getConnection();
	}

	/**
	 * Usado em outros metodos para evitar duplicidade de codigo
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private List<Jogador> preencher(ResultSet rs) throws SQLException {
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
			j.setCaminhoimg(rs.getString("caminhoimg"));

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

		lista = preencher(rs);
		ps.close();

		return lista;
	}
	
	/**
	 * Altera as informações de um jogador a partir de um ID
	 */

	@Override
	public void altera(Jogador obj) throws SQLException {

		String query = "UPDATE jogador SET nome = ?, apelido = ?, datanasc = ?,"
				+ " peso = ?, altura = ?, naturalidade = ?, uf = ?, posicao = ?, caminhoimg = ? WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setString(1, obj.getNome());
		ps.setString(2, obj.getApelido());
		ps.setString(3, obj.getDatanasc());
		ps.setFloat(4, obj.getPeso());
		ps.setFloat(5, obj.getAltura());
		ps.setString(6, obj.getNaturalidade());
		ps.setString(7, obj.getUf().name());
		ps.setString(8, obj.getPosicao().name());
		ps.setString(9, obj.getCaminhoimg());
		ps.setInt(10, obj.getId());

		ps.execute();
		ps.close();

	}
	
	/**
	 * Exclui um jogador pelo id
	 */

	@Override
	public void exclui(Jogador obj) throws SQLException {

		String query = "DELETE jogador WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setInt(1, obj.getId());

		ps.execute();
		ps.close();

	}

	@Override
	public void inclui(Jogador obj) throws SQLException {

		String query = "INSERT INTO jogador VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(query);

		ps.setString(1, obj.getNome());
		ps.setString(2, obj.getApelido());
		ps.setString(3, obj.getDatanasc());
		ps.setFloat(4, obj.getPeso());
		ps.setFloat(5, obj.getAltura());
		ps.setString(6, obj.getNaturalidade());
		ps.setString(7, obj.getUf().name());
		ps.setString(8, obj.getPosicao().name());
		ps.setString(9, obj.getCaminhoimg());

		ps.execute();
		ps.close();

	}

	/**
	 * Pesquisa um unico jogador pelo seu id
	 */
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
			j.setCaminhoimg(rs.getString("caminhoimg"));

		}
		ps.close();

		return j;
	}

	/**
	 * Pesquisa jogadores por determinado clube
	 */
	@Override
	public List<Jogador> pesquisaPorClube(int id) throws SQLException {

		List<Jogador> lista = new ArrayList<Jogador>();
		String query = "SELECT * FROM v_jogadorClube WHERE idclube = ?";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		lista = preencher(rs);
		ps.close();

		return lista;
	}

	// Sobrecarga
	@Override
	public List<Jogador> pesquisaPorClube(String nome) throws SQLException {

		List<Jogador> lista = new ArrayList<Jogador>();
		String query = "SELECT * FROM v_jogadorClube WHERE clube like ?";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + nome + "%");
		ResultSet rs = ps.executeQuery();

		lista = preencher(rs);
		ps.close();

		return lista;
	}

	/**
	 * pesquisa jogador(es) por determinado nome
	 */
	@Override
	public List<Jogador> pesquisaPorNome(String nome) throws SQLException {

		List<Jogador> lista = new ArrayList<Jogador>();
		String query = "SELECT * FROM jogador WHERE nome LIKE ?";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + nome + "%");
		ResultSet rs = ps.executeQuery();

		lista = preencher(rs);
		ps.close();

		return lista;
	}

	/**
	 * Pesquisa jogadores por estado Brasileiro
	 */
	@Override
	public List<Jogador> pesquisaPorUF(String uf) throws SQLException {

		List<Jogador> lista = new ArrayList<Jogador>();
		String query = "SELECT * FROM jogador WHERE uf LIKE ?";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + uf + "%");
		ResultSet rs = ps.executeQuery();

		lista = preencher(rs);
		ps.close();

		return lista;
	}

	/**
	 * Pesquisa jogadores pela sua posicao em campo
	 */
	@Override
	public List<Jogador> pesquisaPorPosicao(String posicao) throws SQLException {
		List<Jogador> lista = new ArrayList<Jogador>();
		String query = "SELECT * FROM jogador WHERE posicao LIKE ?";

		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, "%" + posicao + "%");
		ResultSet rs = ps.executeQuery();

		lista = preencher(rs);
		ps.close();

		return lista;
	}

}
