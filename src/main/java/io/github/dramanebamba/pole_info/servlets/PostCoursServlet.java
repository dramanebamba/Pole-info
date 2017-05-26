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

import main.java.io.github.dramanebamba.pole_info.model.Cours;
import pole_info.CoursDAO;


/**
 * Servlet implementation class Identification
 */
@WebServlet("/PostCoursServlet")
public class PostCoursServlet extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@Inject
	CoursDAO coursDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostCoursServlet() 
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/PostCours.jsp");
		dispatch.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		//String operation = request.getParameter("operation");
		String master = request.getParameter("nom_master");
		String contenu = request.getParameter("nom_contenu");
		String enseignant = request.getParameter("nom_enseignant");
		String periode = request.getParameter("periode");
		String obligatoire = request.getParameter("obligatoire");
		String notes = request.getParameter("notes");


		String connected = (String) session.getAttribute("connected");
		session.setAttribute("true", connected);

		int id_master = coursDAO.getIdMaster(master);
		int id_contenu = coursDAO.getIdContenu(contenu);
		int id_enseignant = coursDAO.getIdEnseignant(enseignant);

		coursDAO.creerCours(new Cours(id_master,id_contenu,id_enseignant,periode,obligatoire, notes));
		System.out.println("Nouveau cours créé");

		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp");
		dispatch.forward(request, response);

	}
}
