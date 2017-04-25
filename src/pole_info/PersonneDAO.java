package pole_info;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;


@RequestScoped
public class PersonneDAO {
	
	//private static final String PERSISTENCE_UNIT_NAME = "pole";
	
	private static final String QUERY_AUTH = "SELECT u FROM Personne u "
			+ "WHERE u.email = :email AND u.password = :password";
	
	private static final String PARAM_EMAIL = "email";
	private static final String PARAM_PASSWORD = "password";
	
	//private static 
	//@PersistenceUnit(name="pole")
	//EntityManagerFactory emf;
	
	//@PersistenceContext(unitName = "pole")
	//EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
	//EntityManager em = factory.createEntityManager();
	
	Personne personne;
	
//	public void creerPersonne(Personne personne){
//		em.persist(personne);
//	}
	
	//@Transactional
	public Personne trouverPersonne(String email, String password){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		
		Personne p = null;
		Query requete = null;
		
		System.out.println("Entrée méthode trouverPersonne");
		
		//em.persist(personne);
		//factory = Persistence.createEntityManagerFactory("pole");
		//System.out.println("factory passée");
		//em = Persistence.createEntityManager();	
		//System.out.println("EM créée");
		//em.getTransaction().begin();
		//System.out.println("Transaction commencée");
		//em.persist(p);
		//System.out.println("EM persist");

		//EntityManager em = emf.createEntityManager();
		
		System.out.println("query début");
		
		p = em.createQuery(QUERY_AUTH,Personne.class)
		.setParameter(PARAM_EMAIL, email)
		.setParameter(PARAM_PASSWORD, password)
		.getSingleResult();
		
		System.out.println("PersDAO : " + p);
		
		return p;
	}
	
}
