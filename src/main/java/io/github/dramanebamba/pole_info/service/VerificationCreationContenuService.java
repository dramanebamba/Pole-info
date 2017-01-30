package main.java.io.github.dramanebamba.pole_info.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VerificationCreationContenuService {

	public String CreationContenu(String nomMat)
	{
		return (nomMat.equals("KM") || nomMat.equals("Java EE") &&
				nomMat.equals("Negociation") && nomMat.equals("DataScience"))?"Création Contenu effectué":"Mauvaise matière";
	}
}
