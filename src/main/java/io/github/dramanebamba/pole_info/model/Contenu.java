package main.java.io.github.dramanebamba.pole_info.model;

import java.util.ArrayList;
import java.util.List;

public class Contenu {
	
	static int noCont = 1;
	private int idContenu;
	private String nomMat;
	private String desc;
	private String app;
	private String vol_horaire ;
	private String ects;
	private String obj ;
	private String content;
	private String biblio;

	private static List<Contenu> BDD_contenu = new ArrayList<Contenu>();
	
	public Contenu() {
		// TODO Auto-generated constructor stub
		setId(noCont++);
		setNomMat(nomMat);
		setDesc(desc);
		setApp(app);
		setVolHoraire(vol_horaire);
		setEcts(ects);
		setContent(content);
		setBiblio(biblio);
	}
	
	private void setBiblio(String biblio) {
		// TODO Auto-generated method stub
		this.biblio = biblio;
		
	}
	
	private String getBiblio(){
		return biblio;
	}

	private void setContent(String content) {
		// TODO Auto-generated method stub
		this.content = content;
	}
	
	private String getContent(){
		return content;
	}

	private void setEcts(String ects) {
		// TODO Auto-generated method stub
		this.ects=ects;
		
	}
	
	private String getEcts(){
		return ects;
	}

	private void setVolHoraire(String vol_h) {
		// TODO Auto-generated method stub
		this.vol_horaire = vol_h;
		
	}
	private String getVolHoraire(){
		return vol_horaire;
	}

	private void setApp(String app) {
		// TODO Auto-generated method stub
		this.app = app;
		
	}
	
	private String getApp(){
		return app;
	}

	private void setId(int id) {
		// TODO Auto-generated method stub
		this.idContenu = id;
		
	}
	
	private int getId(){
		return idContenu;
	}

	public String getNomMat() 
	{
		return nomMat;
	}

	public void setNomMat(String nomMat) 
	{
		this.nomMat = nomMat;
	}
	
	public String getDesc() 
	{
		return desc;
	}

	public void setDesc(String desc) 
	{
		this.desc = desc;
	}
	
	public static List<Contenu> getBDD() {
		return BDD_contenu;
	}

	public static void setBDD(List<Contenu> bDD_content) {
		BDD_contenu = bDD_content;
	}
}
