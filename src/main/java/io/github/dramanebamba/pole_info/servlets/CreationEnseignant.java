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
@WebServlet("/creationEnseignant")
public class CreationEnseignant extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	@Inject
	private VerificationCreationEnseignant verificationCreationEnseignant;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationEnseignant() 
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/creationEnseignant.html");
		dispatch.forward(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String operation = request.getParameter("operation");
		String nom = (String) request.getParameter("last_name");
		String prenom = (String) request.getParameter("first_name");
		String mail = (String) request.getParameter("mail");
		String sitn =(String) request.getParameter("SITN");
		
		
		System.out.println("Operation : " + operation);
		System.out.println("nom : " + nom);
		System.out.println("prenom : " + prenom);
		System.out.println("mail : " + mail);
		System.out.println("sitn : " + sitn);
		
		if(operation.equals("confAuth")){
			response.getWriter().println(verificationCreationEnseignant.CreationEnseignant(nom,prenom,mail,sitn));
		}
	}
	
}
