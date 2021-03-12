package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnection;

/**
 * classe responsável por realizar o CRUD com o banco de dados
 * @author Leandro
 *
 */
public class UsuarioDao {

	private Connection connection;
	
	public UsuarioDao() {
		connection = SingleConnection.getConnection();
	}
	
	public boolean validarUsuario(String login, String senha) throws SQLException {
		
		String sql = "select from usuario where login = '" + login + "' and senha = '" + senha + "'";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			return true;//possui usuário
		} else {
			return false;//não possui usuário
		}
	}
}
