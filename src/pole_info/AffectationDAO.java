package pole_info;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.gson.Gson;

import main.java.io.github.dramanebamba.pole_info.model.Affectation;

@RequestScoped
public class AffectationDAO {
	private static final String QUERY_GET_LIST = "SELECT u.id_personne FROM Affectation u WHERE u.id_contenu = :id";
	private static final String PARAM_ID = "id";
	
	public List<Integer> getListePersonnes(int id_contenu)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		List<Integer> li = em.createQuery(QUERY_GET_LIST,Integer.class).setParameter(PARAM_ID, id_contenu).getResultList();
		em.close();
		return li;
	}
}
