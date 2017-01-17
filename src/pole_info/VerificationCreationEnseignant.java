package pole_info;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VerificationCreationEnseignant {

	public String CreationEnseignant(String nom, String prenom, String mail, String sitn)
	{
		return (nom.equals("Java") && prenom.equals("Java") &&
				mail.equals("Java@dauphine.fr") && sitn.equals("on"))?"yes Création Enseignant":"non Création Enseignant";
	}
}
