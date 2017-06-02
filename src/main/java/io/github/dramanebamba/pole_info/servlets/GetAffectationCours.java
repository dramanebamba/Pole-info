package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.io.github.dramanebamba.pole_info.model.Master;
import main.java.io.github.dramanebamba.pole_info.service.CoursDAO;
import main.java.io.github.dramanebamba.pole_info.service.MasterDAO;

@WebServlet("/GetAffectationCours")
public class GetAffectationCours extends HttpServlet {
  public static final String VUE = "/WEB-INF/GetAffectationCours.jsp";
  private static final long serialVersionUID = 1L;

  @Inject
  private CoursDAO coursDAO;

  @Inject
  private MasterDAO masterDAO;

  public GetAffectationCours() {
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
    System.out.println(id_master);
    System.out.println(id_m);

    List<Master> nomMaster = new ArrayList<>();
    nomMaster = masterDAO.getMasterById(id_master);
    session.setAttribute("nomMaster", nomMaster);

    List<Object[]> listCours = new ArrayList<>();
    listCours = coursDAO.getCoursByMaster(id_master);
    session.setAttribute("listCours", listCours);
    request.setAttribute("id_master", id_m);
    RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher(VUE);
    dispatch.forward(request, response);
  }

}
