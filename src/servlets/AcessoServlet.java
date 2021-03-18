package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDao;
import model.classes.beans.UsuarioBean;

@WebServlet("/acessoServlet")
public class AcessoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private UsuarioDao usuarioDao = new UsuarioDao();
       
    public AcessoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//parâmetros da página jsp
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		//iniciando um objeto usuario
		UsuarioBean usuarioBean = new UsuarioBean();
		usuarioBean.setLogin(login);
		usuarioBean.setSenha(senha);
		
		UsuarioBean usuarioAutenticado = usuarioDao.validarUsuario(usuarioBean);
		
		if (usuarioAutenticado != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuario", usuarioAutenticado);
			RequestDispatcher dispatcher = request.getRequestDispatcher("acessoliberado.jsp");
			dispatcher.forward(request, response);
			
		} else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("acessonegado.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	}

}
