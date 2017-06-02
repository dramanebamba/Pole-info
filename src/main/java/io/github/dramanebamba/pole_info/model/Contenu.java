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
@Table(name="Contenu")
public class Contenu {

	static int noCont = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "description")
	private String description;

	@Column(name = "apprentissage")
	private char apprentissage;

	@Column(name = "volume_horaire")
	private int volume_horaire ;

	@Column(name = "ects")
	private String ects;

	@Column(name = "volume_projet")
	private int volume_projet ;

	@Column(name = "objectives")
	private String objectives;

	@Column(name = "contents")
	private String contents;

	@Column(name = "biblio")
	private String biblio;

	public Contenu(String n, String d, char a, int v, String e, int vo, String c, String b, String o) {
		// TODO Auto-generated constructor stub
		setId(noCont++);
		setNomMat(n);
		setDesc(d);
		setApp(a);
		setVolHoraire(v);
		setEcts(e);
		setVolume_projet(vo);
		setContent(c);
		setBiblio(b);
		setObj(o);
	}

	public Contenu()
	{
		setId(noCont++);
	}

	private void setBiblio(String biblio) {
		// TODO Auto-generated method stub
		this.biblio = biblio;

	}

	public String getBiblio(){
		return biblio;
	}

	private void setContent(String content) {
		// TODO Auto-generated method stub
		this.contents = content;
	}

	public String getContent(){
		return contents;
	}

	private void setEcts(String ects) {
		// TODO Auto-generated method stub
		this.ects=ects;

	}

	public String getEcts(){
		return ects;
	}

	private void setVolHoraire(int vol_h) {
		this.volume_horaire = vol_h;
	}

	public int getVolHoraire(){
		return volume_horaire;
	}

	private void setApp(char app) {
		// TODO Auto-generated method stub
		this.apprentissage = app;

	}

	public char getApp(){
		return apprentissage;
	}

	private void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;

	}

	public int getId(){
		return id;
	}

	public String getNomMat()
	{
		return nom;
	}

	private void setNomMat(String nomMat)
	{
		this.nom = nomMat;
	}

	public String getDesc()
	{
		return description;
	}
	
	private void setDesc(String desc)
	{
		this.description = desc;
	}

	public String getObj() {
		return objectives;
	}

	private void setObj(String obj) {
		this.objectives = obj;
	}

	public int getVolume_projet() {
		return volume_projet;
	}

	private void setVolume_projet(int volume_projet) {
		this.volume_projet = volume_projet;
	}
}
