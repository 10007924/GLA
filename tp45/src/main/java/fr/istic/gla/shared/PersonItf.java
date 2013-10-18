package fr.istic.gla.shared;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public interface PersonItf {

		public Long getId();
	
	public void setId(Long id);
	

	public String getFb();
	
	public void setFb(String fb);
	
	public Date getBirthdate();
	
	public void setBirthdate(Date birthdate);

	public String getLastname();
	public String getFirstname();
	public void setFirstname(String firstname);
	public boolean isGender();
	public void setGender(boolean gender);
	
	public void setLastname(String lastname);
	
	public void setProprietees(List<Home> proprietees);

	public void setAmis(List<PersonItf> amis);

	public List<PersonItf> getAmis();
	
	public List<Home> getProprietees();
	
}