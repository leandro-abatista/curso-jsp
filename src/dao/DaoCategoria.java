package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import model.classes.beans.CategoriaBean;

public class DaoCategoria {

	private Connection connection;

	public DaoCategoria() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(CategoriaBean categoriaBean) {
		try {
			
			String sql = "INSERT INTO public.categoria(descricao)" + 
					"    VALUES (?);";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, categoriaBean.getDescricao());
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

	public List<CategoriaBean> listarTodasCategorias() {
		try {
			List<CategoriaBean> listar = new ArrayList<CategoriaBean>();
			String sql = "SELECT codigo, descricao FROM public.categoria ORDER BY codigo;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				CategoriaBean cat = new CategoriaBean();
				cat.setCodigo(rs.getLong("codigo"));
				cat.setDescricao(rs.getString("descricao"));
				
				listar.add(cat);
			}
			
			return listar;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public CategoriaBean consultarCategoria(Long codigo) {
		try {
			
			String sql = "SELECT codigo, descricao FROM public.categoria WHERE codigo = '" + codigo + "';";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				CategoriaBean cat = new CategoriaBean();
				cat.setCodigo(rs.getLong("codigo"));
				cat.setDescricao(rs.getString("descricao"));
				
				return cat;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void update(CategoriaBean categoriaBean) {
		try {
			
			String sql = "UPDATE public.categoria" + 
					" SET codigo=?, descricao=?" + 
					" WHERE codigo = '" + categoriaBean.getCodigo() + "';";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, categoriaBean.getCodigo());
			ps.setString(2, categoriaBean.getDescricao());
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

	public void delete(Long codigo) {
		try {
			
			String sql = "DELETE FROM public.categoria WHERE codigo = '" + codigo + "';";
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
