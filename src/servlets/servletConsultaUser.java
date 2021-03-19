package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUsuario;

@WebServlet(name = "servletConsultaUser", urlPatterns = { "/servletConsultaUser" })
public class servletConsultaUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoUsuario dao = new DaoUsuario();
	
    public servletConsultaUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if (acao != null && acao.equalsIgnoreCase("listarTodos")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/consultaUser.jsp");
			request.setAttribute("usuarios", dao.listarTodosUsuarios());
			dispatcher.forward(request, response);
		}
	}

}
