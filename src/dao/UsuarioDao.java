package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import connection.SingleConnection;
import model.classes.beans.UsuarioBean;

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
	
	public UsuarioBean validarUsuario(UsuarioBean usuarioBean) throws ServletException {
		try {
			String sql = "select * from usuario where login = ? AND senha = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, usuarioBean.getLogin());
			ps.setString(2, usuarioBean.getSenha());
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				UsuarioBean user = new UsuarioBean();
				user.setLogin(rs.getString("login"));
				user.setSenha(rs.getString("senha"));
				
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		return null; 
	}
}
