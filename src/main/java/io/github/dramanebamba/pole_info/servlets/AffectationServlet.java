package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
import javax.servlet.http.HttpSession;

import main.java.io.github.dramanebamba.pole_info.model.Contenu;
import pole_info.ContenuDAO;
import pole_info.CoursDAO;

@WebServlet("/AffectationServlet")
public class AffectationServlet extends HttpServlet {
  public static final String VUE = "/WEB-INF/Affectation.jsp";
  private static final long serialVersionUID = 1L;

  @Inject
  private CoursDAO coursDAO;

  public AffectationServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();

    List<Contenu> listCours = new ArrayList<>();
    List<Contenu> idCours = new ArrayList<>();
    // Récupération des cours
    listCours = coursDAO.getListCours();
    idCours = coursDAO.getIdCours();

    session.setAttribute("listCours", listCours);
    session.setAttribute("idCours", idCours);

    RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher(VUE);
    dispatch.forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int idContenu = Integer.parseInt(request.getParameter("id"));
    System.out.println(idContenu);
  }

}
