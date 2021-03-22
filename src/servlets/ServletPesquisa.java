package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUsuario;
import model.classes.beans.UsuarioBean;

/**
 * Servlet implementation class ServletPesquisa
 */
@WebServlet("/servletPesquisa")
public class ServletPesquisa extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoUsuario daoUsuario = new DaoUsuario();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descricaoPesquisa = request.getParameter("descricao");

		if (descricaoPesquisa != null && !descricaoPesquisa.trim().isEmpty()) {
			List<UsuarioBean> listaDeUsuarios = daoUsuario.listarTodosUsuarios(descricaoPesquisa);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/consultaUser.jsp");
			request.setAttribute("usuarios", listaDeUsuarios);
			dispatcher.forward(request, response);

		} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/consultaUser.jsp");
			request.setAttribute("usuarios", daoUsuario.listarTodosUsuarios());
			dispatcher.forward(request, response);
		}
		
	}

}
