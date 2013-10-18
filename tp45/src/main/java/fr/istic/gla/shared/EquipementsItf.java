package fr.istic.gla.shared;

	import java.sql.Date;

	import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public interface EquipementsItf {
	
	public String getNature();
		public void setNature(String nature);
		public String getConsomation();
		public void setConsomation(String consomation);

		
		public Long getId();
		public void setId(Long id);
		
		public Home getHabitation();

		public void setHabitation(Home Habitation);

	



}
