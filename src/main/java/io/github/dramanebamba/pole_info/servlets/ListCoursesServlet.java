package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import main.java.io.github.dramanebamba.pole_info.service.*;
import pole_info.Backup;
import pole_info.CoursDAO;
import pole_info.Personne;
import pole_info.PersonneDAO;
import main.java.io.github.dramanebamba.pole_info.model.*;

/**
 * Servlet implementation class Identification
 */
@WebServlet("/listCourses")
public class ListCoursesServlet extends HttpServlet
{
	@Inject
	CoursDAO courseDAO;
	
	public ListCoursesServlet()
	{
		/**
		 * @see HttpServlet#HttpServlet()
		 */
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();

		List<Cours> listCourses = new ArrayList<>();
		listCourses = courseDAO.getAllCourses();
		session.setAttribute("listCours", listCourses);
		
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/listCourses.jsp");
		dispatch.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String operation = request.getParameter("operation");
	}
}
