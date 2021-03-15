package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import model.classes.beans.ProdutoBean;

public class DaoProduto {
	
	private Connection connection;
	
	public DaoProduto() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(ProdutoBean produtoBean) {
		try {
			
			String sql = "INSERT INTO public.produto(" + 
					"            nome, valor, quantidade, datacadastro)" + 
					"    VALUES (?, ?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, produtoBean.getNome());
			ps.setDouble(2, produtoBean.getValor());
			ps.setInt(3, produtoBean.getQuantidade());
			ps.setDate(4, new Date(produtoBean.getDataCadastro().getTime()));
			
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
	
	public List<ProdutoBean> listarTodosProdutos() {
		try {
			List<ProdutoBean> listar = new ArrayList<ProdutoBean>();
			
			String sql = "SELECT codigo, nome, valor, quantidade, datacadastro" + 
					"  FROM public.produto ORDER BY codigo;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ProdutoBean produtoBean = new ProdutoBean();
				produtoBean.setCodigo(rs.getLong("codigo"));
				produtoBean.setNome(rs.getString("nome"));
				produtoBean.setValor(rs.getDouble("valor"));
				produtoBean.setQuantidade(rs.getInt("quantidade"));
				produtoBean.setDataCadastro(rs.getDate("datacadastro"));
				
				listar.add(produtoBean);
			}
			
			return listar;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ProdutoBean consultarProduto(Long codigo) {
		try {
			
			String sql = "SELECT codigo, nome, valor, quantidade, datacadastro" + 
					"   FROM public.produto WHERE codigo = '" + codigo + "';";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				ProdutoBean produtoBean = new ProdutoBean();
				produtoBean.setCodigo(rs.getLong("codigo"));
				produtoBean.setNome(rs.getString("nome"));
				produtoBean.setValor(rs.getDouble("valor"));
				produtoBean.setQuantidade(rs.getInt("quantidade"));
				produtoBean.setDataCadastro(rs.getDate("datacadastro"));
				
				return produtoBean;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void update(ProdutoBean produtoBean) {
		try {
			
			String sql = "UPDATE public.produto" + 
					"   SET nome=?, valor=?, quantidade=?, datacadastro=?" + 
					" 	WHERE codigo = '" + produtoBean.getCodigo() + "'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, produtoBean.getNome());
			ps.setDouble(2, produtoBean.getValor());
			ps.setInt(3, produtoBean.getQuantidade());
			ps.setDate(4, new Date(produtoBean.getDataCadastro().getTime()));
			
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
			
			String sql = "DELETE FROM public.produto" + 
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
	
	public boolean verificarNomePro(String nome) {
		try {
			
			String sql = "SELECT COUNT(1) AS qtd FROM produto WHERE nome = '" + nome + "';";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("qtd") <= 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
