package main.java.io.github.dramanebamba.pole_info.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Master database table.
 *
 */
@Entity
@NamedQuery(name="Master.findAll", query="SELECT m FROM Master m")
public class Master implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Lob
	private String description;

	private String nom;

	public Master() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return this.nom;
	}

	public Master(String nom, String description) {
		this.description = description;
		this.nom = nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
