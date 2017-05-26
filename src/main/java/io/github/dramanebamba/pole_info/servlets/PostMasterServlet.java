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

import main.java.io.github.dramanebamba.pole_info.model.Master;
import pole_info.MasterDAO;

@WebServlet("/PostMasterServlet")
public class PostMasterServlet extends HttpServlet {
  public static final String VUE = "/WEB-INF/PostMaster.jsp";
  private static final long serialVersionUID = 1L;

  @Inject
  private MasterDAO masterDAO;

  public PostMasterServlet() {
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

    String description = request.getParameter("description");
    String nom = request.getParameter("nom");

    masterDAO.creerMaster(new Master(nom, description));
    System.out.println("Nouveau master créé : " + nom +" / " + description);
    System.out.println(nom + " ajouté en base de données !");
    RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/PostMaster.jsp");
    dispatch.forward(request, response);

  }

}
