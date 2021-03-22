package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import model.classes.beans.UnidadeMedidaBean;

public class DaoUnidadeMedida {

	private Connection connection;
	
	public DaoUnidadeMedida() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(UnidadeMedidaBean umb) {
		try {
			
			String sql = "INSERT INTO public.unimedida(sigla, descricao)" + 
					"    VALUES (?,?);";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, umb.getSigla());
			ps.setString(2, umb.getDescricao());
			
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
	
	public List<UnidadeMedidaBean> listarTodasUnMedidas() {
		try {
			List<UnidadeMedidaBean> lista = new ArrayList<UnidadeMedidaBean>();
			String sql = "SELECT codigo, sigla, descricao " + 
					"  FROM public.unimedida ORDER BY codigo;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				UnidadeMedidaBean umb = new UnidadeMedidaBean();
				umb.setCodigo(rs.getLong("codigo"));
				umb.setSigla(rs.getString("sigla"));
				umb.setDescricao(rs.getString("descricao"));
				
				lista.add(umb);
			}
			
			return lista;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public UnidadeMedidaBean consultarCodUniMedida(Long codigo) {
		try {
			
			String sql = "SELECT codigo, sigla, descricao " + 
					"  FROM public.unimedida "
				  + "  WHERE codigo = '" + codigo + "';";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				UnidadeMedidaBean umb = new UnidadeMedidaBean();
				umb.setCodigo(rs.getLong("codigo"));
				umb.setSigla(rs.getString("sigla"));
				umb.setDescricao(rs.getString("descricao"));
				
				return umb;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void update(UnidadeMedidaBean umb) {
		try {
			
			String sql = "UPDATE public.unimedida " + 
					"   SET codigo=?, sigla=?, descricao=? " + 
					" WHERE codigo = '" + umb.getCodigo() + "';";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, umb.getCodigo());
			ps.setString(2, umb.getSigla());
			ps.setString(3, umb.getDescricao());
			
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
			
			String sql = "DELETE FROM public.unimedida " + 
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
