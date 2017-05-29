package main.java.io.github.dramanebamba.pole_info.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import main.java.io.github.dramanebamba.pole_info.model.*;
import pole_info.ContenuDAO;
import pole_info.Personne;
import pole_info.PersonneDAO;

@ApplicationScoped
public class VerificationBDDService 
{
	@Inject
	PersonneDAO personne;
	
	public boolean verification(String mail)
	{
		return (personne.isInBDD(mail))?false:true;
	}
}