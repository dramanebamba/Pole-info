package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/creationContenu.html");
		dispatch.forward(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession session = request.getSession(true);
		String operation = request.getParameter("operation");
		String nomMat = request.getParameter("nomMat");
		/*
		String desc = request.getParameter("description");
		String app = request.getParameter("apprentissage");
		String vol_horaire = request.getParameter("vol_horaire");
		String ects = request.getParameter("ects");
		String obj = request.getParameter("objectives");
		String content = request.getParameter("contents");
		String biblio = request.getParameter("biblio");
		*/
		
		if(operation.equals("createContenu"))
			response.getWriter().println(verificationCreationContenu.CreationContenu(nomMat));
	}
}
