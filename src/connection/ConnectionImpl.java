package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
			System.out.println("classe nao encontrada"+ e.getMessage());
		} catch (SQLException e) {
			System.out.println("sql"+ e.getMessage());
		} catch (Exception e) {
			System.out.println("exception"+ e.getMessage());
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
