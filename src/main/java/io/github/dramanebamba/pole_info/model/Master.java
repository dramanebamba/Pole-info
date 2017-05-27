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
@Table(name="Master")
public class Master 
{
	static int noMaster = 1;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "description")
	private String description;
	
	public Master()
	{
		setId(noMaster++);
	}
	
	public Master(String n, String d)
	{
		setId(noMaster++);
		setNom(n);
		setDesc(d);
	}
	
	private void setId(int d)
	{
		id = d;
	}
	
	private void setNom(String n)
	{
		nom = n;
	}
	
	private void setDesc(String d)
	{
		description = d;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public String getDesc()
	{
		return description;
	}
}
