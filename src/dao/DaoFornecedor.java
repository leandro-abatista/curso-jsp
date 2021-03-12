package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

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

}
