package io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.dramanebamba.pole_info.model.Cours;
import io.github.dramanebamba.pole_info.model.Preference;
import io.github.dramanebamba.pole_info.service.PreferenceService;

/**
 * Servlet implementation class PostPreferenceServlet
 */
@WebServlet("/PostPreferenceServlet")
public class PostPreferenceServlet extends HttpServlet {
	public static final String VUE = "/WEB-INF/PostPreference.jsp";
	private static final long serialVersionUID = 1L;

	@Inject
	private PreferenceService Preference;
	
	@PersistenceContext
	private EntityManager em;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostPreferenceServlet() {
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
		int id_master = Integer.parseInt(request.getParameter("id_master"));
		int id_contenu = Integer.parseInt(request.getParameter("id_contenu"));
		int id_personne = Integer.parseInt(request.getParameter("id_personne"));
		int niveau = Integer.parseInt(request.getParameter("niveau"));

		Preference preference = new Preference(id_master, id_contenu, id_personne, niveau);
		System.out.println(preference);
		Preference.persist(preference);
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/PostPreference.jsp");
		dispatch.forward(request, response);
	}

}
