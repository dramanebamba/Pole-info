package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import main.java.io.github.dramanebamba.pole_info.service.*;
import pole_info.PersonneDAO;

/**
 * Servlet implementation class Identification
 */
@WebServlet("/PostConnexion")
public class PostConnexionServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	@Inject
	PersonneDAO persDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostConnexionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true);
		//String operation = request.getParameter("operation");
		String login = request.getParameter("login");
		String pw = request.getParameter("password");

		//System.out.println("Operation : " + operation);

		/*if(operation.equals("logout")){
			session.setAttribute("connected", "false");
			RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/index.html");
			dispatch.forward(request, response);
		} else*/
		if(persDAO.trouverPersonne(login,pw)){
			int id = persDAO.getId(login, pw);
			String roles = persDAO.getRoles(login, pw);
			int id_m = persDAO.getMaster(login, pw);
			session.setAttribute("id_m", id_m);
			session.setAttribute("roles", roles);
			session.setAttribute("id", id);
			session.setAttribute("connected", "true");
			session.setAttribute("login", login);
			RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp");
			dispatch.forward(request, response);
		}
		else
		{
			System.out.println("Erreur lors de l'authentification, veuillez reessayer");
			RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/index.html");
			dispatch.forward(request, response);
		}
	}
}
