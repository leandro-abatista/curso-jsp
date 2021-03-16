package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoTelefone;
import dao.DaoUsuario;
import model.classes.beans.Telefone;
import model.classes.beans.UsuarioBean;

/**
 * Servlet implementation class TelefoneServlet
 */
@WebServlet("/telefonesServlet")
public class TelefoneServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoUsuario daoUsuario = new DaoUsuario();
	
	private DaoTelefone daoTelefone = new DaoTelefone();
       
    public TelefoneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		//aqui estou captando o usuário da sessão
		String user = request.getParameter("user");
		
		if (user != null) {
			if (acao != null && acao.equalsIgnoreCase("addTel")) {
				UsuarioBean usuarioBean = daoUsuario.consultarCodigo(Long.parseLong(user));
				
				//colocando o usuário na sessão
				//codigo do usuário
				request.getSession().setAttribute("userSelecionado", usuarioBean);
				request.setAttribute("userSelecionado", usuarioBean);
				/*
				//nome do usuario
				request.getSession().setAttribute("nomeUser", usuarioBean.getNome());
				*/
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-telefones.jsp");
				request.setAttribute("telefones", daoTelefone.listarTodosTelefones(usuarioBean.getCodigo()));
				dispatcher.forward(request, response);
				
			} else 
				
			if (acao != null && acao.equalsIgnoreCase("delete")) {
				
				String foneId = request.getParameter("foneId");
				daoTelefone.delete(Long.parseLong(foneId));
				request.setAttribute("mensagem", "Registro excluído com sucesso!");
				
				UsuarioBean usuarioBean = (UsuarioBean) request.getSession().getAttribute("userSelecionado");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-telefones.jsp");
				request.setAttribute("telefones", daoTelefone.listarTodosTelefones(usuarioBean.getCodigo()));
				dispatcher.forward(request, response);
				
			} else {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-usuarios.jsp");
				request.setAttribute("usuarios", daoUsuario.listarTodosUsuarios());
				dispatcher.forward(request, response);
				
			}
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//aqui tô pegando o codigo do usuário para gravar o telefone
		UsuarioBean usuarioBean = (UsuarioBean) request.getSession().getAttribute("userSelecionado");
		
		String codigo = request.getParameter("codigoT");
		String tipo = request.getParameter("tipo");
		String numero = request.getParameter("numero");
		
		Telefone telefone = new Telefone();
		telefone.setCodigo(!codigo.isEmpty() ? Long.parseLong(codigo) : null);
		telefone.setTipo(tipo);
		telefone.setNumero(numero);
		telefone.setUsuario(usuarioBean.getCodigo());
		
		
		if (codigo == null || codigo.isEmpty()) {
			daoTelefone.salvar(telefone);
			request.setAttribute("mensagem", "Telefone adicionado com sucesso!");
			
			//No caso de querer adicionar mais telefones ao usuário da sessão
			request.getSession().setAttribute("userSelecionado", usuarioBean);
			request.setAttribute("userSelecionado", usuarioBean);
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-telefones.jsp");
		request.setAttribute("telefones", daoTelefone.listarTodosTelefones(usuarioBean.getCodigo()));
		dispatcher.forward(request, response);
		
	}

}
