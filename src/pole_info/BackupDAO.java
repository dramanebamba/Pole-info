package pole_info;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@RequestScoped
public class BackupDAO {
	
	public void creerBackup(Backup backup){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		
		System.out.println("DEBUT BACKUP DAO");
		
		em.getTransaction().begin();
		System.out.println("BEGIN");
		em.persist(backup);
		System.out.println("PERSIST");
		em.getTransaction().commit();
		System.out.println("COMMIT");
		//em.flush();
		System.out.println("CLOSE");
		em.close();
	}

}
