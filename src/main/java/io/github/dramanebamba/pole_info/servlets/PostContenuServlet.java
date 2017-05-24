package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;
import java.math.BigDecimal;

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

import main.java.io.github.dramanebamba.pole_info.model.Contenu;
import main.java.io.github.dramanebamba.pole_info.service.ContenuService;

@WebServlet("/PostContenuServlet")
public class PostContenuServlet extends HttpServlet {
  public static final String VUE = "/WEB-INF/PostContenu.jsp";
  private static final long serialVersionUID = 1L;

  @Inject
  private ContenuService Contenu;

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

    // int id = Integer.parseInt(request.getParameter("id"));
    String apprentissage = request.getParameter("apprentissage");
    String biblio = request.getParameter("biblio");
    String contents = request.getParameter("contents");
    String description = request.getParameter("description");
    int ects = Integer.parseInt(request.getParameter("ects"));
    String nom = request.getParameter("nom");
    String objectives = request.getParameter("objectives");
    int volumeHoraire = Integer.parseInt(request.getParameter("volumeHoraire"));
    int volumeProjet = Integer.parseInt(request.getParameter("volumeProjet"));


    Contenu contenu = new Contenu(apprentissage, biblio, contents, description, ects, nom, objectives, volumeHoraire, volumeProjet);
    System.out.println(contenu);
    Contenu.persist(contenu);
    RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/PostContenu.jsp");
    dispatch.forward(request, response);

  }

}
