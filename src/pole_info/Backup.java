package pole_info;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApplicationScoped
@Entity
@Table(name="Backup")
public class Backup {

static int noB = 1;
	
	@Id
	@Column(name= "id_backup")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBackup;
	
	@Column(name = "backup_name")
	private String nom;
	
	@Column(name = "id_personne")
	private String idBackuper;
	
	@Column(name = "label")
	private String label;
	
	@Column(name = "date")
	private String date;
	
	public Backup(){
		
	}

	public Backup(int idBackup, String nom, String idBackuper, String label, String date) {
		setIdBackup(idBackup);
		setNom(nom);
		setIdBackuper(idBackuper);
		setLabel(label);
		setDate(date);
	}
	
	public Backup(String nom, String idBackuper, String label, String date) {
		setNom(nom);
		setIdBackuper(idBackuper);
		setLabel(label);
		setDate(date);
	}

	public int getIdBackup() {
		return idBackup;
	}

	private void setIdBackup(int idBackup) {
		this.idBackup = idBackup;
	}

	public String getNom() {
		return nom;
	}

	private void setNom(String nom) {
		this.nom = nom;
	}

	public String getIdBackuper() {
		return idBackuper;
	}

	private void setIdBackuper(String idBackuper) {
		this.idBackuper = idBackuper;
	}

	public String getLabel() {
		return label;
	}

	private void setLabel(String label) {
		this.label = label;
	}

	public String getDate() {
		return date;
	}

	private void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Backup [id_backup=" + idBackup + ", nom=" + nom + ", idBackuper=" + idBackuper + ", label=" + label
				+ ", date=" + date + "]";
	}
}
