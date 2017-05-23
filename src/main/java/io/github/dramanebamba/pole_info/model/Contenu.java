package io.github.dramanebamba.pole_info.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the Contenu database table.
 *
 */
@ManagedBean
@SessionScoped
@Entity
@NamedQuery(name="Contenu.findAll", query="SELECT c FROM Contenu c")
public class Contenu implements Serializable {
	private static final long serialVersionUID = 1L;

	public Contenu(String apprentissage, String biblio, String contents, String description, int ects,
			String nom, String objectives, int volumeHoraire, int volumeProjet) {
		// this.id = id;
		this.apprentissage = apprentissage;
		this.biblio = biblio;
		this.contents = contents;
		this.description = description;
		this.ects = ects;
		this.nom = nom;
		this.objectives = objectives;
		this.volumeHoraire = volumeHoraire;
		this.volumeProjet = volumeProjet;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String apprentissage;

	@Lob
	private String biblio;

	@Lob
	private String contents;

	@Lob
	private String description;

	private int ects;

	private String nom;

	@Lob
	private String objectives;

	@Column(name="volume_horaire")
	private int volumeHoraire;

	@Column(name="volume_projet")
	private int volumeProjet;

	public Contenu() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApprentissage() {
		return this.apprentissage;
	}

	public void setApprentissage(String apprentissage) {
		this.apprentissage = apprentissage;
	}

	public String getBiblio() {
		return this.biblio;
	}

	public void setBiblio(String biblio) {
		this.biblio = biblio;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEcts() {
		return this.ects;
	}

	public void setEcts(int ects) {
		this.ects = ects;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getObjectives() {
		return this.objectives;
	}

	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}

	public int getVolumeHoraire() {
		return this.volumeHoraire;
	}

	public void setVolumeHoraire(int volumeHoraire) {
		this.volumeHoraire = volumeHoraire;
	}

	public int getVolumeProjet() {
		return this.volumeProjet;
	}

	public void setVolumeProjet(int volumeProjet) {
		this.volumeProjet = volumeProjet;
	}

}
