package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.io.github.dramanebamba.pole_info.model.Cours;
import main.java.io.github.dramanebamba.pole_info.service.CoursService;

/**
* Servlet implementation class PostCoursServlet
*/
@WebServlet("/PostCoursServlet")
public class PostCoursServlet extends HttpServlet {
	public static final String VUE = "/WEB-INF/PostCours.jsp";
	private static final long serialVersionUID = 1L;

	@Inject
	private CoursService Cours;

	/**
	* @see HttpServlet#HttpServlet()
	*/
	public PostCoursServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	*/
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher(VUE);
		dispatch.forward(request, response);

	}

	/**
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id_master = Integer.parseInt(request.getParameter("id_master"));
		int id_contenu = Integer.parseInt(request.getParameter("id_contenu"));
		int id_enseignant = Integer.parseInt(request.getParameter("id_enseignant"));
		String periode = request.getParameter("periode");
		String obligatoire = request.getParameter("obligatoire");
		String notes = request.getParameter("notes");

		Cours.getCours().add(new Cours(id_master, id_contenu, id_enseignant, periode, obligatoire, notes));
		System.out.println("Création d'un nouveau cours : " + " id_master : " + id_master + " id_contenu : " + id_contenu + " id_enseignant : " + id_enseignant + " periode : " + periode + " obligatoire : " + obligatoire + " notes : " + notes);
		System.out.println(Cours.getCours().size() + " cours créé en base de données");
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/PostCours.jsp");
		dispatch.forward(request, response);
	}

}
