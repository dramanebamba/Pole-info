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

	@SuppressWarnings("resource")
	public void exportJSON()
	{
		Gson json = new Gson();

		List<String> affectations = new ArrayList<>();
		affectations.add("Theo Gelly");
		FileWriter writer;
		
		try 
		{
			File fil = new File("/Users/theogelly/Documents/test.json");
			fil.createNewFile();
			writer = new FileWriter(fil); 
			
			String json_string = json.toJson(affectations);
			
			System.out.println("Je veux export " + json_string + " dans le fichier : " + fil);
			json.toJson(json_string, writer);
			writer.flush();
			writer.close();
		} 
		catch (JsonIOException e) 
		{
			throw new IllegalStateException(e);
		} 
		catch (IOException e) 
		{
			throw new IllegalStateException(e);
		}
	}

	public boolean trouverPersonne(String email, String password){

		exportJSON();
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
