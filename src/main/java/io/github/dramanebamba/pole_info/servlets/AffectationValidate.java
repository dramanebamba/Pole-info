package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.io.github.dramanebamba.pole_info.model.Affectation;
import main.java.io.github.dramanebamba.pole_info.service.AffectationDAO;

@WebServlet("/AffectationValidate")
public class AffectationValidate extends HttpServlet {
  public static final String VUE = "/WEB-INF/AffectationValidate.jsp";
  private static final long serialVersionUID = 1L;

  @Inject
  private AffectationDAO affectationDAO;

  public AffectationValidate() {
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
	//HttpSession session = request.getSession();
	int id_master = Integer.parseInt(request.getParameter("id_master"));
	int id_contenu = Integer.parseInt(request.getParameter("id_contenu"));
	int id_personne = Integer.parseInt(request.getParameter("id_personne"));
	int annee = Integer.parseInt(request.getParameter("annee"));

    System.out.println("MASTER : " +id_master);
    System.out.println("CONTENU : " +id_contenu);
    System.out.println("PERSONNE : " +id_personne);
    System.out.println("ANNEE : " +annee);
    
    affectationDAO.setAffectation(new Affectation(id_master, id_contenu, id_personne, annee, annee));


    RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher(VUE);
    dispatch.forward(request, response);
  }

}
