package pole_info;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.io.github.dramanebamba.pole_info.model.Contenu;
import main.java.io.github.dramanebamba.pole_info.model.Cours;
import pole_info.Personne;

@RequestScoped
public class CoursDAO
{
	// private static final String QUERY_GET = "SELECT u FROM Cours u";
	private static final String QUERY_GET_COURS = "SELECT c.nom FROM Cours u, Contenu c WHERE u.id_contenu = c.id AND u.obligatoire = 'N'";
	private static final String QUERY_GET_ID = "SELECT c.id FROM Cours u, Contenu c WHERE u.id_contenu = c.id AND u.obligatoire = 'N'";
	public List<Contenu> getListCours(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		List<Contenu> nomCours = new ArrayList<>();
		System.out.println("récupération du résultat de la requête");
		nomCours = em.createQuery(QUERY_GET_COURS,Contenu.class).getResultList();
		System.out.println("Requête exécutée avec succès");
		System.out.println(nomCours);
		em.close();

		return nomCours;
	}
	public List<Contenu> getIdCours(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();

		List<Contenu> idCours = new ArrayList<>();
		System.out.println("récupération du résultat de la requête");
		idCours = em.createQuery(QUERY_GET_ID,Contenu.class).getResultList();
		System.out.println("Requête exécutée avec succès");
		System.out.println(idCours);
		em.close();

		return idCours;
	}

}
