package main.java.io.github.dramanebamba.pole_info.model;

import java.util.Vector;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApplicationScoped
@Entity
@Table(name="Personne")
public class Personne {

	static int noC = 1;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "fax")
	private String fax;
	
	@Column(name = "home_page")
	private String home_page = null;
	
	@Column(name = "cv")
	private String cv = null;
	
	@Column(name = "notes")
	private String notes = null;
	
	@Column(name = "password")
	private String password = null;
	
	@Column(name = "roles")
	private String roles = "M";
	
	@Column(name = "id_master")
	private int id_master = 0;
	
	@Column(name = "annee_master")
	private int annee_master = 0;
	
	@Column(name = "adresse")
	private String adresse = "";
	
	@Column(name = "mobile")
	private String mobile = "";
	
	@Column(name = "vacataire")
	private String vacataire = "N";

	public Personne(String nom, String pre, String mail,
			String cv, String note, String pw,
			int id_m, int annee, String role, String add){
		setId(noC++);
		setNom(nom);
		setPrenom(pre);
		setEmail(mail);
		setCv(cv);
		setNotes(note);
		if(role != null) setRoles(role);
		setPassword(pw);
		setId_master(id_m);
		setAnnee_master(annee);
		setAdress(add);
	}
	
	public Personne(String nom, String pre, String mail,
			String tel, String fax, String hp,
			String cv, String note, String pw,
			int id_m, int annee, String role){
		setId(noC++);
		setNom(nom);
		setPrenom(pre);
		setEmail(mail);
		setTelephone(tel);
		setFax(fax);
		setHome_page(hp);
		setCv(cv);
		setNotes(note);
		if(role != null) setRoles(role);
		setPassword(pw);
		setId_master(id_m);
		setAnnee_master(annee);
	}
	
	public void setAdress(String s)
	{
		adresse = s;
	}
	
	public String getAdress()
	{
		return adresse;
	}
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Personne() {
		
	}

	public String getNom() 
	{
		return nom;
	}

	private void setNom(String nom) 
	{
		this.nom = nom;
	}

	public String getPrenom() 
	{
		return prenom;
	}

	private void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}

	public String getEmail() 
	{
		return email;
	}

	private void setEmail(String email) 
	{
		this.email = email;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) 
	{
		this.id = id;
	}

	public String getFax() 
	{
		return fax;
	}

	private void setFax(String fax) 
	{
		this.fax = fax;
	}

	public String getHome_page() 
	{
		return home_page;
	}

	private void setHome_page(String home_page) 
	{
		this.home_page = home_page;
	}

	public String getCv() 
	{
		return cv;
	}

	private void setCv(String cv) 
	{
		this.cv = cv;
	}

	public String getNotes() 
	{
		return notes;
	}

	private void setNotes(String notes) 
	{
		this.notes = notes;
	}

	public String getRoles() 
	{
		return roles;
	}

	private void setRoles(String roles) 
	{
		this.roles = roles;
	}

	public String getPassword() 
	{
		return password;
	}

	private void setPassword(String password) 
	{
		this.password = password;
	}

	public int getId_master() 
	{
		return id_master;
	}

	private void setId_master(int id_master) 
	{
		this.id_master = id_master;
	}

	public int getAnnee_master() 
	{
		return annee_master;
	}

	private void setAnnee_master(int annee_master) 
	{
		this.annee_master = annee_master;
	}
	
	@Override
	public String toString()
	{
		return (roles.equals("Et"))?("Je suis un étudiant, mon nom est "+nom+" et mon prénom "+prenom):("Je suis un enseignant, mon nom est "+nom+" et mon prénom "+prenom);
	}
}
