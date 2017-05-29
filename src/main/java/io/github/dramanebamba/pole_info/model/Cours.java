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
@Table(name="Cours")
public class Cours 
{
	@Id
	private int id_master = 0;
	
	@Column(name = "id_contenu")
	private int id_contenu = 0;
	
	@Column(name = "id_enseignant")
	private int id_enseignant = 0;
	
	@Column(name = "periode")
	private String periode = "NULL";
	
	@Column(name = "obligatoire")
	private String obligatoire = "0";
	
	@Column(name = "notes")
	private String notes;
	
	public Cours(int id_master, int id_contenu, int id_enseignant, String periode, String obligatoire, String notes) {
		setId_master(id_master);
		setId_contenu(id_contenu);
		setId_enseignant(id_enseignant);
		setPeriode(periode);
		setObligatoire(obligatoire);
		setNotes(notes);
	}
	
	public Cours()
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
	private void setId_contenu(int id_contenu) {
		this.id_contenu = id_contenu;
	}
	public int getId_enseignant() {
		return id_enseignant;
	}
	private void setId_enseignant(int id_enseignant) {
		this.id_enseignant = id_enseignant;
	}
	public String getPeriode() {
		return periode;
	}
	private void setPeriode(String periode) {
		this.periode = periode;
	}
	public String getObligatoire() {
		return obligatoire;
	}
	public void setObligatoire(String obligatoire) {
		this.obligatoire = obligatoire;
	}
	public String getNotes() {
		return notes;
	}
	private void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Cours [id_master=" + id_master + ", id_contenu=" + id_contenu + ", id_enseignant=" + id_enseignant
				+ ", periode=" + periode + ", obligatoire=" + obligatoire + ", notes=" + notes + "]";
	}
}
