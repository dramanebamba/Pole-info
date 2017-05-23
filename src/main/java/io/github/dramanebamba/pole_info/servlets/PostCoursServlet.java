package io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.dramanebamba.pole_info.model.Cours;
import io.github.dramanebamba.pole_info.service.CoursService;

@WebServlet("/PostCoursServlet")
public class PostCoursServlet extends HttpServlet {
	public static final String VUE = "/WEB-INF/PostCours.jsp";
	private static final long serialVersionUID = 1L;

	@Inject
	private CoursService Cours;

	public PostCoursServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher(VUE);
		dispatch.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		int id_master = Integer.parseInt(request.getParameter("id_master"));
		int id_contenu = Integer.parseInt(request.getParameter("id_contenu"));
		String periode = request.getParameter("periode");
		String obligatoire = request.getParameter("obligatoire");
		String notes = request.getParameter("notes");
		int id_enseignant = Integer.parseInt(request.getParameter("id_enseignant"));

		Cours cours = new Cours(id_master, id_contenu, id_enseignant, periode, obligatoire, notes);
		System.out.println(cours);
		Cours.persist(cours);
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/PostCours.jsp");
		dispatch.forward(request, response);

	}

}
