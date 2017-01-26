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
@WebServlet("/creationEtudiant")
public class CreationEtudiant extends HttpServlet 
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	@Inject
	private VerificationBDD verification_BDD;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreationEtudiant() 
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/creationEtudiant.html");
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
		String nom = (String) request.getParameter("last_name");
		String prenom = (String) request.getParameter("first_name");
		String mail = (String) request.getParameter("mail");
		String parcours = (String) request.getParameter("parcours");
		String connected = (String) session.getAttribute("connected");
		
		request.setAttribute("connected", connected);

		System.out.println("Operation : " + operation);

		if(operation.equals("createStudent"))
		{
			if(verification_BDD.test(mail))
			{
				Personne.BDD.add(new Personne(nom, prenom, mail, parcours, "", "", "", 0, 0, "Et"));
				System.out.println("Nouvel étudiant créé :" + nom + " " + prenom + " / " + mail + " / " + parcours);
				System.out.println(Personne.BDD.size() + "personne en BDD");
				RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp");
				dispatch.forward(request, response);
			}
			else
				response.getWriter().println("KO");
		}
	}
}
