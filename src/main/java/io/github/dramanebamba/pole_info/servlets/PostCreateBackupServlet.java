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

import main.java.io.github.dramanebamba.pole_info.model.Backup;
import main.java.io.github.dramanebamba.pole_info.service.BackupDAO;

/**
 * Servlet implementation class BackupBDD
 */
@WebServlet("/PostCreateBackupServlet")
public class PostCreateBackupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	BackupDAO backDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostCreateBackupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String idBackuper = session.getAttribute("id").toString();

		DateFormat dateFormatName = new SimpleDateFormat("ddMMyy_HHmmss");
		Date dateName = new Date();
		String backupName = "poleinfoBD" + dateFormatName.format(dateName).toString();

		DateFormat dateFormatBackup = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dateBackup = new Date();
		String dteBack = dateFormatBackup.format(dateBackup).toString();

		String label = request.getParameter("etiq");

		System.out.println("label avant if : " + label);
		if(label.equals("")){
			label = "NO DESCRIPTION";
		}

		System.out.println("idBackuper : " + idBackuper);
		System.out.println("backupName : " + backupName);
		System.out.println("dteBack : " + dteBack);
		System.out.println("label : " + label);

		Backup monBackup = new Backup(backupName,idBackuper,label,dteBack);
		System.out.println(monBackup);

		String filename = backupName + ".sql";

		//String relativePath = getServletContext().getRealPath("");
		//System.out.println("relativePath 1st = " + relativePath);

		Process p, p1 = null;
		String expr = new StringBuilder()
				.append("/usr/local/mysql/bin/mysqldump").append(' ')
				.append("-u").append("root").append(' ')
				.append("-p").append("root").append(' ')
				.append("--add-drop-database").append(' ')
				.append("-B").append(' ')
				.append("poleinfobd").append(' ')
				.append("-r").append(' ')
				.append(filename)
				.toString();

		String exprCP = new StringBuilder()
				.append("/bin/cp").append(' ')
				.append(filename).append(' ')
				.append("../eclipseApps/pole_info/")
				.toString();
		try {
			backDAO.creerBackup(monBackup);
			p = Runtime.getRuntime().exec(expr);
			int processComplete = p.waitFor();
			if(processComplete == 0){
				System.out.println("success");
				p1 = Runtime.getRuntime().exec(exprCP);
				int p1Complete = p1.waitFor();
				if(p1Complete == 0){
					System.out.println("CP OK");
				}
				else{
					System.out.println("CP KO");
				}
			} else {
				System.out.println("failure backup");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//response.getWriter().println("<div class=\"alert alert-success\" role=\"alert\"><strong>Success !</strong> Backup créé !</div>");
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp");
		dispatch.forward(request, response);
		
	}

}
