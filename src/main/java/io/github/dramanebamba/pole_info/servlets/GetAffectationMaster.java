package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import main.java.io.github.dramanebamba.pole_info.service.*;
import main.java.io.github.dramanebamba.pole_info.model.*;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Affectations
 */
@WebServlet("/GetAffectationMaster")
public class GetAffectationMaster extends HttpServlet {
	public static final String ATT_MESSAGES = "contenu";
	public static final String VUE          = "/WEB-INF/GetAffectationMaster.jsp";
	private static final long serialVersionUID = 1L;

	@Inject
	private MasterDAO masterDAO;

	@Inject
	CoursDAO cours;

	@Inject
	MasterDAO master;
	
	@Inject
	VerificationCourseInBDD check_course;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAffectationMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	  @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();

	    List<Master> listMaster = new ArrayList<>();
	    listMaster = masterDAO.listeDesMasters();

	    session.setAttribute("listMaster", listMaster);

	    RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher(VUE);
	    dispatch.forward(request, response);

	  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}
}
