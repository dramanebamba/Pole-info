package pole_info;

import java.util.Vector;

public class Etudiant extends Personne
{
	static Vector<Etudiant> BDD = new Vector<Etudiant>();
	private String droits;
	
	public Etudiant(String droi, String nom, String pre, String mail, String pa, String c, String no, String ro, String pw, int id_m, int a)
	{
		setId(noC++);
		setDroits(droi);
		setNom(nom);
		setPrenom(pre);
		setParcours(pa);
		setEmail(mail);
		setCv(c);
		setNotes(no);
		setRoles("Et");
		setPassword(pw);
		setId_master(id_m);
		setAnnee_master(a);
	}

	public String getDroits() 
	{
		return droits;
	}

	public void setDroits(String droits) 
	{
		this.droits = droits;
	}
}
