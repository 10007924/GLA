package fr.istic.gla.shared;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Home implements HomeItf {
	
	private Long id;
	private int superficie;
	private String adress;
	private String ip;
	private List<Equipements> equipements = new ArrayList<Equipements>();
	
	

	
	private Person propriétaire;

	public Home() {
	}

	public Home(int superficie, String adress, String ip) {
		this.superficie = superficie;
		this.adress = adress;
		this.ip = ip;
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	public Person getPropriétaire() {
		return propriétaire;
	}

	public void setPropriétaire(Person propriétaire) {
		this.propriétaire = propriétaire;
	}
	
	@OneToMany(mappedBy="id",cascade = CascadeType.PERSIST)
	public List<Equipements> getEquipements() {
		return equipements;
	}

	public void setEquipements(List<Equipements> equipements) {
		this.equipements = equipements;
	}
	@Override
	public String toString() {
		return "Home [id=" + id + ", superficie=" + superficie + ", adress="
				+ adress + ", ip=" + ip + "]";
	}
	
	
	
}

