package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUsuario;


@WebServlet("/consultaUserServlet")
public class ConsultaUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoUsuario daoUsuario = new DaoUsuario();
       
    public ConsultaUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if (acao != null && acao.equalsIgnoreCase("listarTodos")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/consultaUser.jsp");
			request.setAttribute("usuarios", daoUsuario.listarTodosUsuarios());
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
