package main.java.io.github.dramanebamba.pole_info.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import main.java.io.github.dramanebamba.pole_info.model.Cours;

@ApplicationScoped
public class VerificationCourseInBDD 
{
	@Inject
	CoursDAO cours;
	
	public boolean Check_course(int id_c, int new_val_id)
	{
		List<Cours> liste = cours.getAllCourses(id_c);
		for(Cours c: liste)
		{
			if(c.getId_contenu() == id_c && c.getId_master() == new_val_id)
				return false;
		}
		System.out.println("Cours non répertorié en base de donnée, ajout possible");
		return true;
	}
}
