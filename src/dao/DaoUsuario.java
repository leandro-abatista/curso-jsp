package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import model.classes.beans.UsuarioBean;

public class DaoUsuario {

	private Connection connection;

	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(UsuarioBean usuarioBean) {
		try {

			String sql = "INSERT INTO usuario(login, senha, nome, cpf, telefone, email, ativo) VALUES (?,?,?,?,?,?,?);";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, usuarioBean.getLogin());
			ps.setString(2, usuarioBean.getSenha());
			ps.setString(3, usuarioBean.getNome());
			ps.setString(4, usuarioBean.getCpf());
			ps.setString(5, usuarioBean.getTelefone());
			ps.setString(6, usuarioBean.getEmail());
			ps.setBoolean(7, usuarioBean.isAtivo());
			
			ps.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();

			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public List<UsuarioBean> listarTodosUsuarios() {
		try {

			List<UsuarioBean> lista = new ArrayList<UsuarioBean>();

			String sql = "SELECT codigo, nome, cpf, login, senha, telefone, email, ativo "
					+ " FROM usuario ORDER BY codigo";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UsuarioBean usuarioBean = new UsuarioBean();
				usuarioBean.setCodigo(rs.getLong("codigo"));
				usuarioBean.setNome(rs.getString("nome"));
				usuarioBean.setCpf(rs.getString("cpf"));
				usuarioBean.setLogin(rs.getString("login"));
				usuarioBean.setSenha(rs.getString("senha"));
				usuarioBean.setTelefone(rs.getString("telefone"));
				usuarioBean.setEmail(rs.getString("email"));
				usuarioBean.setAtivo(rs.getBoolean("ativo"));

				lista.add(usuarioBean);
			}

			return lista;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public UsuarioBean consultarCodigo(Long codigo) {
		try {
			
			String sql = "SELECT codigo, nome, cpf, login, senha, telefone, email, ativo "
					+ " FROM usuario WHERE codigo = '" + codigo + "'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				UsuarioBean usuarioBean = new UsuarioBean();
				usuarioBean.setCodigo(rs.getLong("codigo"));
				usuarioBean.setNome(rs.getString("nome"));
				usuarioBean.setCpf(rs.getString("cpf"));
				usuarioBean.setLogin(rs.getString("login"));
				usuarioBean.setSenha(rs.getString("senha"));
				usuarioBean.setTelefone(rs.getString("telefone"));
				usuarioBean.setEmail(rs.getString("email"));
				usuarioBean.setAtivo(rs.getBoolean("ativo"));
				
				return usuarioBean;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void atualizar(UsuarioBean usuarioBean) {
		try {
			
			String sql = "UPDATE usuario SET login = ?, senha = ?, nome = ?, cpf = ?, telefone = ?, email = ?, ativo = ?"
					+ " WHERE codigo = " + usuarioBean.getCodigo();
			PreparedStatement ps= connection.prepareStatement(sql);
			ps.setString(1, usuarioBean.getLogin());
			ps.setString(2, usuarioBean.getSenha());
			ps.setString(3, usuarioBean.getNome());
			ps.setString(4, usuarioBean.getCpf());
			ps.setString(5, usuarioBean.getTelefone());
			ps.setString(6, usuarioBean.getEmail());
			ps.setBoolean(7, usuarioBean.isAtivo());
			
			ps.executeUpdate();
			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void delete(Long codigo) {
		try {
			
			String sql = "DELETE FROM usuario WHERE codigo = '" + codigo + "'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.execute();
			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public boolean verificarLogin(String login) {
		try {
			
			String sql = "SELECT COUNT(1) AS qtd FROM usuario WHERE login = '" + login + "'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("qtd") <= 0;//return true
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verificarLoginUpdate(String login, Long codigo) {
		try {
			
			String sql = "SELECT COUNT(1) AS qtd FROM usuario WHERE login = '" + login + "' AND codigo <> " + codigo;
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("qtd") <= 0;//return true
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verificarSenha(String senha) {
		try {
			
			String sql = "SELECT COUNT(1) AS qtd FROM usuario WHERE senha = '" + senha + "'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("qtd") <= 0;//return true
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verificarSenhaUpdate(String senha, Long codigo) {
		try {
			
			String sql = "SELECT COUNT(1) AS qtd FROM usuario WHERE login = '" + senha + "' AND codigo <> " + codigo;
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("qtd") <= 0;//return true
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
