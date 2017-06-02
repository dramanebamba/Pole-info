package main.java.io.github.dramanebamba.pole_info.servlets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import main.java.io.github.dramanebamba.pole_info.model.Contenu;
import main.java.io.github.dramanebamba.pole_info.model.Master;
import main.java.io.github.dramanebamba.pole_info.service.AffectationDAO;
import main.java.io.github.dramanebamba.pole_info.service.ContenuDAO;
import main.java.io.github.dramanebamba.pole_info.service.CoursDAO;
import main.java.io.github.dramanebamba.pole_info.service.MasterDAO;
import main.java.io.github.dramanebamba.pole_info.service.PersonneDAO;

/**
 * Servlet implementation class Identification
 */
@WebServlet("/listParcours")
public class GetListParcoursServlet extends HttpServlet
{
	@Inject
	MasterDAO master;

	@Inject
	CoursDAO cours;

	public GetListParcoursServlet()
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
		if(request.getParameter("operation").equals("getlistParcours"))	
			exportJSONListParcours(master.listeDesMasters()); // Recuperation de la liste des cours

		RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp");
		dispatch.forward(request, response);
	}

	// Methode servant a lister les cours avec les etudiants qui y sont relie, pour ensuite exporter cette liste en fichier JSON
	@SuppressWarnings("resource")
	public void exportJSONListParcours(List<Master> liste)
	{
		System.out.println("Récupération liste des cours");
		Gson json = new Gson();
		FileWriter writer;	// Objet servant a ecrire dans le fichier voulu

		try
		{
			File fil = new File("../eclipseApps/pole_info/Export_JSON_Parcours.json"); // ecriture en brut [provisoire]
			fil.createNewFile();	// Creation nouveau fichier
			writer = new FileWriter(fil); // Liaison entre l'objet et le fichier a remplir

			// Parcours de la liste des contenus recue en parametre
			for(Master m: liste)
			{
				json.toJson(m, writer);	// On ecrit d'abord le contenu, ensuite les etudiants raccroches
				writer.write("\n");	// Saut de ligne pour passer au prochain contenu
				
				// Apres recuperation des id des etudiants rattaches a ce contenu, recuperation des objets personne lies
				cours.getListePersonnes(m.getId(), json, writer);
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
