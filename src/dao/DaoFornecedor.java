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
					+ "(razaosocial, nomefantasia, cnpj, inscricaoestadual, inscricaomunicipal, datacadastro, "
					+ " cep, logradouro, numero, bairro, cidade, estado, ibge, empresa)"
					+ "    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, fornecedorBean.getRazaoSocial());
			ps.setString(2, fornecedorBean.getNomeFantasia());
			ps.setString(3, fornecedorBean.getCnpj());
			ps.setString(4, fornecedorBean.getInscricaoEstadual());
			ps.setString(5, fornecedorBean.getInscricaoMunicipal());
			ps.setDate(6, new Date(fornecedorBean.getDataCadastro().getTime()));
			ps.setString(7, fornecedorBean.getCep());
			ps.setString(8, fornecedorBean.getLogradouro());
			ps.setString(9, fornecedorBean.getNumero());
			ps.setString(10, fornecedorBean.getBairro());
			ps.setString(11, fornecedorBean.getCidade());
			ps.setString(12, fornecedorBean.getEstado());
			ps.setInt(13, fornecedorBean.getIbge());
			ps.setString(14, fornecedorBean.getEmpresa());
			
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
			
			String sql = "SELECT codigo, razaosocial, nomefantasia, cnpj, inscricaoestadual, inscricaomunicipal, datacadastro, "
					+ "  cep, logradouro, numero, bairro, cidade, estado, ibge, empresa " 
					+ "  FROM public.fornecedor ORDER BY codigo;";
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
				fornecedorBean.setCep(rs.getString("cep"));
				fornecedorBean.setLogradouro(rs.getString("logradouro"));
				fornecedorBean.setNumero(rs.getString("numero"));
				fornecedorBean.setBairro(rs.getString("bairro"));
				fornecedorBean.setCidade(rs.getString("cidade"));
				fornecedorBean.setEstado(rs.getString("estado"));
				fornecedorBean.setIbge(rs.getInt("ibge"));
				fornecedorBean.setEmpresa(rs.getString("empresa"));
				
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
					"     datacadastro, cep, logradouro, numero, bairro, cidade, estado, ibge, empresa " + 
					"     FROM public.fornecedor WHERE codigo = '" + codigo + "';";
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
				fornecedorBean.setCep(rs.getString("cep"));
				fornecedorBean.setLogradouro(rs.getString("logradouro"));
				fornecedorBean.setNumero(rs.getString("numero"));
				fornecedorBean.setBairro(rs.getString("bairro"));
				fornecedorBean.setCidade(rs.getString("cidade"));
				fornecedorBean.setEstado(rs.getString("estado"));
				fornecedorBean.setIbge(rs.getInt("ibge"));
				fornecedorBean.setEmpresa(rs.getString("empresa"));
				
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
					" SET codigo=?, razaosocial=?, nomefantasia=?, cnpj=?, inscricaoestadual=?, inscricaomunicipal=?, datacadastro=?, " +
					" cep=?, logradouro=?, numero=?, bairro=?, cidade=?, estado=?, ibge=?, empresa=? " + 
					" WHERE codigo = '" + fornecedorBean.getCodigo() + "'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, fornecedorBean.getCodigo());
			ps.setString(2, fornecedorBean.getRazaoSocial());
			ps.setString(3, fornecedorBean.getNomeFantasia());
			ps.setString(4, fornecedorBean.getCnpj());
			ps.setString(5, fornecedorBean.getInscricaoEstadual());
			ps.setString(6, fornecedorBean.getInscricaoMunicipal());
			ps.setDate(7, new Date(fornecedorBean.getDataCadastro().getTime()));
			ps.setString(8, fornecedorBean.getCep());
			ps.setString(9, fornecedorBean.getLogradouro());
			ps.setString(10, fornecedorBean.getNumero());
			ps.setString(11, fornecedorBean.getBairro());
			ps.setString(12, fornecedorBean.getCidade());
			ps.setString(13, fornecedorBean.getEstado());
			ps.setInt(14, fornecedorBean.getIbge());
			ps.setString(15, fornecedorBean.getEmpresa());
			
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
