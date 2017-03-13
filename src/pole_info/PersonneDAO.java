package pole_info;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@ApplicationScoped
public class PersonneDAO {
	
	private static final String PERSISTENCE_UNIT_NAME = "pole";
	
	private static final String QUERY_AUTH = "SELECT u FROM Personne u "
			+ "WHERE u.email = :email AND u.password = :password";
	
	private static final String PARAM_EMAIL = "email";
	private static final String PARAM_PASSWORD = "password";
	
	private static EntityManagerFactory factory;
	EntityManager em;
	
	Personne personne;
	
	public void creerPersonne(Personne personne){
		em.persist(personne);
	}
	
	public Personne trouverPersonne(String email, String password){
		Personne p = null;
		
		System.out.println("Entrée méthode trouverPersonne");
		
		//em.persist(personne);
		
		factory = Persistence.createEntityManagerFactory("pole");
		System.out.println("factory passée");
		
		em = factory.createEntityManager();	
		System.out.println("EM créée");
		
		em.getTransaction().begin();
		System.out.println("Transaction commencée");
		
		em.persist(p);
		System.out.println("EM persist");

		
		Query requete = em.createQuery(QUERY_AUTH,Personne.class);
		requete.setParameter(PARAM_EMAIL, email);
		requete.setParameter(PARAM_PASSWORD, password);
		
		System.out.println("Bloc query");
		
		personne = (Personne) requete.getSingleResult();
		
		em.close();
		
		return p;
	}
	
}
