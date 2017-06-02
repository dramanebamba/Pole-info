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

import main.java.io.github.dramanebamba.pole_info.model.Affectation;
import main.java.io.github.dramanebamba.pole_info.model.Contenu;
import main.java.io.github.dramanebamba.pole_info.model.Personne;
import main.java.io.github.dramanebamba.pole_info.service.AffectationDAO;
import main.java.io.github.dramanebamba.pole_info.service.ContenuDAO;
import main.java.io.github.dramanebamba.pole_info.service.CoursDAO;
import main.java.io.github.dramanebamba.pole_info.service.PersonneDAO;

@WebServlet("/AffectationStudent")
public class AffectationStudent extends HttpServlet {
  public static final String VUE = "/WEB-INF/AffectationStudent.jsp";
  private static final long serialVersionUID = 1L;

  @Inject
  private PersonneDAO personneDAO;
  
  @Inject
  private ContenuDAO contenuDAO;
  
  @Inject
  private AffectationDAO affectationDAO;

  public AffectationStudent() {
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
    List<Personne> listStudent = personneDAO.getMasterById(id_master);
    List<Affectation> numAffectation = affectationDAO.countAffectation(id_master, id_contenu, 2017);
    
    System.out.println("NOMBRE AFFECTATION : "+numAffectation);
    
    request.setAttribute("id_master", id_m);
    request.setAttribute("nom_master", nom_master);
    request.setAttribute("id_contenu", id_c);
    session.setAttribute("nom_contenu", c);
    session.setAttribute("listStudent", listStudent);
    session.setAttribute("numAffectation", numAffectation);
    
    if(request.getParameter("id_personne") != null){
    	int id_personne = Integer.parseInt(request.getParameter("id_personne"));
    	int annee = Integer.parseInt(request.getParameter("annee"));
        System.out.println("PERSONNE : " +id_personne);
        System.out.println("ANNEE : " +annee);
        affectationDAO.setAffectation(new Affectation(id_master, id_contenu, id_personne, annee, annee));

    }
    
    RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher(VUE);
    dispatch.forward(request, response);
  }

}
