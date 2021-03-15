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

import dao.DaoProduto;
import model.classes.beans.ProdutoBean;

@WebServlet("/produtoServlet")
public class ProdutoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoProduto daoProduto = new DaoProduto();
       
    public ProdutoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		String prod = request.getParameter("prod");
		
		if (acao != null && acao.equalsIgnoreCase("delete")) {
			daoProduto.delete(Long.parseLong(prod));
			request.setAttribute("mensagem", "Cadastro efetuado com sucesso!");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-produtos.jsp");
			request.setAttribute("produtos", daoProduto.listarTodosProdutos());
			dispatcher.forward(request, response);
			
		} else 
			
		if (acao != null && acao.equalsIgnoreCase("update")) {
			ProdutoBean produtoBean = daoProduto.consultarProduto(Long.parseLong(prod));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-produtos.jsp");
			request.setAttribute("prod",produtoBean);
			dispatcher.forward(request, response);
		} else
			
		if (acao != null && acao.equalsIgnoreCase("listarTodos")) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-produtos.jsp");
			request.setAttribute("produtos", daoProduto.listarTodosProdutos());
			dispatcher.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("codigo");
		String nome = request.getParameter("nome");
		String valor = request.getParameter("valor");
		String quantidade = request.getParameter("quantidade");
		
		ProdutoBean produtoBean = new ProdutoBean();
		produtoBean.setCodigo(!codigo.isEmpty() ? Long.parseLong(codigo) : null);
		produtoBean.setNome(nome);
		produtoBean.setValor(Double.parseDouble(valor));
		produtoBean.setQuantidade(Integer.parseInt(quantidade));
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			
			produtoBean.setDataCadastro(df.parse(request.getParameter("datacadastro")));
		} catch (ParseException e) {
			produtoBean.setDataCadastro(new Date());
		}
		
		String mensagem = null;
		boolean podeInserir = true;
		
		if (nome == null || nome.isEmpty()) {
			request.setAttribute("mensagem", "Informe o nome do produto!");
			podeInserir = false;
		} else
		
		
		if (codigo == null || codigo.isEmpty() && !daoProduto.verificarNomePro(nome)) {
			request.setAttribute("mensagem", "Produto já estar cadastrado!");
			podeInserir = false;
		}
		
		if (codigo == null || codigo.isEmpty() && daoProduto.verificarNomePro(nome) && podeInserir) {
			daoProduto.salvar(produtoBean);
			request.setAttribute("mensagem", "Cadastro efetuado com sucesso!");
		} else 
		
		if (codigo != null && !codigo.isEmpty() && podeInserir) {
			daoProduto.update(produtoBean);
			request.setAttribute("mensagem", "Registro atualizado com sucesso!");
		}
		
		
		
		if (!podeInserir) {
			request.setAttribute("prod", produtoBean);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-produtos.jsp");
		request.setAttribute("produtos", daoProduto.listarTodosProdutos());
		dispatcher.forward(request, response);
		
	}

}
