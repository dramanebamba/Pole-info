package pole_info;

import javax.enterprise.context.RequestScoped;

import main.java.io.github.dramanebamba.pole_info.model.Contenu;

@RequestScoped
public class ContenuDAO {
	
	private static final String QUERY_CONT = "SELECT u FROM Contenu u ";
	Contenu contenu;

}
