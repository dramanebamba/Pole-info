package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.io.github.dramanebamba.pole_info.model.Contenu;
import main.java.io.github.dramanebamba.pole_info.model.Cours;
import main.java.io.github.dramanebamba.pole_info.service.ContenuDAO;
import main.java.io.github.dramanebamba.pole_info.service.CoursDAO;

@WebServlet("/PostContenuServlet")
public class PostContenuServlet extends HttpServlet {
	public static final String VUE = "/WEB-INF/PostContenu.jsp";
	private static final long serialVersionUID = 1L;

	@Inject
	private ContenuDAO contenuDAO;
	
	@Inject
	private CoursDAO coursDAO;

	public PostContenuServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher(VUE);
		//dispatch.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// int id = Integer.parseInt(request.getParameter("id"));
		int lastIdContenu = contenuDAO.getLastContenuId() + 1;
		
		System.out.println("lastIdContenu : " + lastIdContenu);
		
		//Cours fictif = new Cours(0,lastIdContenu,0,null,"O",null);
		//coursDAO.creerCours(fictif);
		
		coursDAO.creerCours(new Cours(0,lastIdContenu,0,null,"O",null));
		
		String apprentissage = request.getParameter("apprentissage");
		char app = apprentissage.charAt(0);
		String biblio = request.getParameter("biblio");
		String contents = request.getParameter("contents");
		String description = request.getParameter("description");
		String ects = request.getParameter("ects");
		String nom = request.getParameter("nom");
		String objectives = request.getParameter("objectives");
		int volumeHoraire = Integer.parseInt(request.getParameter("volumeHoraire"));
		int volumeProjet = Integer.parseInt(request.getParameter("volumeProjet"));

		contenuDAO.creerContenu(new Contenu(nom, description, app, volumeHoraire, ects, volumeProjet, contents, biblio, objectives));
		System.out.println("Nouveau contenu créé : " + nom +" / " + description);
		System.out.println(nom + " ajouté en base de données !");
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/PostContenu.jsp");
		dispatch.forward(request, response);

	}

}
