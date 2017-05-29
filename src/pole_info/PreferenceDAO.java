package pole_info;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.io.github.dramanebamba.pole_info.model.Preference;

@RequestScoped
public class PreferenceDAO {

	private static final String QUERY_PREFERENCE_BY_ID_STUDENT = 
			"SELECT p FROM Preference p WHERE p.id_personne = :idP";
	private static final String PARAM_ID_PERSONNE = "idP";



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

	@SuppressWarnings("unchecked")
	public List<Preference> getPreference(int id) {
		//Persistence
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		//Preference List
		List<Preference> list = null;

		//Start transaction
		em.getTransaction().begin();

		//Retrieve all values
		list = em.createQuery(QUERY_PREFERENCE_BY_ID_STUDENT)
				.setParameter(PARAM_ID_PERSONNE, id)
				.getResultList();

		//Commit transaction
		em.getTransaction().commit();

		//Close
		em.close();

		return list;
	}
}
