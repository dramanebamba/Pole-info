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
	private static final String QUERY_GET_MASTER = "SELECT u.id_master FROM Cours u WHERE u.id_contenu = :id_c";
	private static final String QUERY_GET_OBLIGATOIRE = "SELECT u.obligatoire FROM Cours u WHERE u.id_master = :id_m AND u.id_contenu = :id_c";
	private static final String PARAM_ID = "id";
	private static final String PARAM_M = "id_m";
	private static final String PARAM_E = "id_e";
	private static final String PARAM_C = "id_c";
	
	public List<Integer> getListContenus(int id_c)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		List<Integer> li = em.createQuery(QUERY_GET_MASTER,Integer.class).setParameter(PARAM_C, id_c).getResultList();
		em.close();
		
		return li;
	}
	
	public String getObligatoire(int id_c, int id_m)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		String obli = em.createQuery(QUERY_GET_OBLIGATOIRE,String.class).setParameter(PARAM_C, id_c).setParameter(PARAM_M, id_m).getSingleResult();
		em.close();
		
		return obli;
	}
	
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
	// private static final String QUERY_GET = "SELECT u FROM Cours u";
	private static final String QUERY_GET_COURS = "SELECT c.id, c.nom, u.id_master FROM Cours u, Contenu c WHERE u.id_contenu = c.id AND u.obligatoire = 'N'";
	private static final String QUERY_GET_COURS_BY_MASTER = "SELECT contenu.id, contenu.nom, cours.id_master FROM Contenu contenu, Cours cours WHERE cours.id_master = :id_master AND cours.id_contenu = contenu.id AND cours.obligatoire = 'N'";
	public List<Object[]> getListCours(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		
		List<Object[]> nomCours = new ArrayList<>();
		System.out.println("récupération du résultat de la requête");
		nomCours = em.createQuery(QUERY_GET_COURS,Object[].class).getResultList();
		System.out.println("Requête exécutée avec succès");
		System.out.println(nomCours);
		int i = 0;
		for (i=0;i<nomCours.size(); i++)
		{
			System.out.println(nomCours.get(i)[1]);
		}
		return nomCours;
	}
	
	public List<Object[]> getCoursByMaster(int id_master){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		
		List<Object[]> coursByMaster  = em.createQuery(QUERY_GET_COURS_BY_MASTER,Object[].class).setParameter("id_master", id_master).getResultList();
		if(coursByMaster.isEmpty()){
			System.out.println("Pas de cours facultatifs pour ce master");
			System.out.println("COURSDAO : "+coursByMaster);
		}
		else{
			System.out.println("COURSDAO : "+coursByMaster);
		}
		return coursByMaster;
	}
}
