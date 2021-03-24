package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFornecedor;
import model.classes.beans.FornecedorBean;

/**
 * Servlet implementation class FornecedorServlet
 */
@WebServlet("/fornecedorServlet")
public class FornecedorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoFornecedor daoFornecedor = new DaoFornecedor();
       
    public FornecedorServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		String forn = request.getParameter("forn");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-fornecedores.jsp");
		
		if (acao != null && acao.equalsIgnoreCase("delete")) {
			daoFornecedor.delete(Long.parseLong(forn));
			request.setAttribute("mensagem", "Registro removido com sucesso!");
			
			request.setAttribute("fornecedores", daoFornecedor.listarTodosFornecedor());
			
		} else if (acao != null && acao.equalsIgnoreCase("update")) {
			FornecedorBean fornecedorBean = daoFornecedor.consultarCodigo(Long.parseLong(forn));
			
			request.setAttribute("forn", fornecedorBean);
			
		} else if (acao != null && acao.equalsIgnoreCase("visualizar")) {
			FornecedorBean fornecedorBean = daoFornecedor.consultarCodigo(Long.parseLong(forn));
			request.setAttribute("forn", fornecedorBean);
				
		} else if (acao.equalsIgnoreCase("listarTodos")) {
			
			request.setAttribute("fornecedores", daoFornecedor.listarTodosFornecedor());
		}
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("codigo");
		String razaosocial = request.getParameter("razaosocial");
		String nomefantasia = request.getParameter("nomefantasia");
		String cnpj = request.getParameter("cnpj");
		String inscricaoestadual = request.getParameter("inscricaoestadual");
		String inscricaomunicipal = request.getParameter("inscricaomunicipal");
		
		//dados do endereço
		String cep = request.getParameter("cep");
		String logradouro = request.getParameter("logradouro");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String ibge = request.getParameter("ibge");
		
		String empresa = request.getParameter("empresa");
		
		
		//criando uma nova instância do objeto fornecedor
		FornecedorBean fornecedorBean = new FornecedorBean();
		fornecedorBean.setCodigo(!codigo.isEmpty() ? Long.parseLong(codigo) : null);
		fornecedorBean.setRazaoSocial(razaosocial);
		fornecedorBean.setNomeFantasia(nomefantasia);
		fornecedorBean.setCnpj(cnpj);
		fornecedorBean.setInscricaoEstadual(inscricaoestadual);
		fornecedorBean.setInscricaoMunicipal(inscricaomunicipal);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			
			fornecedorBean.setDataCadastro(df.parse(request.getParameter("datacadastro")));
		} catch (ParseException e) {
			fornecedorBean.setDataCadastro(new Date());
		}
		
		fornecedorBean.setCep(cep);
		fornecedorBean.setLogradouro(logradouro);
		fornecedorBean.setNumero(numero);
		fornecedorBean.setBairro(bairro);
		fornecedorBean.setCidade(cidade);
		fornecedorBean.setEstado(estado);
		fornecedorBean.setIbge(Integer.parseInt(ibge));
		fornecedorBean.setEmpresa(empresa);
		
		String mensagem = null;
		boolean podeInserir = true;
		
		if (codigo != null || !codigo.isEmpty() && !daoFornecedor.verificarCnpj(cnpj)) {
			request.setAttribute("mensagem", "Esse cnpj já estar cadastrado para outro fornecedor!");
		}
		
		if (codigo == null || codigo.isEmpty() && daoFornecedor.verificarCnpj(cnpj) && podeInserir) {
			daoFornecedor.salvar(fornecedorBean);
			request.setAttribute("mensagem", "Cadastro efetuado com sucesso!");
		} else if (codigo != null && !codigo.isEmpty() && podeInserir) {
			daoFornecedor.update(fornecedorBean);
			request.setAttribute("mensagem", "Registro atualizado com sucesso!");
		}
		
		if (!podeInserir) {
			request.setAttribute("forn", fornecedorBean);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-fornecedores.jsp");
		request.setAttribute("fornecedores", daoFornecedor.listarTodosFornecedor());
		dispatcher.forward(request, response);
	}

}
