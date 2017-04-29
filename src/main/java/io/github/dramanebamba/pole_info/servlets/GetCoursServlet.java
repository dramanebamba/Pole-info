package main.java.io.github.dramanebamba.pole_info.servlets;

import java.util.List;
import java.io.IOException;
import java.util.Vector;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.io.github.dramanebamba.pole_info.model.Cours;
import main.java.io.github.dramanebamba.pole_info.model.Item;
import main.java.io.github.dramanebamba.pole_info.service.CoursService;
import main.java.io.github.dramanebamba.pole_info.utils.ServletHelper;

@WebServlet("/GetCoursServlet")
public class GetCoursServlet extends HttpServlet {
	@PersistenceContext
	private EntityManager em;
	@Inject
	private CoursService cours;
	@Inject
	private ServletHelper servletHelper;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		assert (!em.isJoinedToTransaction());

		@SuppressWarnings("resource")
		final ServletOutputStream out = servletHelper.configureAndGetOutputStream(resp);
		out.println("Liste des cours");


		final List<Cours> allItems = cours.getAll();
		assert (!em.isJoinedToTransaction());
		for (Cours item : allItems) {
			assert (!em.contains(item));
		}

		for (Cours item : allItems) {
			out.println(item.getId_master() + " " + item.getId_contenu() + " " + item.getId_enseignant() + " " + item.getObligatoire() + " " + item.getObligatoire() + " " + item.getPeriode() + " " + item.getNotes());
		}
	}

}
