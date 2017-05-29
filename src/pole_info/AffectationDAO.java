package pole_info;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.gson.Gson;

import main.java.io.github.dramanebamba.pole_info.model.Affectation;
import main.java.io.github.dramanebamba.pole_info.model.Master;

@RequestScoped
public class AffectationDAO {
	private static final String QUERY_GET_LIST = "SELECT u.id_personne FROM Affectation u WHERE u.id_contenu = :id";
	private static final String QUERY_COUNT = "SELECT COUNT(a) FROM Affectation a WHERE a.id_master = :id_master AND a.id_contenu = :id_contenu AND a.annee = :annee";
	private static final String QUERY_GET_STUDENT_BY_LESSON = "SELECT a.id_personne FROM Affectation a WHERE a.id_master = :id_master AND a.id_contenu = :id_contenu";
	private static final String PARAM_ID = "id";
	
	public List<Integer> getListePersonnes(int id_contenu)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		List<Integer> li = em.createQuery(QUERY_GET_LIST,Integer.class).setParameter(PARAM_ID, id_contenu).getResultList();
		em.close();
		return li;
	}
	
	public void setAffectation(Affectation affectation){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(affectation);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Affectation> countAffectation(int id_master, int id_contenu, int annee){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		List<Affectation> numAffectation = em.createQuery(QUERY_COUNT,Affectation.class).setParameter("id_master", id_master).setParameter("id_contenu", id_contenu).setParameter("annee", annee).getResultList();
		
		return numAffectation;
	}
	
	public List<Integer> getStudentByCourses(int id_master, int id_contenu)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		List<Integer> studentIds = em.createQuery(QUERY_GET_STUDENT_BY_LESSON,Integer.class).setParameter("id_master", id_master).setParameter("id_contenu", id_contenu).getResultList();
		System.out.println(studentIds);
		em.close();
		return studentIds;
	}
	
	
}
