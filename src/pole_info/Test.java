package pole_info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/monurl")
public class Test extends HttpServlet {
	/*public void doGet( HttpServletRequest request, HttpServletResponse response )	throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( "/WEB-INF/test.jsp" ).forward( request, response );
	}*/
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException  {
		response.getWriter().println("Hello man 3SD");
	}
}