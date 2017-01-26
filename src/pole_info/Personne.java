package pole_info;

import java.util.Vector;

public class Personne 
{
	static int noC = 1;
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String parcours;
	private String fax;
	private String home_page = null;
	private String cv = null;
	private String notes = null;
	private String roles = "M";
	private String password = null;
	private int id_master = 0;
	private int annee_master = 0;
	
	static Vector<Personne> BDD = new Vector<Personne>();

	public Personne(String nom, String pre, String mail, String parcours, String cv, String note, String pw, int id_m, int annee, String role)
	{
		setId(noC++);
		setNom(nom);
		setPrenom(pre);
		setParcours(parcours);
		setEmail(mail);
		setCv(cv);
		setNotes(note);
		if(role != null) setRoles(role);
		setPassword(pw);
		setId_master(id_m);
		setAnnee_master(annee);
	}
	
	public String getNom() 
	{
		return nom;
	}

	public void setNom(String nom) 
	{
		this.nom = nom;
	}

	public String getPrenom() 
	{
		return prenom;
	}

	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getParcours() 
	{
		return parcours;
	}

	public void setParcours(String parcours) 
	{
		this.parcours = parcours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getFax() 
	{
		return fax;
	}

	public void setFax(String fax) 
	{
		this.fax = fax;
	}

	public String getHome_page() 
	{
		return home_page;
	}

	public void setHome_page(String home_page) 
	{
		this.home_page = home_page;
	}

	public String getCv() 
	{
		return cv;
	}

	public void setCv(String cv) 
	{
		this.cv = cv;
	}

	public String getNotes() 
	{
		return notes;
	}

	public void setNotes(String notes) 
	{
		this.notes = notes;
	}

	public String getRoles() 
	{
		return roles;
	}

	public void setRoles(String roles) 
	{
		this.roles = roles;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public int getId_master() 
	{
		return id_master;
	}

	public void setId_master(int id_master) 
	{
		this.id_master = id_master;
	}

	public int getAnnee_master() 
	{
		return annee_master;
	}

	public void setAnnee_master(int annee_master) 
	{
		this.annee_master = annee_master;
	}
	
	public String toString()
	{
		return (roles.equals("Et"))?("Je suis un étudiant, mon nom est "+nom+" et mon prénom "+prenom):("Je suis un enseignant, mon nom est "+nom+" et mon prénom "+prenom);
	}
}
