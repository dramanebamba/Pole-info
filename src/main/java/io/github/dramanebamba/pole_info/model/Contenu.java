package io.github.dramanebamba.pole_info.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contenu {
	@Id
	private int id;
	private String nom;
	private String description;
	private String apprentissage;
	private int volume_horaire ;
	private int ects;
	private String objectives ;
	private String contents;
	private String biblio;

	
	public Contenu() {

	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getApprentissage() {
		return apprentissage;
	}


	public void setApprentissage(String apprentissage) {
		this.apprentissage = apprentissage;
	}


	public int getVolume_horaire() {
		return volume_horaire;
	}


	public void setVolume_horaire(int volume_horaire) {
		this.volume_horaire = volume_horaire;
	}


	public int getEcts() {
		return ects;
	}


	public void setEcts(int ects) {
		this.ects = ects;
	}


	public String getObjectives() {
		return objectives;
	}


	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public String getBiblio() {
		return biblio;
	}


	public void setBiblio(String biblio) {
		this.biblio = biblio;
	}

}
