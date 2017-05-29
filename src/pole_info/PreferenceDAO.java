package pole_info;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.io.github.dramanebamba.pole_info.model.Preference;

@RequestScoped
public class PreferenceDAO {

	public void createPreference(Preference pref){
		//Persistence
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		
		//Start transaction
		em.getTransaction().begin();
		
		//Insert preference in the DB
		em.persist(pref);
		
		//Commit transaction
		em.getTransaction().commit();
		
		//Close
		em.close();
	}
	
	public void removePreference(int idPreference){
		//Persistence
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		
		//Start transaction
		em.getTransaction().begin();
		
		//Retrieve the preference
		Preference p = em.find(Preference.class, idPreference);
		
		//Remove the preference
		em.remove(p);
		
		//Commit transaction
		em.getTransaction().commit();
		
		//Close
		em.close();
	}
}
