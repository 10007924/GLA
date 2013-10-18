package fr.istic.tpjpa.domain;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Person {
	
	private Long id;
	private String firstname;
	private String lastname;
	private boolean gender;
	private String fb;
	private  Date birthdate;


	private List<Person> amis = new ArrayList<Person>();
	

	private List<Home> proprietees = new ArrayList<Home>();
	
	
	public Person(Long id, String firstname, String lastname, boolean gender,
			String fb, Date birthdate) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.fb = fb;
		this.birthdate = birthdate;
	}

	public Person() {
	}

	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	

	public String getFb() {
		return fb;
	}
	
	public void setFb(String fb) {
		this.fb = fb;
	}
	
	public Date getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getLastname() {
		return lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setProprietees(List<Home> proprietees) {
		this.proprietees = proprietees;
	}

	public void setAmis(List<Person> amis) {
		this.amis = amis;
	}
	
	@ManyToMany
	public List<Person> getAmis() {
		return amis;
	}
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.PERSIST)
	public List<Home> getProprietees() {
		return proprietees;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstname=" + firstname + ", lastname="
		+ lastname + ", gender=" + gender +", birthdate=" + birthdate.toString() + ", facebook=" + fb + "]";
	}
	
}