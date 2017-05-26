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

	private static final String QUERY_CONT = "SELECT u FROM Contenu u ";
	private static final String QUERY_GET = "SELECT u FROM Contenu u ";
	private final static String QUERY_LIST_CONTENU = "SELECT b FROM Contenu b";

	Contenu contenu;

	public void creerContenu(Contenu contenu){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(contenu);
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
		Contenu contenu = em.find(Contenu.class, key);
		if(contenu!=null){
			em.getTransaction().begin();
			em.remove(contenu);
			em.getTransaction().commit();
			em.close();
			System.out.println("Suppression de la clé : " + key);
		}
		else{
			System.out.println(key + " est une clé inexistante");
		}

	}
}
