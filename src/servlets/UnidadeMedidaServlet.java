package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUnidadeMedida;
import model.classes.beans.CategoriaBean;
import model.classes.beans.UnidadeMedidaBean;

@WebServlet("/unidadeMedidaServlet")
public class UnidadeMedidaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoUnidadeMedida daoUm = new DaoUnidadeMedida();
       
    public UnidadeMedidaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		String um = request.getParameter("um");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-unimedidas.jsp");
		
		if (acao != null && acao.equalsIgnoreCase("delete")) {
			daoUm.delete(Long.parseLong(um));
			request.setAttribute("mensagem", "Registro excluído com sucesso!");
			
			request.setAttribute("unimedidas", daoUm.listarTodasUnMedidas());
			
		} else 
			
		if (acao != null && acao.equalsIgnoreCase("update")) {
			UnidadeMedidaBean umb = daoUm.consultarCodUniMedida(Long.parseLong(um));
			
			request.setAttribute("um", umb);
			
		} else
			
		if (acao != null && acao.equalsIgnoreCase("listarTodos")) {
			
			request.setAttribute("unimedidas", daoUm.listarTodasUnMedidas());
		}
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("codigo");
		String sigla = request.getParameter("sigla");
		String descricao = request.getParameter("descricao");
		
		UnidadeMedidaBean umb = new UnidadeMedidaBean();
		umb.setCodigo(!codigo.isEmpty() ? Long.parseLong(codigo) : null);
		umb.setSigla(sigla);
		umb.setDescricao(descricao);
		
		if (codigo == null || codigo.isEmpty()) {
			daoUm.salvar(umb);
			request.setAttribute("mensagem", "Cadastro efetuado com sucesso!");
		} else {
			
			daoUm.update(umb);
			request.setAttribute("mensagem", "Registro atualizado com sucesso!");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-unimedidas.jsp");
		request.setAttribute("unimedidas", daoUm.listarTodasUnMedidas());
		dispatcher.forward(request, response);
		
	}

}
