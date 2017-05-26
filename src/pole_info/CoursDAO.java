package pole_info;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import main.java.io.github.dramanebamba.pole_info.model.Cours;

@RequestScoped
public class CoursDAO {

	private static final String QUERY_GET_ID_MASTER = "SELECT u FROM Master u " + "WHERE u.nom = :master";
	private static final String QUERY_GET_ID_CONTENU = "SELECT u FROM Contenu u WHERE u.nom = :contenu";
	private static final String QUERY_GET_ID_ENSEIGNANT = "SELECT u FROM Personne u WHERE u.nom = :enseignant AND u.roles = M";

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

		Cours c = null;

		c = em.createQuery(QUERY_GET_ID_MASTER,Cours.class)
				.setParameter(PARAM_MASTER, nom_master)
				.getSingleResult();

		em.close();

		return c.getId_master();
	}
	
	public int getIdContenu(String nom_contenu){

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		Cours c = null;

		c = em.createQuery(QUERY_GET_ID_CONTENU,Cours.class)
				.setParameter(PARAM_CONTENU, nom_contenu)
				.getSingleResult();

		em.close();

		return c.getId_contenu();
	}
	
	
	public int getIdEnseignant(String nom_enseignant){

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		Cours c = null;

		c = em.createQuery(QUERY_GET_ID_ENSEIGNANT,Cours.class)
				.setParameter(PARAM_ENSEIGNANT, nom_enseignant)
				.getSingleResult();

		em.close();

		return c.getId_enseignant();
	}

}
