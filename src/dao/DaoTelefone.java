package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import model.classes.beans.Telefone;

public class DaoTelefone {

	private Connection connection;
	
	public DaoTelefone() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(Telefone telefone) {
		try {
			
			String sql = "INSERT INTO public.telefone (tipo, numero, codigo_usuario)" + 
					"    VALUES (?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, telefone.getTipo());
			ps.setString(2, telefone.getNumero());
			ps.setLong(3, telefone.getUsuario());
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
	
	public List<Telefone> listarTodosTelefones(Long codigo) {
		try {
			List<Telefone> listar = new ArrayList<Telefone>();
			
			String sql = "SELECT codigo, tipo, numero, codigo_usuario" + 
					"  FROM public.telefone WHERE codigo = '" + codigo + "' ORDER BY codigo;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Telefone telefone = new Telefone();
				telefone.setCodigo(rs.getLong("codigo"));
				telefone.setTipo(rs.getString("tipo"));
				telefone.setNumero(rs.getString("numero"));
				telefone.setUsuario(rs.getLong("codigo_usuario"));
				
				listar.add(telefone);
			}
			
			return listar;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete(Long codigo) {
		try {
			
			String sql = "DELETE FROM public.telefone" + 
					" WHERE codigo = '" + codigo + "';";
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
}
