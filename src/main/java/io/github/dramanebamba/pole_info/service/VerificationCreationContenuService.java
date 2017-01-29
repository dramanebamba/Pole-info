package main.java.io.github.dramanebamba.pole_info.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VerificationCreationContenuService {

	public String CreationContenu(String nom)
	{
		return (nom.equals("KM") || nom.equals("Java EE") &&
				nom.equals("Negociation") && nom.equals("DataScience"))?"Création Contenu effectué":"Mauvaise matière";
	}
}
