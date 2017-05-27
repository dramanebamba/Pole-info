package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String operation = request.getParameter("operation");
		String id = request.getParameter("id");

		int idBackup = Integer.parseInt(id);

		System.out.println("operation : " + operation);
		System.out.println("idBackup : " + idBackup);

		Process pRemove = null;
		Process pRestore = null;
		Process pSave = null;

		String filename = null;

		DateFormat dateFormatName = new SimpleDateFormat("ddMMyy_HHmmss");
		Date dateName = new Date();
		DateFormat dateFormatBackup = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dateBackup = new Date();
		
		String dteBack = dateFormatBackup.format(dateBackup).toString();
		String filenameSave = "poleinfoBD" + dateFormatName.format(dateName).toString();
		String filenameSaveExt = "poleinfoBD" + dateFormatName.format(dateName).toString() + ".sql";

		filename = backupDao.getBackupName(idBackup);
		
		String exprRemove = new StringBuilder()
				.append("/bin/rm -f").append(' ')
				.append(filename).append(".sql")
				.toString();

		String exprSave = new StringBuilder()
				.append("/usr/local/mysql/bin/mysqldump").append(' ')
				.append("-u").append("root").append(' ')
				.append("-p").append("root").append(' ')
				.append("poleinfobd").append(' ')
				.append("-r").append(' ')
				.append(filenameSaveExt)
				.toString();

		String exprRestore = new StringBuilder()
				.append("/usr/local/mysql/bin/mysql").append(' ')
				.append("-u").append("root").append(' ')
				.append("-p").append("root").append(' ')
				.append("poleinfobd").append(' ')
				.append("<").append(' ')
				.append(filename).append(".sql")
				.toString();
		
		String[] executeCmd = new String[]{"/usr/local/mysql/bin/mysql", "poleinfobd", "-u" + "root", "-p" + "root", "-e", " source " + filename + ".sql"};

		
		System.out.println(exprRestore);

		
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
		}

		if(operation.equals("restore")){
			try {
				Backup backupSave = new Backup(filenameSave,"0","Backup Pré-restore du " + dateFormatName.format(dateName).toString(), dteBack);
				backupDao.creerBackup(backupSave);
				pSave = Runtime.getRuntime().exec(exprSave);
				int pSaveComplete = pSave.waitFor();
				if(pSaveComplete == 0){
					System.out.println("Backup pré-restore : OK");
					//pRestore = Runtime.getRuntime().exec(exprRestore);
					pRestore = Runtime.getRuntime().exec(executeCmd);
					int pRestoreComplete = pRestore.waitFor();
					if(pRestoreComplete == 0){
						System.out.println("Backup restored : OK");
						backupDao.creerBackup(backupSave);
					}
					else{
						System.out.println("Backup restored : KO");
					}
				}
				else {
					System.out.println("Backup pré-restore : KO");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		List<Backup> backList = new ArrayList<>();
		backList = backupDao.listeDesBackups();

		session.setAttribute("listBackup", backList);

		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/ListeBackup.jsp");
		dispatch.forward(request, response);
		//COMMIT NON FORWARD REJECT
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
