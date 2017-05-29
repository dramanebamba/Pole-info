package pole_info;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@RequestScoped
public class BackupDAO {
	
	// private final static String QUERY_COUNT_BACKUP = "SELECT count(*) FROM Backup b";
	private final static String QUERY_LIST_BACKUP = "SELECT b FROM Backup b";
	private final static String QUERY_GET_BACKUP_BY_ID = "SELECT u.nom FROM Backup u "
			+ "WHERE u.idBackup= :id";
	private static final String PARAM_ID = "id";
	
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
	
	public List<Backup> listeDesBackups(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		
		List<Backup> listBackup = new ArrayList<>();
		System.out.println("AVANT QUERY");
		listBackup = em.createQuery(QUERY_LIST_BACKUP,Backup.class).getResultList();
		System.out.println("APRES QUERY");
		em.close();
		
		return listBackup;
	}
	
	public String getBackupName(int idBackup){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		
		String name = null;
		
		em.getTransaction().begin();
		name = (String) em.createQuery(QUERY_GET_BACKUP_BY_ID)
				.setParameter(PARAM_ID, idBackup)
				.getSingleResult();
		
		System.out.println("Backup_name : " + name);
		
		return name;
	}
	
	public void removeBackup(int idBackup){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pole");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.remove(em.find(Backup.class, idBackup));
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Backup #" + idBackup + " removed in DB");
	}

}
