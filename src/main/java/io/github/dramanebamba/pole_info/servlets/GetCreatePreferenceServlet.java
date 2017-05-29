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
import pole_info.ContenuDAO;
import pole_info.MasterDAO;

/**
 * Servlet implementation class GetCreatePreferenceServlet
 */
@WebServlet("/GetCreatePreferenceServlet")
public class GetCreatePreferenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private MasterDAO masterDao;
	@Inject
	private ContenuDAO contenuDao;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCreatePreferenceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		List<Master> listMaster = masterDao.listeDesMasters();
		List<Contenu> listContenu = contenuDao.listeDesContenus();

		session.setAttribute("listMaster", listMaster);
		session.setAttribute("listContenu", listContenu);

		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/PostPreference.jsp");
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
