package io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.dramanebamba.pole_info.model.Contenu;
import io.github.dramanebamba.pole_info.service.ContenuService;

@WebServlet("/PostContenuServlet")
public class PostContenuServlet extends HttpServlet {
	public static final String VUE = "/WEB-INF/PostContenu.jsp";
	private static final long serialVersionUID = 1L;

	@Inject
	private Contenu Cours;
	
	@PersistenceContext
	private EntityManager em;


	public PostContenuServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher(VUE);
		dispatch.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
