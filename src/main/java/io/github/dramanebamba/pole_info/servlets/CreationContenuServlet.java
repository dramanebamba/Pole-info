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

/**
 * Servlet implementation class Identification
 */
@WebServlet("/creationContenu")
public class CreationContenuServlet extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	@Inject
	private VerificationCreationContenuService verificationCreationContenu;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationContenuServlet() 
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/creationContenu.html");
		dispatch.forward(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession session = request.getSession(true);
		String operation = request.getParameter("operation");
		String nom = (String) request.getParameter("nom");
		String desc = (String) request.getParameter("description");
		String app = (String) request.getParameter("apprentissage");
		String vol_horaire = (String) request.getParameter("vol_horaire");
		String ects = (String) request.getParameter("ects");
		String obj = (String) request.getParameter("objectives");
		String content = (String) request.getParameter("contents");
		String biblio = (String) request.getParameter("biblio");
		
		
		if(operation.equals("createContenu"))
			response.getWriter().println(verificationCreationContenu.CreationContenu(nom));
	}
}
