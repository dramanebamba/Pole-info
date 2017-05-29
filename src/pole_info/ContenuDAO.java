package pole_info;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.io.github.dramanebamba.pole_info.model.Contenu;
import main.java.io.github.dramanebamba.pole_info.model.Cours;

@RequestScoped
public class ContenuDAO {

	private static final String QUERY_GET = "SELECT u FROM Contenu u ";
	private final static String QUERY_LIST_CONTENU = "SELECT b FROM Contenu b";
	private static final String QUERY_GET_ID = "SELECT u FROM Contenu u WHERE u.id = :id";
	private static final String QUERY_CONTENU_MASTER = "SELECT u FROM Contenu u WHERE u.id IN"
			+ " (SELECT a.id_contenu FROM Affectation a INNER JOIN Cours c ON c.id_master = a.id_master"
			+ " WHERE a.id_master= :idMaster AND c.obligatoire = \"N\")";
	//SELECT * FROM Contenu WHERE id IN (SELECT a.id_contenu FROM Affectation a INNER JOIN Cours c  ON c.id_master = a.id_master WHERE a.id_master = 1 AND c.obligatoire = "N")
	private static final String PARAM_ID_MASTER = "idMaster";
	private static final String PARAM_ID = "id";

	Contenu contenu;

	public void creerContenu(Contenu cont){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(cont);
		em.getTransaction().commit();
		em.close();
	}

	public List<Contenu> getAllCourses()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		System.out.println("chargement de la liste des cours");
		List<Contenu> list = em.createQuery(QUERY_GET,Contenu.class).getResultList();

		em.close();
		return list;
	}
	
	public List<Contenu> getCoursesFromMaster(int idMaster){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		
		List<Contenu> list = em.createQuery(QUERY_CONTENU_MASTER,Contenu.class)
							.setParameter(PARAM_ID_MASTER, idMaster)
							.getResultList();
		
		return list;
	}
	
	public Contenu getContenu(int id_c)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		Contenu c = em.createQuery(QUERY_GET_ID,Contenu.class).setParameter(PARAM_ID, id_c).getSingleResult();
		em.close();

		return c;
	}
	
	public List<Contenu> listeDesContenus(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		List<Contenu> listeDesContenus = new ArrayList<>();
		System.out.println("In progess : listeDesContenus");
		listeDesContenus = em.createQuery(QUERY_LIST_CONTENU,Contenu.class).getResultList();
		System.out.println("Done : listeDesContenus");
		em.close();

		return listeDesContenus;
	}

	public void supprimerContenu(int key){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		Contenu cont = em.find(Contenu.class, key);
		if(contenu!=null){
			em.getTransaction().begin();
			em.remove(cont);
			em.getTransaction().commit();
			em.close();
			System.out.println("Suppression de la clé : " + key);
		}
		else{
			System.out.println(key + " est une clé inexistante");
		}

	}
}
