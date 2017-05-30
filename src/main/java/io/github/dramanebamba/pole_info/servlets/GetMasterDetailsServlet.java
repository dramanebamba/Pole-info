package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import main.java.io.github.dramanebamba.pole_info.service.*;
import pole_info.MasterDAO;
import pole_info.PersonneDAO;
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
 * Servlet implementation class Masters
 */
@WebServlet("/GetMasterDetailsServlet")
public class GetMasterDetailsServlet extends HttpServlet {
	public static final String ATT_MESSAGES = "masterdetails";
	public static final String VUE          = "/WEB-INF/GetMasterDetails.jsp";
	private static final long serialVersionUID = 1L;
	@Inject
	//private MasterDAO masterDAO;
	private PersonneDAO personneDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetMasterDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		int id = Integer.parseInt(request.getParameter("id"));
		int nb_student= (int) personneDAO.getCountByMasterId(id);
		session.setAttribute("nbStudent", nb_student);
		
		String operation = request.getParameter("operation");
		System.out.println(operation);

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
