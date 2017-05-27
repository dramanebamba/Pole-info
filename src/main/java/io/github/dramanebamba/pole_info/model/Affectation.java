package main.java.io.github.dramanebamba.pole_info.model;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApplicationScoped
@Entity
@Table(name="Affectation")
public class Affectation {
	
	@Id
	private int id_master = 0;
	
	@Column(name = "id_contenu")
	private int id_contenu = 0;
	
	@Column(name = "id_personne")
	private int id_personne = 0;
	
	@Column(name = "annee")
	private int annee = 0;
	
	@Column(name = "note")
	private double note;
	
	public Affectation(int id_master, int id_contenu, int id_personne, int annee, double note) {
		setId_master(id_master);
		setId_contenu(id_contenu);
		setId_personne(id_personne);
		setAnnee(annee);
		setNote(note);
	}
	
	public Affectation()
	{
		
	}

	public int getId_master() {
		return id_master;
	}

	public void setId_master(int id_master) {
		this.id_master = id_master;
	}

	public int getId_contenu() {
		return id_contenu;
	}

	public void setId_contenu(int id_contenu) {
		this.id_contenu = id_contenu;
	}

	public int getId_personne() {
		return id_personne;
	}

	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}
}
