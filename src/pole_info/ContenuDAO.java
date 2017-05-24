package pole_info;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.io.github.dramanebamba.pole_info.model.Contenu;

@RequestScoped
public class ContenuDAO {

	private static final String QUERY_CONT = "SELECT u FROM Contenu u ";
	Contenu contenu;

	public void creerContenu(Contenu contenu){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(contenu);
		em.getTransaction().commit();
		em.close();
	}

}
