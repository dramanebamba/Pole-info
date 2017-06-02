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
	AffectationDAO affectation;

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
		if(request.getParameter("operation").equals("getlistCourses"))	
			exportJSONListCourses(contenu.getAllCourses()); // Recuperation de la liste des cours
		
		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp");
		dispatch.forward(request, response);
	}

	// Methode servant a lister les cours avec les etudiants qui y sont relie, pour ensuite exporter cette liste en fichier JSON
	@SuppressWarnings("resource")
	public void exportJSONListCourses(List<Contenu> liste)
	{
		System.out.println("Récupération liste des cours");
		Gson json = new Gson();
		FileWriter writer;	// Objet servant a ecrire dans le fichier voulu
		
		try
		{
			File fil = new File("../eclipseApps/pole_info/Export_JSON_Courses.json"); // ecriture en brut [provisoire]
			fil.createNewFile();	// Creation nouveau fichier
			writer = new FileWriter(fil); // Liaison entre l'objet et le fichier a remplir
			
			// Parcours de la liste des contenus recue en parametre
			for(Contenu c: liste)
			{
				json.toJson(c, writer);	// On ecrit d'abord le contenu, ensuite les etudiants raccroches
				
				// Apres recuperation des id des etudiants rattaches a ce contenu, recuperation des objets personne lies
				for(Integer i : affectation.getListePersonnes(c.getId()))
					json.toJson(personne.getPersonne(i), writer);	// ecriture dans le fichier de la personne
				
				writer.write("\n");	// Saut de ligne pour passer au prochain contenu
			}
			// Fermeture de l'ecriture sur le ficher JSON
			writer.flush();
			writer.close();
			System.out.println("Exportation JSON sauvegardée dans le fichier ../eclipseApps/pole_info/Export_JSON_Courses.json");
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
