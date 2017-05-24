package pole_info;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.io.github.dramanebamba.pole_info.model.Cours;
import pole_info.Personne;

@RequestScoped
public class CoursDAO
{
	private static final String QUERY_GET = "SELECT u FROM Cours u";
	
	public List<Cours> getAllCourses()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		System.out.println("chargement de la liste des cours");
		List<Cours> list = new ArrayList<>();
		list = em.createQuery(QUERY_GET,Cours.class).getResultList();
		
		if(list.size() != 0)	for(Cours c: list)	System.out.println("Cours " + c);
		else	System.out.println("Liste vide");

		em.close();
		return list;
	}
}
