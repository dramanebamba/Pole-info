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
import pole_info.Personne;
import pole_info.PersonneDAO;

/**
 * Servlet implementation class Identification
 */
@WebServlet("/creationEnseignant")
public class CreationEnseignantServlet extends HttpServlet 
{
	@Inject
	private VerificationBDDService verification_BDD;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	@Inject
	PersonneDAO persDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationEnseignantServlet() 
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/creationEnseignant.html");
		dispatch.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String operation = request.getParameter("operation");
		String nom = request.getParameter("last_name");
		String prenom = request.getParameter("first_name");
		String mail = request.getParameter("mail");
		String connected = (String) session.getAttribute("connected");
		
		System.out.println("Operation : " + operation);
		System.out.println("nom : " + nom);
		System.out.println("prenom : " + prenom);
		System.out.println("mail : " + mail);
		
		session.setAttribute("true", connected);

		if(operation.equals("createProf")){
				System.out.println("Création enseignant...");
				
				if(verification_BDD.verification(mail)) // CDI : Si true alors la personne peut etre ajoutee, sinon deja en BDD
				{
					persDAO.creerPersonne(new Personne(nom, prenom, mail, "", "", "", "", "", "", 0, 0, "M"));
					System.out.println("Nouvel enseignant créé : " + prenom + " " + nom + " / " + mail );
					System.out.println(prenom + " " + nom + " ajouté en BDD");
				}
				else
					System.out.println("Erreur : L'enseignant est déjà en base de données (email). Retour au menu.");
				
				RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp");
				dispatch.forward(request, response);
		}
		else{
				response.getWriter().println("KO");
		}
	}
}
