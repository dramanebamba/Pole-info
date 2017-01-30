package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;
import java.util.Vector;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.io.github.dramanebamba.pole_info.model.Cours;
import main.java.io.github.dramanebamba.pole_info.service.CoursService;

/**
 * Servlet implementation class GetCoursServlet
 */
@WebServlet("/GetCoursServlet")
public class GetCoursServlet extends HttpServlet {
	public static final String ATT_MESSAGES = "cours";
	public static final String VUE          = "/WEB-INF/GetCours.jsp";
	private static final long serialVersionUID = 1L;
	@Inject
	CoursService cours;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCoursServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Vector<Cours> listeCours = cours.getCours();
		request.setAttribute(ATT_MESSAGES,listeCours);
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
