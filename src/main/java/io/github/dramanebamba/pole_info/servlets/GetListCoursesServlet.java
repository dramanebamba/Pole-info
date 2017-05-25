package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.File;
import java.io.FileWriter;
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

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import main.java.io.github.dramanebamba.pole_info.service.*;
import pole_info.Backup;
import pole_info.ContenuDAO;
import pole_info.CoursDAO;
import pole_info.MasterDAO;
import pole_info.Personne;
import pole_info.PersonneDAO;
import main.java.io.github.dramanebamba.pole_info.model.*;

/**
 * Servlet implementation class Identification
 */
@WebServlet("/listCourses")
public class GetListCoursesServlet extends HttpServlet
{
	@Inject
	ContenuDAO contenu;
	
	@Inject
	PersonneDAO personne;
	
	@Inject
	MasterDAO master;

	public GetListCoursesServlet()
	{
		/**
		 * @see HttpServlet#HttpServlet()
		 */
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String operation = request.getParameter("operation");

		if(operation.equals("getlistCourses"))
		{
			System.out.println("Je vais récupérer la liste des cours !!");
			System.out.println("Récupération liste des cours");
			List<Contenu> listCourses = new ArrayList<>();
			listCourses = contenu.getAllCourses();
			exportJSON(listCourses);
		}
		
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp");
		dispatch.forward(request, response);
	}

	public void exportJSON(List<Contenu> liste)
	{
		Gson json = new Gson();
		FileWriter writer;
		String json_string;

		try
		{
			File fil = new File("/Users/theogelly/Documents/test.json");
			fil.createNewFile();
			writer = new FileWriter(fil); 

			
			json_string = json.toJson(liste);

			System.out.println("Je veux export " + json_string + " dans le fichier : " + fil);
			json.toJson(json_string, writer);
			writer.flush();
			writer.close();
		} 
		catch (JsonIOException e) 
		{
			throw new IllegalStateException(e);
		} 
		catch (IOException e) 
		{
			throw new IllegalStateException(e);
		}
	}
}
