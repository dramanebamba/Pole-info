package pole_info;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Identification
 */
@WebServlet("/identification")
public class Identification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private VerificationLogin verification_login;	// CDI servant à verifier que les identifiants sont en BDD

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Identification() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/identification.html");
		dispatch.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String operation = request.getParameter("operation");
		String login = (String) request.getParameter("login");
		String pw = (String) request.getParameter("password");

		System.out.println("Operation : " + operation);

		// Test en BDD par le CDI
		if(operation.equals("confAuth") && verification_login.test(login,pw)){
			request.setAttribute("connected", "true");
			RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp");
			dispatch.forward(request, response);
			
			System.out.println(session.getAttribute("connect"));
		}
		if(operation.equals("logout")){
			request.setAttribute("connected", "false");
			RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/index.html");
			dispatch.forward(request, response);
			System.out.println(session.getAttribute("connect"));
		}
	}
}
