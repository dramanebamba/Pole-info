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
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.google.gson.Gson;

import main.java.io.github.dramanebamba.pole_info.model.Contenu;
import main.java.io.github.dramanebamba.pole_info.model.Cours;
import main.java.io.github.dramanebamba.pole_info.model.Master;
import pole_info.Personne;

@RequestScoped
// @Transactional
public class CoursDAO
{
	@Inject
	PersonneDAO personne;
	
	@Inject
	ContenuDAO contenu;
	
	/*@PersistenceContext(unitName = "pole")
	EntityManager em;*/
	
	private static final String QUERY_GET_TEACHERS = "SELECT u.id_enseignant FROM Cours u WHERE u.id_master = :id";
	private static final String QUERY_GET_ALL_COURSES = "SELECT u FROM Cours u WHERE u.id_contenu = :id_c";
	private static final String QUERY_GET_CONTENT = "SELECT u.id_contenu FROM Cours u WHERE u.id_master = :id_m AND u.id_enseignant = :id_e";
	private static final String QUERY_GET_CONTENT_BIS = "SELECT u FROM Cours u WHERE u.id_master = :id_m AND u.id_contenu = :id_c";
	private static final String QUERY_GET_MASTER = "SELECT u.id_master FROM Cours u WHERE u.id_contenu = :id_c";
	private static final String QUERY_GET_OBLIGATOIRE = "SELECT u.obligatoire FROM Cours u WHERE u.id_master = :id_m AND u.id_contenu = :id_c";
	private static final String QUERY_GET_COURS = "SELECT c.id, c.nom, u.id_master FROM Cours u, Contenu c WHERE u.id_contenu = c.id AND u.obligatoire = 'N'";
	private static final String QUERY_GET_COURS_BY_MASTER = "SELECT contenu.id, contenu.nom, cours.id_master FROM Contenu contenu, Cours cours WHERE cours.id_master = :id_master AND cours.id_contenu = contenu.id AND cours.obligatoire = 'N'";
	
	private static final String PARAM_ID = "id";
	private static final String PARAM_M = "id_m";
	private static final String PARAM_E = "id_e";
	private static final String PARAM_C = "id_c";
	
	public List<Cours> getAllCourses(int id_c)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		List<Cours> liste = em.createQuery(QUERY_GET_ALL_COURSES, Cours.class).setParameter(PARAM_C, id_c).getResultList();
		em.close();
		
		return liste;
	}
	
	public void updateMaster(int id_master, int id_contenu, int new_val)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		System.out.println("Lancement modification du master en Base de données...");
		
		Cours c = em.createQuery(QUERY_GET_CONTENT_BIS, Cours.class)
				.setParameter(PARAM_M, id_master)
				.setParameter(PARAM_C, id_contenu)
				.getSingleResult();
		
		c.setId_master(new_val);
		em.flush();
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Modification du master réalisée en Base de données.");
	}
	
	public void updateObligatoire(int id_master, int id_contenu, String new_val)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		
		System.out.println("Lancement modification de l'attribut obligatoire en Base de données...");
		
		em.getTransaction().begin();
		
		Cours c = em.createQuery(QUERY_GET_CONTENT_BIS, Cours.class)
				.setParameter(PARAM_M, id_master)
				.setParameter(PARAM_C, id_contenu)
				.getSingleResult();
		
		c.setObligatoire(new_val);
		em.merge(c);
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Modification de l'attribut obligatoire réalisée en Base de données.");
	}
	
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
	
	private static final String QUERY_GET_ID_MASTER = "SELECT u.id FROM Master u " + "WHERE u.nom = :master";
	private static final String QUERY_GET_ID_CONTENU = "SELECT u.id FROM Contenu u WHERE u.nom = :contenu";
	private static final String QUERY_GET_ID_ENSEIGNANT = "SELECT u.id FROM Personne u WHERE u.nom = :enseignant AND u.roles = M";

	private static final String PARAM_MASTER = "master";
	private static final String PARAM_CONTENU = "contenu";
	private static final String PARAM_ENSEIGNANT = "enseignant";

	Cours cours;

	public void creerCours(Cours c){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		//em.flush();
		em.close();
	}

	public int getIdMaster(String nom_master){

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		Master m = null;

		m = em.createQuery(QUERY_GET_ID_MASTER,Master.class)
				.setParameter(PARAM_MASTER, nom_master)
				.getSingleResult();

		em.close();

		return m.getId();
	}
	
	public int getIdContenu(String nom_contenu){

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		Contenu c = null;

		c = em.createQuery(QUERY_GET_ID_CONTENU,Contenu.class)
				.setParameter(PARAM_CONTENU, nom_contenu)
				.getSingleResult();

		em.close();

		return c.getId();
	}
	
	
	public int getIdEnseignant(String nom_enseignant){

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		Personne p = null;

		p = em.createQuery(QUERY_GET_ID_ENSEIGNANT,Personne.class)
				.setParameter(PARAM_ENSEIGNANT, nom_enseignant)
				.getSingleResult();

		em.close();

		return p.getId();
	}


}