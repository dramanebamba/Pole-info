package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

import main.java.io.github.dramanebamba.pole_info.service.*;
import main.java.io.github.dramanebamba.pole_info.model.*;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Preferences
 */
@WebServlet("/GetPreferenceServlet")
public class GetPreferenceServlet extends HttpServlet {
	public static final String ATT_MESSAGES = "preference";
	public static final String VUE          = "/WEB-INF/GetPreference.jsp";
	private static final long serialVersionUID = 1L;
	@Inject
	private PreferenceService listePreference;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetPreferenceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Vector<Preference> preference = listePreference.getPreference();

		request.setAttribute( ATT_MESSAGES, preference );
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
