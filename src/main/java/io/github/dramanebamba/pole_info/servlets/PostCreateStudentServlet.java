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
import main.java.io.github.dramanebamba.pole_info.model.*;

/**
 * Servlet implementation class Identification
 */
@WebServlet("/PostCreateStudent")
public class PostCreateStudentServlet extends HttpServlet 
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	
	@Inject
	private VerificationBDDService verification_BDD;
	
	@Inject
	PersonneDAO persDAO;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostCreateStudentServlet() 
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true);
		String operation = request.getParameter("operation");
		String nom = request.getParameter("last_name");
		String prenom = request.getParameter("first_name");
		String mail = request.getParameter("email");
		String parcours = request.getParameter("parcours");
		String connected = (String) session.getAttribute("connected");
		
		session.setAttribute("true", connected);
		System.out.println("Operation : " + operation);

		//if(operation.equals("createStudent")){
				System.out.println("Création etudiant...");
				
				if(verification_BDD.verification(mail)) // CDI : Si true alors la personne peut etre ajoutee, sinon deja en BDD
				{
					persDAO.creerPersonne(new Personne(nom, prenom, mail, "", "", "", "", "", "", 0, 0, "S"));
					System.out.println("Nouvel étudiant créé : " + prenom + " " + nom + " / " + mail + " / " + parcours);
					System.out.println(prenom + " " + nom + " ajouté en BDD");
				}
				else
					System.out.println("Erreur : L'étudiant est déjà en base de données (email). Retour au menu.");
				
				RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp");
				dispatch.forward(request, response);
	/*	}
		else{
				response.getWriter().println("KO");
		}*/
	}
}
