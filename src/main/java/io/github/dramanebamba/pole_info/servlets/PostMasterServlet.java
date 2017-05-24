package main.java.io.github.dramanebamba.pole_info.servlets;

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

import main.java.io.github.dramanebamba.pole_info.model.Master;
import main.java.io.github.dramanebamba.pole_info.service.MasterService;

@WebServlet("/PostMasterServlet")
public class PostMasterServlet extends HttpServlet {
  public static final String VUE = "/WEB-INF/PostMaster.jsp";
  private static final long serialVersionUID = 1L;

  @Inject
  private MasterService Master;

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

    String nom = request.getParameter("nom");
    String description = request.getParameter("description");


    Master master = new Master(nom, description);
    System.out.println(master);
    Master.persist(master);
    RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/PostMaster.jsp");
    dispatch.forward(request, response);

  }

}
