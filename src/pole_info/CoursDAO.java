package pole_info;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.io.github.dramanebamba.pole_info.model.Cours;
import pole_info.Personne;

@RequestScoped
public class CoursDAO
{
	private static final String QUERY_GET = "SELECT u FROM Cours u";
}
