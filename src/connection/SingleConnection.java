package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Responsável por fazer a conexão com o banco de dados
 * @author Leandro
 *
 */
public class SingleConnection {
	
	private static String banco = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";
	private static String user = "postgres";
	private static String password = "admin";
	private static String driver = "org.postgresql.Driver";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}
	
	private static void conectar() {
		try {
			
			if (connection == null) {
				Class.forName(driver);
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro tentar se conectar com o bando de dados!" + e.getMessage());
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	

}
