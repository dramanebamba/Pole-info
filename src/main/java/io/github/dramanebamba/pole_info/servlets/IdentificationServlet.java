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
@WebServlet("/identification")
public class IdentificationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	@Inject
	PersonneDAO persDAO;
	//private VerificationLoginService verification_login;	// CDI servant à verifier que les identifiants sont en BDD

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IdentificationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/identification.html");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String operation = request.getParameter("operation");
		String login = request.getParameter("login");
		String pw = request.getParameter("password");

		System.out.println("Operation : " + operation);

		/*
		// Test en BDD par le CDI
		if(operation.equals("confAuth") && verification_login.test(login,pw)){
			request.setAttribute("connected", "true");
			session.setAttribute("connected", "true");
			RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp");
			dispatch.forward(request, response);
			// System.out.println(session.getAttribute("connect"));
		}
		if(operation.equals("logout")){
			request.setAttribute("connected", "false");
			session.setAttribute("connected", "false");
			RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/index.html");
			dispatch.forward(request, response);
			// System.out.println(session.getAttribute("connect"));
		}
		*/
		
		
		persDAO.trouverPersonne("admin", "admin");
		
		System.out.println("TEST");
		
	}
}
