package main.java.io.github.dramanebamba.pole_info.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import main.java.io.github.dramanebamba.pole_info.model.Contenu;
import main.java.io.github.dramanebamba.pole_info.utils.QueryInsertContent;




@ApplicationScoped
public class VerificationCreationContenuService {

	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private QueryInsertContent qic;
	
	
	public String CreationContenu(String nomMat)
	{
		
		return (nomMat.equals("KM") || nomMat.equals("Java EE") &&
				nomMat.equals("Negociation") && nomMat.equals("DataScience"))?"Création Contenu effectué":"Mauvaise matière";
	}
	
	@Transactional
	public void persist(Contenu contenu) {
		em.persist(contenu);
	}
}
