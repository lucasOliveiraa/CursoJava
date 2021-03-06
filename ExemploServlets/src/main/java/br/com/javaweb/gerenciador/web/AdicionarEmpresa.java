package br.com.javaweb.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.javaweb.gerenciador.Empresa;
import br.com.javaweb.gerenciador.dao.EmpresaDAO;

/**
 * Servlet implementation class AdicionarEmpresa
 */
@WebServlet("/adicionaEmpresa")
public class AdicionarEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdicionarEmpresa() {
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
		// TODO Auto-generated method stub
		// doGet(request, response);

		String nome = request.getParameter("nome");

		Empresa empresa = new Empresa(nome);

		new EmpresaDAO().adiciona(empresa);
		
		//Aqui estavamos implementando o código direto
		
		// PrintWriter writer = response.getWriter();
		// writer.println("<html> <body> Empresa: "+ nomeEmpresa +
		// " inserida com sucesso!" +
		// "</body><html>");

		request.setAttribute("empresa", empresa.getNome());

		RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/paginas/novaEmpresa.jsp");

		disp.forward(request, response);
	}

}
