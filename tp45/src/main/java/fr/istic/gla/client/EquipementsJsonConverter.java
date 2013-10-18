package fr.istic.gla.client;

import com.google.gwt.core.client.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanUtils;

import fr.istic.gla.shared.Equipements;
import fr.istic.gla.shared.EquipementsItf;

public class EquipementsJsonConverter {

	private EquipementsJsonConverter() {
		
	}
	
	private static EquipementsJsonConverter instance = new EquipementsJsonConverter();
	
	
	  // Instantiate the factory
	  fr.istic.gla.shared.MyFactory factory = GWT.create(fr.istic.gla.shared.MyFactory.class);
	  // In non-GWT code, use AutoBeanFactorySource.create(MyFactory.class);

	  public EquipementsItf makeEquipements() {
	    // Construct the AutoBean
	    AutoBean<EquipementsItf> book = factory.equipements();

	    // Return the Equipements interface shim
	    return book.as();
	  }

	  String serializeToJson(Equipements book) {
	    // Retrieve the AutoBean controller
	    AutoBean<EquipementsItf> bean = AutoBeanUtils.getAutoBean(book);

	    return AutoBeanCodex.encode(bean).getPayload();
	  }

	  EquipementsItf deserializeFromJson(String json) {
	    AutoBean<EquipementsItf> bean = AutoBeanCodex.decode(factory, EquipementsItf.class, json);
	    return bean.as();
	  }

	public static EquipementsJsonConverter getInstance() {
		return instance;
	}
}
