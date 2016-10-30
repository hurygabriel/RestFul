package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * Classe que realiza a conexão com o banco de dados
 * 
 * @author Hury
 * @since 23/09/2016
 * @version 1.0
 */

public class ConnectionImpl implements GenericConnection {

	private static Connection con;
	private ConnectionString cons = new ConnectionString();

	/**
	 * Método que abre a conexão com o banco
	 * 
	 * @return conexao com o banco
	 */
	@Override
	public Connection getConnection() {

		try {

			PropertiesCon pcon = new PropertiesCon();
			cons = pcon.getProperties();

			Class.forName(cons.getDrive());
			con = DriverManager.getConnection(cons.getConnection(), cons.getUser(), cons.getPassword());
			System.out.println("CONECTADO");

		} catch (ClassNotFoundException e) {
			System.out.println("classe nao encontrada");
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			System.out.println("sql");
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			System.out.println("exception");
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		return con;
	}

	/**
	 * Método que fecha a conexão com o banco
	 * 
	 * @param conexao
	 *            do banco
	 */
	@Override
	public void fechaConexao(Connection con) {
		try {
			if (con != null)
				con.close();
			con = null;
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
