package pole_info;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VerificationBDD 
{
	public boolean test(String mail)
	{
		System.out.println("TEST CDI");
		for(Personne personne:Personne.BDD)
			if(personne.getEmail().equals(mail))	return false;
		return true;
	}

}