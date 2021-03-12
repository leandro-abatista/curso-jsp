package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import model.classes.beans.FornecedorBean;

public class DaoFornecedor {
	
	private Connection connection;
	
	public DaoFornecedor() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(FornecedorBean fornecedorBean) {
		try {
			
			String sql = "INSERT INTO public.fornecedor"
					+ "(razaosocial, nomefantasia, cnpj, inscricaoestadual, inscricaomunicipal, datacadastro)"
					+ "    VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, fornecedorBean.getRazaoSocial());
			ps.setString(2, fornecedorBean.getNomeFantasia());
			ps.setString(3, fornecedorBean.getCnpj());
			ps.setString(4, fornecedorBean.getInscricaoEstadual());
			ps.setString(5, fornecedorBean.getInscricaoMunicipal());
			ps.setDate(6, new Date(fornecedorBean.getDataCadastro().getTime()));
			
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
	
	public List<FornecedorBean> listarTodosFornecedor(){
		try {
			
			List<FornecedorBean> listar = new ArrayList<FornecedorBean>();
			
			String sql = "SELECT codigo, razaosocial, nomefantasia, cnpj, inscricaoestadual, inscricaomunicipal, datacadastro" + 
					"  FROM public.fornecedor ORDER BY codigo;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				FornecedorBean fornecedorBean = new FornecedorBean();
				fornecedorBean.setCodigo(rs.getLong("codigo"));
				fornecedorBean.setRazaoSocial(rs.getString("razaosocial"));
				fornecedorBean.setNomeFantasia(rs.getString("nomefantasia"));
				fornecedorBean.setCnpj(rs.getString("cnpj"));
				fornecedorBean.setInscricaoEstadual(rs.getString("inscricaoestadual"));
				fornecedorBean.setInscricaoMunicipal(rs.getString("inscricaomunicipal"));
				fornecedorBean.setDataCadastro(rs.getDate("datacadastro"));
				
				listar.add(fornecedorBean);
			}
			
			return listar;
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public FornecedorBean consultarCodigo(Long codigo) {
		try {
			
			String sql = "SELECT codigo, razaosocial, nomefantasia, cnpj, inscricaoestadual, inscricaomunicipal, " + 
					"       datacadastro" + 
					"  FROM public.fornecedor WHERE codigo = '" + codigo + "';";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				FornecedorBean fornecedorBean = new FornecedorBean();
				fornecedorBean.setCodigo(rs.getLong("codigo"));
				fornecedorBean.setRazaoSocial(rs.getString("razaosocial"));
				fornecedorBean.setNomeFantasia(rs.getString("nomefantasia"));
				fornecedorBean.setCnpj(rs.getString("cnpj"));
				fornecedorBean.setInscricaoEstadual(rs.getString("inscricaoestadual"));
				fornecedorBean.setInscricaoMunicipal(rs.getString("inscricaomunicipal"));
				fornecedorBean.setDataCadastro(rs.getDate("datacadastro"));
				
				return fornecedorBean;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void update(FornecedorBean fornecedorBean) {
		try {
			
			String sql = "UPDATE public.fornecedor" + 
					"   SET razaosocial=?, nomefantasia=?, cnpj=?, inscricaoestadual=?, " + 
					"       inscricaomunicipal=?, datacadastro=?" + 
					" WHERE codigo = '" + fornecedorBean.getCodigo() + "'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, fornecedorBean.getRazaoSocial());
			ps.setString(2, fornecedorBean.getNomeFantasia());
			ps.setString(3, fornecedorBean.getCnpj());
			ps.setString(4, fornecedorBean.getInscricaoEstadual());
			ps.setString(5, fornecedorBean.getInscricaoMunicipal());
			ps.setDate(6, new Date(fornecedorBean.getDataCadastro().getTime()));
			
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
			
			String sql = "DELETE FROM public.fornecedor" + 
					" WHERE codigo = '" + codigo + "'";
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
	
	public boolean verificarCnpj(String cnpj) {
		try {

			String sql = "SELECT COUNT(1) AS qtd FROM fornecedor WHERE cnpj = '" + cnpj + "'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getInt("qtd") <= 0;// return true
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
