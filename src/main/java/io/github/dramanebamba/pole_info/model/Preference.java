package main.java.io.github.dramanebamba.pole_info.model;

public class Preference {
	private int id_master = 0;
	private int id_contenu = 0;
	private int id_personne = 0;
	private int niveau = 0;
	
	public Preference(int id_master, int id_contenu, int id_personne, int niveau) {
		setId_master(id_master);
		setId_contenu(id_contenu);
		setId_personne(id_personne);
		setNiveau(niveau);
	}
	
	public int getId_master() {
		return id_master;
	}
	private void setId_master(int id_master) {
		this.id_master = id_master;
	}
	public int getId_contenu() {
		return id_contenu;
	}
	private void setId_contenu(int id_contenu) {
		this.id_contenu = id_contenu;
	}
	public int getId_personne() {
		return id_personne;
	}
	private void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}
	public int getNiveau() {
		return niveau;
	}
	private void setNiveau(int niveau) {
		this.niveau = niveau;
	}
}
