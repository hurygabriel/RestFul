package connection;

/**
 * Parametros da linha de conexao
 * @author hury
 *
 */
public class ConnectionString {
	
	private String drive;
	private String connection;
	private String user; 
	private String password;
	
	public String getDrive() {
		return drive;
	}
	public void setDrive(String drive) {
		this.drive = drive;
	}
	public String getConnection() {
		return connection;
	}
	public void setConnection(String connection) {
		this.connection = connection;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "ConnectionString [drive=" + drive + ", connection=" + connection + ", user=" + user + ", password="
				+ password + "]";
	} 

}
