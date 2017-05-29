package pole_info;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.io.github.dramanebamba.pole_info.model.Contenu;
import main.java.io.github.dramanebamba.pole_info.model.Cours;
import main.java.io.github.dramanebamba.pole_info.model.Master;

@RequestScoped
public class CoursDAO {

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
