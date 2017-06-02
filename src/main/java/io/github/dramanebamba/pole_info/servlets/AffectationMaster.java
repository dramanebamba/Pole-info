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
import main.java.io.github.dramanebamba.pole_info.service.MasterDAO;

@WebServlet("/AffectationMaster")
public class AffectationMaster extends HttpServlet {
  public static final String VUE = "/WEB-INF/AffectationMaster.jsp";
  private static final long serialVersionUID = 1L;

  // @Inject
  // private CoursDAO coursDAO;

  @Inject
  private MasterDAO masterDAO;

  public AffectationMaster() {
    super();
    // TODO Auto-generated constructor stub
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();

    List<Master> listMaster = new ArrayList<>();
    listMaster = masterDAO.listeDesMasters();

    session.setAttribute("listMaster", listMaster);

    RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher(VUE);
    dispatch.forward(request, response);

  }
}
