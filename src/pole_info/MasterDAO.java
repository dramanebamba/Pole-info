package pole_info;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.io.github.dramanebamba.pole_info.model.Master;

@RequestScoped
public class MasterDAO
{
	// private static final String QUERY_GET = "SELECT u FROM Master u";
	private final static String QUERY_LIST_MASTER = "SELECT b FROM Master b";
	private final static String QUERY_GET_BY_ID = "SELECT b FROM Master b WHERE b.id = :id";

	Master master;
	public void creerMaster(Master master){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(master);
		em.getTransaction().commit();
		em.close();
	}

	public List<Master> listeDesMasters(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		List<Master> listeDesMasters = new ArrayList<>();
		System.out.println("In progess : listeDesMasters");
		listeDesMasters = em.createQuery(QUERY_LIST_MASTER,Master.class).getResultList();
		System.out.println("Done : listeDesMasters");
		em.close();

		return listeDesMasters;
	}

	public void supprimerMaster(int key){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		Master master = em.find(Master.class, key);
		if(master!=null){
			em.getTransaction().begin();
			em.remove(master);
			em.getTransaction().commit();
			em.close();
			System.out.println("Suppression de la clé : " + key);
		}
		else{
			System.out.println(key + " est une clé inexistante");
		}

	}
	
	public List<Master> getMasterById(int id_master){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		
		List<Master> nomMaster  = em.createQuery(QUERY_GET_BY_ID,Master.class).setParameter("id", id_master).getResultList();		
		
		return nomMaster;
	}


}
