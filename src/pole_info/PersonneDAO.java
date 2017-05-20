package pole_info;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/*import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;*/


@RequestScoped
public class PersonneDAO {

	private static final String QUERY_AUTH = "SELECT u FROM Personne u "
			+ "WHERE u.email = :email AND u.password = :password";
//	private static final String QUERY_ID = "SELECT u.id FROM Personne u "
//			+ "WHERE u.email = :email AND u.password = :password";

	private static final String PARAM_EMAIL = "email";
	private static final String PARAM_PASSWORD = "password";

	Personne personne;

	public void creerPersonne(Personne personne){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(personne);
		em.getTransaction().commit();
		//em.flush();
		em.close();
	}

	public int getId(String email, String password){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		Personne p = null;
		
		p = em.createQuery(QUERY_AUTH,Personne.class)
				.setParameter(PARAM_EMAIL, email)
				.setParameter(PARAM_PASSWORD, password)
				.getSingleResult();
		
		em.close();
		
		return p.getId();
	}
	
	public boolean trouverPersonne(String email, String password){

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		Personne p = null;

		System.out.println("query début trouverPersonne");

		p = em.createQuery(QUERY_AUTH,Personne.class)
				.setParameter(PARAM_EMAIL, email)
				.setParameter(PARAM_PASSWORD, password)
				.getSingleResult();

		System.out.println("PersDAO : " + p);
		
		System.out.println("query fin trouverPersonne");
		
		em.close();
		
		if(p != null){
			return true;
		}
		else{
			return false;
		}
	}
	
}
