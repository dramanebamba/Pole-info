package pole_info;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.io.github.dramanebamba.pole_info.model.Contenu;
import main.java.io.github.dramanebamba.pole_info.model.Cours;

@RequestScoped
public class ContenuDAO {
	
	private static final String QUERY_GET = "SELECT u FROM Contenu u ";
	Contenu contenu;

	public List<Contenu> getAllCourses()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		System.out.println("chargement de la liste des cours");
		List<Contenu> list = new ArrayList<>();
		list = em.createQuery(QUERY_GET,Contenu.class).getResultList();

		em.close();
		return list;
	}
}
