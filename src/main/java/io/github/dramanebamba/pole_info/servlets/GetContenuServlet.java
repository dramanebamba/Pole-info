package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import main.java.io.github.dramanebamba.pole_info.service.*;
import pole_info.ContenuDAO;
import pole_info.CoursDAO;
import pole_info.MasterDAO;
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
 * Servlet implementation class Contenus
 */
@WebServlet("/GetContenuServlet")
public class GetContenuServlet extends HttpServlet {
	public static final String ATT_MESSAGES = "contenu";
	public static final String VUE          = "/WEB-INF/GetContenu.jsp";
	private static final long serialVersionUID = 1L;

	@Inject
	private ContenuDAO contenuDAO;

	@Inject
	CoursDAO cours;

	@Inject
	MasterDAO master;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetContenuServlet() {
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

		HashMap<Contenu,List<String>> listCours = new HashMap<>(); // HashMap liant le contenu avec les masters rattachés
		List<Contenu> listeDesContenus = contenuDAO.listeDesContenus();	// Récupération de la liste des contenus en BDD

		// Pour chaque contenu, on recupère les informations a afficher
		for(Contenu c: listeDesContenus)
		{
			List<Integer> listeIdMaster = cours.getListContenus(c.getId());	// Liste des Id des master rattachés à un contenu
			List<String> listNameMasters = new ArrayList<>(); // Liste des noms des masters rattachés à un contenu

			// Récupération du nom du master avec son id
			for(Integer i: listeIdMaster)	listNameMasters.add(master.getMaster(i));
			listCours.put(c, listNameMasters);	// Ajout du couple dans la hashmap
		}

		session.setAttribute("listNameMasters", listCours);
		session.setAttribute("listContenu", listeDesContenus);

		String operation = request.getParameter("operation");
		System.out.println(operation);

		if(operation != null && operation.equals("remove"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			contenuDAO.supprimerContenu(id);
		}
		
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
