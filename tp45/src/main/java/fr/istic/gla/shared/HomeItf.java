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
public interface HomeItf {
	
	public Long getId();
	public void setId(Long id);

	public int getSuperficie();
	public void setSuperficie(int superficie);
	public String getAdress();
	public void setAdress(String adress);
	public String getIp();
	public void setIp(String ip);
	
	public Person getPropriétaire();

	public void setPropriétaire(Person propriétaire);
	
	public List<Equipements> getEquipements();

	public void setEquipements(List<Equipements> equipements);
	
	
}

