package pole_info;

abstract class Personne 
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
}
