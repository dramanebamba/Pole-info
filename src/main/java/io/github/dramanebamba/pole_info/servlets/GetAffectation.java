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

import main.java.io.github.dramanebamba.pole_info.model.Affectation;
import main.java.io.github.dramanebamba.pole_info.model.Contenu;
import main.java.io.github.dramanebamba.pole_info.model.Personne;
import main.java.io.github.dramanebamba.pole_info.service.AffectationDAO;
import main.java.io.github.dramanebamba.pole_info.service.ContenuDAO;
import main.java.io.github.dramanebamba.pole_info.service.PersonneDAO;

@WebServlet("/GetAffectation")
public class GetAffectation extends HttpServlet {
  public static final String VUE = "/WEB-INF/GetAffectation.jsp";
  private static final long serialVersionUID = 1L;

  @Inject
  private PersonneDAO personneDAO;
  
  @Inject
  private ContenuDAO contenuDAO;
  
  @Inject
  private AffectationDAO affectationDAO;

  public GetAffectation() {
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
	HttpSession session = request.getSession();
	int id_master = Integer.parseInt(request.getParameter("id_master")); 
	String id_m = request.getParameter("id_master");
	String nom_master = request.getParameter("nom_master");
	int id_contenu = Integer.parseInt(request.getParameter("id_contenu"));
	String id_c = request.getParameter("id_contenu");
    System.out.println(id_master);
    System.out.println(nom_master);
    System.out.println(id_contenu);
    System.out.println("MASTER : " +id_master);
    System.out.println("CONTENU : " +id_contenu);
    
    Contenu c = contenuDAO.getContenu(id_contenu);
    List<Affectation> numAffectation = affectationDAO.countAffectation(id_master, id_contenu, 2017);
    List<Integer> studentIds = affectationDAO.getStudentByCourses(id_master, id_contenu);
    List<Personne> affectedStudents = personneDAO.getStudentByIds(studentIds);
    
    System.out.println("NOMBRE AFFECTATION : "+numAffectation);
    System.out.println("LIST ETUDIANT :" + affectedStudents);
    
    request.setAttribute("id_master", id_m);
    request.setAttribute("nom_master", nom_master);
    session.setAttribute("nom_contenu", c);
    request.setAttribute("id_contenu", id_c);
    session.setAttribute("numAffectation", numAffectation);
    session.setAttribute("affectedStudents",affectedStudents);
    
    
    RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher(VUE);
    dispatch.forward(request, response);
  }

}
