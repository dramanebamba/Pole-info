package io.github.dramanebamba.pole_info.service;

import javax.enterprise.context.ApplicationScoped;
import io.github.dramanebamba.pole_info.model.*;

@ApplicationScoped
public class VerificationBDDService 
{
	public boolean test(String mail)
	{
		System.out.println("TEST CDI");
		if(Personne.getBDD().size()>0)
		{
			for(Personne personne:Personne.getBDD())
			{
				if(personne.getEmail().equals(mail))	
					return false;
			}
		}
		return true;
	}

}