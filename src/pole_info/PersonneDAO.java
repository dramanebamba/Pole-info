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

import main.java.io.github.dramanebamba.pole_info.model.Master;

@RequestScoped
public class PersonneDAO {

	private static final String QUERY_AUTH = "SELECT u FROM Personne u " + "WHERE u.email = :email AND u.password = :password";
	private static final String QUERY_ROLE = "SELECT u.roles FROM Personne u WHERE u.email = :email AND u.password = :password";
	private static final String QUERY_GET_ID = "SELECT u FROM Personne u WHERE u.id = :id";
	private static final String QUERY_GET_BY_MASTER = "SELECT u FROM Personne u WHERE u.id_master = :id_master AND u.roles = 'S'";
	private static final String PARAM_EMAIL = "email";
	private static final String PARAM_PASSWORD = "password";
	private static final String PARAM_ID = "id";
	private static final String PARAM_ID_MASTER = "id_master";


	Personne personne;
	
	public String getRoles(String email, String password)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		
		String roles = em.createQuery(QUERY_ROLE,String.class).setParameter(PARAM_EMAIL, email).setParameter(PARAM_PASSWORD, password).getSingleResult();
		em.close();

		return roles;
	}

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

		System.out.println("query début trouverPersonne");

		List<Personne> li = em.createQuery(QUERY_AUTH,Personne.class).setParameter(PARAM_EMAIL, email).setParameter(PARAM_PASSWORD, password)
				.getResultList();
		
		System.out.println("query fin trouverPersonne");
		em.close();
		
		return (li.isEmpty())?false:true;
	}
	
	public List<Personne> getMasterById(int id_master){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		
		List<Personne> listStudent  = em.createQuery(QUERY_GET_BY_MASTER,Personne.class).setParameter(PARAM_ID_MASTER, id_master).getResultList();		
		
		return listStudent;
	}

}
