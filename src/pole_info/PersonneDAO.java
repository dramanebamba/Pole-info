package pole_info;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/*import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;*/

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

@RequestScoped
public class PersonneDAO {

	private static final String QUERY_AUTH = "SELECT u FROM Personne u " + "WHERE u.email = :email AND u.password = :password";
	private static final String QUERY_GET_ID = "SELECT u FROM Personne u WHERE u.id = :id";
	private static final String PARAM_EMAIL = "email";
	private static final String PARAM_PASSWORD = "password";
	private static final String PARAM_ID = "id";

	Personne personne;

	public void creerPersonne(Personne per){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(per);
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
	
	public Personne getPersonne(int id_p)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		Personne p = em.createQuery(QUERY_GET_ID,Personne.class).setParameter(PARAM_ID, id_p).getSingleResult();
		em.close();

		return p;
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

		return (p != null)?true:false;
	}

}
