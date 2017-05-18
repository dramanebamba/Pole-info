package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BackupBDD
 */
@WebServlet("/BackupBDD")
public class BackupBDDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BackupBDDServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("Backup BDD");
		Process p,pfirst = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
			Date date = new Date();
			Runtime runtime = Runtime.getRuntime();
			//String dumpCmd = "sh -c '/usr/local/bin/mysql/mysqldump -uroot -proot --add-drop-database -B poleInfoBD -r " + "/Users/Stanley/Desktop/" + "poleInfoBD" + dateFormat.format(date) +".sql'";
			String dumpCmd = "/usr/local/bin/mysql/mysqldump -uroot -proot --add-drop-database -B poleInfoBD -r " + "/Users/Stanley/Desktop/" + "poleInfoBD" + dateFormat.format(date) +".sql";
			p = runtime.exec(dumpCmd);
			int processComplete = p.waitFor();

			if (processComplete == 0) {

				System.out.println("Backup created successfully!");

			} else {
				System.out.println("Could not create the backup");
			}


		} catch (Exception e) {
			e.printStackTrace();
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
