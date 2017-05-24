package main.java.io.github.dramanebamba.pole_info.service;

import java.util.Vector;

import main.java.io.github.dramanebamba.pole_info.model.Affectation;

public class AffectationService {
	private static Vector<Affectation> affectation = new Vector<>();

	public static Vector<Affectation> getAffectation() {
		return affectation;
	}

	public static void setAffectation(Vector<Affectation> affectation) {
		AffectationService.affectation = affectation;
	}

}
