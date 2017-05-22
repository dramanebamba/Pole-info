package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.persistence.Persistence;
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
 * Servlet implementation class BackupBDD
 */
@WebServlet("/PostBackupServlet")
public class PostBackupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	BackupDAO backDAO;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostBackupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String idBackuper = (String) session.getAttribute("id").toString();
		
		DateFormat dateFormatName = new SimpleDateFormat("ddMMyy_HHmmss");
		Date dateName = new Date();
		String backupName = "poleinfoBD" + dateFormatName.format(dateName).toString();
		
		DateFormat dateFormatBackup = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dateBackup = new Date();
		String dteBack = dateFormatBackup.format(dateBackup).toString();
		
		String label = (String) request.getAttribute("label");
		if(label.equals("")){
			label = "NO DESCRIPTION";
		}
		
		System.out.println("idBackuper : " + idBackuper);
		System.out.println("backupName : " + backupName);
		System.out.println("dteBack : " + dteBack);
		System.out.println("label : " + label);
		
		Backup monBackup = new Backup(backupName,idBackuper,label,dteBack);
		System.out.println(monBackup);
		backDAO.creerBackup(monBackup);
		
		String filename = backupName + ".sql";
		
		Process p = null;
		String expr = new StringBuilder()
				.append("/usr/local/mysql/bin/mysqldump").append(' ')
				.append("-u").append("root").append(' ')
			    .append("-p").append("root").append(' ')
			    .append("poleinfobd").append(' ')
			    .append("-r").append(' ')
			    .append(filename)
			    .toString();
		try {
			p = Runtime.getRuntime().exec(expr);
			int processComplete = p.waitFor();
			if(processComplete == 0){
				System.out.println("success");
			} else {
				System.out.println("restore failure");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp");
		dispatch.forward(request, response);
	}
	
}
