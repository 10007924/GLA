package fr.istic.gla.shared;

	import java.sql.Date;

	import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Equipements implements EquipementsItf {
	

		private Long id;
		private String Nature;
		private String Consomation;
		
		
		private Home Habitation;

		public Equipements(String nature, String consomation,
				Home habitation) {
			Nature = nature;
			Consomation = consomation;
			Habitation = habitation;
		}
		
		public Equipements() {
		}
		public String getNature() {
			return Nature;
		}
		public void setNature(String nature) {
			Nature = nature;
		}
		public String getConsomation() {
			return Consomation;
		}
		public void setConsomation(String consomation) {
			Consomation = consomation;
		}

		
		@Id
		@GeneratedValue
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		@ManyToOne(cascade = CascadeType.PERSIST)
		public Home getHabitation() {
			return Habitation;
		}

		public void setHabitation(Home Habitation) {
			this.Habitation = Habitation;
		}
		@Override
		public String toString() {
			return "Equipements [id=" + id + ", Nature=" + Nature
					+ ", Consomation=" + Consomation + ", Habitation="
					+ Habitation + "]";
		}
		

	



}
