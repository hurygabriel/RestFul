package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionImplMySQL implements GenericConnection{

	public static Connection con;
	
	@Override
	public Connection getConnection() {
		String driver = "com.mysql.jdbc.Driver";
	    String connection = "jdbc:mysql://localhost:3306/sumula";
	    String user = "root";
	    String password = "";
	    try {
			Class.forName(driver);
			con = DriverManager.getConnection(connection, user, password);
			System.out.println("conectou");
		} catch (ClassNotFoundException e) {
			System.out.println("classe nao encontrada");
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			System.out.println("sql");
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	    
		return con;
	}

	@Override
	public void fechaConexao(Connection con) {
		try {
			if (con != null)
				con.close();
			con = null;
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
	}

}
