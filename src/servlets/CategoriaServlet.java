package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoCategoria;
import model.classes.beans.CategoriaBean;

@WebServlet("/categoriaServlet")
public class CategoriaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoCategoria daoCategoria = new DaoCategoria();
       
    public CategoriaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String cat = request.getParameter("cat");
		
		if (acao != null && acao.equalsIgnoreCase("delete")) {
			daoCategoria.delete(Long.parseLong(cat));
			request.setAttribute("mensagem", "Registro excluído com sucesso!");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-categorias.jsp");
			request.setAttribute("categorias", daoCategoria.listarTodasCategorias());
			dispatcher.forward(request, response);
			
		} else 
			
		if (acao != null && acao.equalsIgnoreCase("update")) {
			CategoriaBean categoriaBean = daoCategoria.consultarCategoria(Long.parseLong(cat));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-categorias.jsp");
			request.setAttribute("cat", categoriaBean);
			dispatcher.forward(request, response);
			
		} else
			
		if (acao != null && acao.equalsIgnoreCase("listarTodos")) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-categorias.jsp");
			request.setAttribute("categorias", daoCategoria.listarTodasCategorias());
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("codigo");
		String descricao = request.getParameter("descricao");
		
		CategoriaBean categoriaBean = new CategoriaBean();
		categoriaBean.setCodigo(!codigo.isEmpty() ? Long.parseLong(codigo) : null);
		categoriaBean.setDescricao(descricao);
		
		if (codigo == null || codigo.isEmpty()) {
			daoCategoria.salvar(categoriaBean);
			request.setAttribute("mensagem", "Cadastro efetuado com sucesso!");
		} else {
			
			daoCategoria.update(categoriaBean);
			request.setAttribute("mensagem", "Registro atualizado com sucesso!");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-categorias.jsp");
		request.setAttribute("categorias", daoCategoria.listarTodasCategorias());
		dispatcher.forward(request, response);
		
	}

}
