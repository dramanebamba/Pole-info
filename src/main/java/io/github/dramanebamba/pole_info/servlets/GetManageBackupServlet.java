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

import pole_info.Backup;
import pole_info.BackupDAO;

/**
 * Servlet implementation class GetManageBackupServlet
 */
@WebServlet("/GetManageBackupServlet")
public class GetManageBackupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	BackupDAO backupDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetManageBackupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String operation = request.getParameter("operation");
		String id = request.getParameter("id");
		
		int idBackup = Integer.parseInt(id);
		
		System.out.println("operation : " + operation);
		System.out.println("idBackup : " + idBackup);
		
		Process pRemove = null;
		Process pRestore = null;
		
		String filename = null;
		
		String exprRemove = new StringBuilder()
				.append("/bin/rm -f").append(' ')
				.append(filename).append(".sql")
				.toString();
		
		String exprRestore = new StringBuilder()
				.append("/usr/local/mysql/bin/mysql").append(' ')
				.append("-u").append("root").append(' ')
			    .append("-p").append("root").append(' ')
			    .append("poleinfobd").append(' ')
			    .append("<").append(' ')
			    .append(filename).append(".sql")
				.toString();
		
		filename = backupDao.getBackupName(idBackup);
		
		if(operation.equals("remove")){
			try {
				pRemove = Runtime.getRuntime().exec(exprRemove);
				int pRemoveComplete = pRemove.waitFor();
				if(pRemoveComplete == 0){
					backupDao.removeBackup(idBackup);
					System.out.println("Success ! File "+filename+".sql has been removed");
				} else {
					System.out.println("Failure ! File "+filename+".sql hasn't been removed");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp");
			//dispatch.forward(request, response);
			
			List<Backup> backList = new ArrayList<Backup>();
			backList = backupDao.listeDesBackups();
			
			session.setAttribute("listBackup", backList);
			
			RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/ListeBackup.jsp");
			dispatch.forward(request, response);
		}

		if(operation.equals("restore")){

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
