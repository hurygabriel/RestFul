package connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Controle das propriedades de conexao.
 * @author hury
 *
 */
public class PropertiesCon {

	private Properties props = new Properties();
	private static final String FILE_NAME = "properties/dados.properties";

	public PropertiesCon() {
		InputStream in = getClass().getClassLoader().getResourceAsStream(FILE_NAME);
		try {
			loadProperties(in);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro de caminho");
		}
	}

	private void loadProperties(InputStream in) throws IOException {
		props = new Properties();
		props.load(in);
		in.close();
	}

	/**
	 * Retorna a propriedade contina no arquivo.
	 * @param chave nome da propriedade
	 * @return
	 */
	public String getContent(String chave) {
		return (String) props.getProperty(chave).trim();
	}

	/**
	 * Identifica e seta a conexão com o banco de dados.
	 * @return
	 */
	public ConnectionString getProperties() {

		ConnectionString cons = new ConnectionString();

		switch (getContent("prop.con")) {
		case "SQL":

			cons.setDrive(getContent("prop.SQL.drive"));
			cons.setConnection(getContent("prop.SQL.connection"));
			cons.setUser(getContent("prop.SQL.user"));
			cons.setPassword(getContent("prop.SQL.password"));
			System.out.println("SQL Server selecionado");
			break;

		case "MYSQL":
			cons.setDrive(getContent("prop.MYSQL.drive"));
			cons.setConnection(getContent("prop.MYSQL.connection"));
			cons.setUser(getContent("prop.MYSQL.user"));
			cons.setPassword(getContent("prop.MYSQL.password"));
			System.out.println("MySQL server selecionado");
			break;

		default:
			System.out.println("Não foi possível localizar um parametro de configuração válido! [ SQL || MYSQL ]");
			break;
		}
		return cons;
	}

}