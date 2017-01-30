package main.java.io.github.dramanebamba.pole_info.service;


import java.util.Vector;
import javax.enterprise.context.ApplicationScoped;
import main.java.io.github.dramanebamba.pole_info.model.Cours;

@ApplicationScoped
public class CoursService {

	private static Vector<Cours> Cours = new Vector<Cours>();

	public static Vector<Cours> getCours() {
		return Cours;
	}

	public static void setCours(Vector<Cours> cours) {
		Cours = cours;
	}

}
