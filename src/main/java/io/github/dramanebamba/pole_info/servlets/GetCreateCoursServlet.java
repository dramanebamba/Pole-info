package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.io.github.dramanebamba.pole_info.model.Contenu;
import main.java.io.github.dramanebamba.pole_info.model.Master;
import main.java.io.github.dramanebamba.pole_info.model.Personne;
import main.java.io.github.dramanebamba.pole_info.service.ContenuDAO;
import main.java.io.github.dramanebamba.pole_info.service.MasterDAO;
import main.java.io.github.dramanebamba.pole_info.service.PersonneDAO;

/**
 * Servlet implementation class GetCreateCoursServlet
 */
@WebServlet("/GetCreateCours")
public class GetCreateCoursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	private MasterDAO masterDao;
	
	@Inject
	private ContenuDAO contenuDao;
	
	@Inject
	private PersonneDAO personneDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCreateCoursServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Session
		HttpSession session = request.getSession();
		
		List<Master> listMaster = masterDao.listeDesMasters();
		List<Contenu> listContenu = contenuDao.listeDesContenus();
		List<Personne> listTeacher = personneDao.listTeacher();
		
		session.setAttribute("listMaster", listMaster);
		session.setAttribute("listContenu", listContenu);
		session.setAttribute("listTeacher", listTeacher);
		
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/PostCours.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
