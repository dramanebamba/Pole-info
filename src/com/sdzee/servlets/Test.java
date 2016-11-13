package com.sdzee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/monurl")
public class Test extends HttpServlet {
<<<<<<< Updated upstream
	/*public void doGet( HttpServletRequest request, HttpServletResponse response )	throws ServletException, IOException {
=======
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet( HttpServletRequest request, HttpServletResponse response )	throws ServletException, IOException {
>>>>>>> Stashed changes
		this.getServletContext().getRequestDispatcher( "/WEB-INF/test.jsp" ).forward( request, response );
	}*/
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException  {
		response.getWriter().println("Hello man");
	}
}