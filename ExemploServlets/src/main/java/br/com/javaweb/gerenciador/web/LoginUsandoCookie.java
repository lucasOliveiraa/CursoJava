package br.com.javaweb.gerenciador.web;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.javaweb.gerenciador.Usuario;
import br.com.javaweb.gerenciador.dao.UsuarioDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/logincookie")
public class LoginUsandoCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginUsandoCookie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuarioEncotrado = new UsuarioDAO().buscaPorEmailESenha(email, senha);		
		
		if (usuarioEncotrado == null) {
			response.sendRedirect("/ExemploServlets/erro.html");
		} 
		else {
			Cookie cookie = new Cookie("usuario.logado", email);
			response.addCookie(cookie);
			response.sendRedirect("/ExemploServlets/index.html");
		}
	}

}
