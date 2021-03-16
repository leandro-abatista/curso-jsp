package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUsuario;
import model.classes.beans.UsuarioBean;

@WebServlet("/usuarioServlet")
public class UsuarioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoUsuario daoUsuario = new DaoUsuario();
	
    public UsuarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		String user = request.getParameter("user");
		
		if (acao.equalsIgnoreCase("delete")) {
			daoUsuario.delete(Long.parseLong(user));
			request.setAttribute("mensagem", "Cadastro removido com sucesso!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-usuarios.jsp");
			request.setAttribute("usuarios", daoUsuario.listarTodosUsuarios());
			dispatcher.forward(request, response);
			
		} else
			
		if(acao.equalsIgnoreCase("update")) {
			UsuarioBean usuarioBean = daoUsuario.consultarCodigo(Long.valueOf(user));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-usuarios.jsp");
			request.setAttribute("user", usuarioBean);
			dispatcher.forward(request, response);
			
		} else 
			
		if(acao.equalsIgnoreCase("listarTodos")) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-usuarios.jsp");
			request.setAttribute("usuarios", daoUsuario.listarTodosUsuarios());
			dispatcher.forward(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codigo = request.getParameter("codigo");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		
		
		UsuarioBean usuarioBean = new UsuarioBean();
		usuarioBean.setCodigo(!codigo.isEmpty() ? Long.parseLong(codigo) : null);
		usuarioBean.setLogin(login);
		usuarioBean.setSenha(senha);
		usuarioBean.setNome(nome);
		usuarioBean.setCpf(cpf);
		usuarioBean.setTelefone(telefone);
		usuarioBean.setEmail(email);
		
		String mensagem = null;
		boolean podeInserir = true;
		
		if (codigo == null || codigo.isEmpty() && !daoUsuario.verificarLogin(login)) {
			request.setAttribute("mensagem", "Já existe um usuário com o mesmo login!");
			podeInserir = false;
		} else
		if (codigo == null || codigo.isEmpty() && !daoUsuario.verificarSenha(senha)) {
			request.setAttribute("mensagem", "Já existe um usuário com a mesma senha!");
			podeInserir = false;
		}
		
		if (codigo == null || codigo.isEmpty() && daoUsuario.verificarLogin(login) && podeInserir) {
			daoUsuario.salvar(usuarioBean);
			request.setAttribute("mensagem", "Cadastro efetuado com sucesso!");
		} else 
			
		if(codigo != null && !codigo.isEmpty() && podeInserir) {
			
			if (!daoUsuario.verificarLoginUpdate(login, Long.parseLong(codigo))) {
				request.setAttribute("mensagem", "Já existe um usuário com o mesmo login!");
			} else if (!daoUsuario.verificarSenhaUpdate(senha, Long.parseLong(codigo))) {
				request.setAttribute("mensagem", "Já existe um usuário com a mesma senha!");
			} else {
				daoUsuario.atualizar(usuarioBean);
				request.setAttribute("mensagem", "Registro atualizado com sucesso!");
			}
			
		}
		
		if (!podeInserir) {
			request.setAttribute("user", usuarioBean);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cad-usuarios.jsp");
		request.setAttribute("usuarios", daoUsuario.listarTodosUsuarios());
		dispatcher.forward(request, response);
	}

}
