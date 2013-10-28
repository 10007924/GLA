package fr.istic.gla.client;

import com.google.gwt.core.client.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanUtils;

import fr.istic.gla.shared.Book;
import fr.istic.gla.shared.BookItf;
import fr.istic.gla.shared.Person;
import fr.istic.gla.shared.PersonItf;

public class PersonJsonConverter {

	private PersonJsonConverter() {
	}
	
	private static PersonJsonConverter instance = new PersonJsonConverter();
	
	
	  // Instantiate the factory
	  fr.istic.gla.shared.MyFactory factory = GWT.create(fr.istic.gla.shared.MyFactory.class);
	  // In non-GWT code, use AutoBeanFactorySource.create(MyFactory.class);

	  public PersonItf makePerson() {
	    // Construct the AutoBean
	    AutoBean<PersonItf> person = factory.person();

	    // Return the Book interface shim
	    return person.as();
	  }

	  String serializeToJson(PersonItf person) {
	    // Retrieve the AutoBean controller
	    AutoBean<PersonItf> bean = AutoBeanUtils.getAutoBean(person);

	    return AutoBeanCodex.encode(bean).getPayload();
	  }

	  PersonItf deserializeFromJson(String json) {
	    AutoBean<PersonItf> bean = AutoBeanCodex.decode(factory, PersonItf.class, json);
	    return bean.as();
	  }

	public static PersonJsonConverter getInstance() {
		return instance;
	}
}
