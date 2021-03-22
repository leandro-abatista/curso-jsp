package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import model.classes.beans.CategoriaBean;
import model.classes.beans.FornecedorBean;
import model.classes.beans.ProdutoBean;
import model.classes.beans.UnidadeMedidaBean;

public class DaoProduto {
	
	private Connection connection;
	
	public DaoProduto() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(ProdutoBean produtoBean) {
		try {
			
			String sql = "INSERT INTO public.produto( " 
					+ "    nome, valor, quantidade, datacadastro, codigo_cat, codigo_unidmedida, codigo_forn, valorvenda, ncm, codigobarra, peso) " 
					+ "    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, produtoBean.getNome());
			ps.setDouble(2, produtoBean.getValor());
			ps.setInt(3, produtoBean.getQuantidade());
			ps.setDate(4, new Date(produtoBean.getDataCadastro().getTime()));
			ps.setLong(5, produtoBean.getCodigo_cat());
			ps.setLong(6, produtoBean.getCodigo_unidmedida());
			ps.setLong(7, produtoBean.getCodigo_forn());
			ps.setDouble(8, produtoBean.getValorVenda());
			ps.setInt(9, produtoBean.getNcm());
			ps.setLong(10, produtoBean.getCodigoBarra());
			ps.setDouble(11, produtoBean.getPeso());
			
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
			
			String sql = "SELECT codigo, nome, valor, quantidade, datacadastro, codigo_cat, codigo_unidmedida, codigo_forn, valorvenda, ncm, codigobarra, peso " + 
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
				produtoBean.setCodigo_cat(rs.getLong("codigo_cat"));
				produtoBean.setCodigo_unidmedida(rs.getLong("codigo_unidmedida"));
				produtoBean.setCodigo_forn(rs.getLong("codigo_forn"));
				produtoBean.setValorVenda(rs.getDouble("valorvenda"));
				produtoBean.setNcm(rs.getInt("ncm"));
				produtoBean.setCodigoBarra(rs.getLong("codigobarra"));
				produtoBean.setPeso(rs.getDouble("peso"));
				
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
			
			String sql = "SELECT codigo, nome, valor, quantidade, datacadastro, codigo_cat, codigo_unidmedida, codigo_forn, valorvenda, ncm, codigobarra, peso " + 
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
				produtoBean.setCodigo_cat(rs.getLong("codigo_cat"));
				produtoBean.setCodigo_unidmedida(rs.getLong("codigo_unidmedida"));
				produtoBean.setCodigo_forn(rs.getLong("codigo_forn"));
				produtoBean.setValorVenda(rs.getDouble("valorvenda"));
				produtoBean.setNcm(rs.getInt("ncm"));
				produtoBean.setCodigoBarra(rs.getLong("codigobarra"));
				produtoBean.setPeso(rs.getDouble("peso"));
				
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
					"   SET codigo=?, nome=?, valor=?, quantidade=?, datacadastro=?, codigo_cat=?, codigo_unidmedida=?, codigo_forn=?, valorvenda=?, ncm=?, codigobarra=?, peso=? " + 
					" 	WHERE codigo = '" + produtoBean.getCodigo() + "'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, produtoBean.getCodigo());
			ps.setString(2, produtoBean.getNome());
			ps.setDouble(3, produtoBean.getValor());
			ps.setInt(4, produtoBean.getQuantidade());
			ps.setDate(5, new Date(produtoBean.getDataCadastro().getTime()));
			ps.setLong(6, produtoBean.getCodigo_cat());
			ps.setLong(7, produtoBean.getCodigo_unidmedida());
			ps.setLong(8, produtoBean.getCodigo_forn());
			ps.setDouble(9, produtoBean.getValorVenda());
			ps.setInt(10, produtoBean.getNcm());
			ps.setLong(11, produtoBean.getCodigoBarra());
			ps.setDouble(12, produtoBean.getPeso());
			
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
	
	/**
	 * Lista de categorias cadastradas no bd
	 * @return
	 */
	public List<CategoriaBean> listarTodasCategorias() {
		try {
			List<CategoriaBean> listar = new ArrayList<CategoriaBean>();
			String sql = "SELECT codigo, descricao FROM public.categoria ORDER BY codigo;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			/*para cada linha, vai iniciar um novo objeto e adicionar na lista*/
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
	
	/**
	 * Lista de fornecedores cadastradas no bd
	 * @return
	 */
	public List<FornecedorBean> listarTodosFornecedor(){
		try {
			
			List<FornecedorBean> listar = new ArrayList<FornecedorBean>();
			
			String sql = "SELECT codigo, razaosocial, nomefantasia, cnpj, inscricaoestadual, inscricaomunicipal, datacadastro, "
					+ "  cep, logradouro, numero, bairro, cidade, estado, ibge" 
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
				
				listar.add(fornecedorBean);
			}
			
			return listar;
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Lista de unidade de medidas cadastradas no bd
	 */
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

}
