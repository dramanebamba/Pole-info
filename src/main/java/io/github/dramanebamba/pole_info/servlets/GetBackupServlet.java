package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pole_info.Backup;
import pole_info.BackupDAO;

/**
 * Servlet implementation class GetBackupServlet
 */
@WebServlet("/GetBackupServlet")
public class GetBackupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	BackupDAO backupDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBackupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		List<Backup> backList = new ArrayList<>();
		backList = backupDAO.listeDesBackups();
		
		session.setAttribute("listBackup", backList);
		
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/ListeBackup.jsp");
		dispatch.forward(request, response);
		
		/*
		Iterator<Backup> it = backList.iterator();
		
		while(it.hasNext()){
			Backup temp = it.next();
			response.getWriter().println(temp.getIdBackup() + " "+ temp.getDate() + " " + temp.getLabel());
		}
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
