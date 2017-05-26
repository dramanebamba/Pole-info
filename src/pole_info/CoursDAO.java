package pole_info;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.gson.Gson;

import main.java.io.github.dramanebamba.pole_info.model.Cours;
import pole_info.Personne;

@RequestScoped
public class CoursDAO
{
	@Inject
	PersonneDAO personne;
	
	@Inject
	ContenuDAO contenu;
	
	private static final String QUERY_GET_TEACHERS = "SELECT u.id_enseignant FROM Cours u WHERE u.id_master = :id";
	private static final String QUERY_GET_CONTENT = "SELECT u.id_contenu FROM Cours u WHERE u.id_master = :id_m AND u.id_enseignant = :id_e";
	private static final String PARAM_ID = "id";
	private static final String PARAM_M = "id_m";
	private static final String PARAM_E = "id_e";
	
	public void getListePersonnes(int id_master, Gson json, FileWriter writer)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		List<Integer> li = em.createQuery(QUERY_GET_TEACHERS,Integer.class).setParameter(PARAM_ID, id_master).getResultList();
		for(Integer i: suppressionDoublons(li))
		{
			try 
			{
				json.toJson(personne.getPersonne(i), writer);	// ecriture dans le fichier de la personne
				
				List<Integer> l_content = em.createQuery(QUERY_GET_CONTENT,Integer.class)
						.setParameter(PARAM_M, id_master)
						.setParameter(PARAM_E, i)
						.getResultList();
				
				for(Integer id_content : l_content)
					json.toJson(contenu.getContenu(id_content), writer);	// ecriture dans le fichier de la personne
				
				writer.write("\n");
			}
			catch (IOException e) 
			{
				throw new IllegalStateException(e);
			}
		}
		em.close();
	}
	
	public List<Integer> suppressionDoublons(List<Integer> liste)
	{
		List<Integer> new_liste = new ArrayList<>();		
		for(Integer i : liste)
		{
			if(!new_liste.contains(i))
				new_liste.add(i);
		}
		return new_liste;
	}
}
