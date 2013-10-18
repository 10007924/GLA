package fr.istic.gla.client;

import com.google.gwt.core.client.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanUtils;

import fr.istic.gla.shared.Home;
import fr.istic.gla.shared.HomeItf;

public class HomeJsonConverter {

	private HomeJsonConverter() {
		
	}
	
	private static HomeJsonConverter instance = new HomeJsonConverter();
	
	
	  // Instantiate the factory
	  fr.istic.gla.shared.MyFactory factory = GWT.create(fr.istic.gla.shared.MyFactory.class);
	  // In non-GWT code, use AutoBeanFactorySource.create(MyFactory.class);

	  public HomeItf makeHome() {
	    // Construct the AutoBean
	    AutoBean<HomeItf> Home = factory.home();

	    // Return the Home interface shim
	    return Home.as();
	  }

	  String serializeToJson(Home Home) {
	    // Retrieve the AutoBean controller
	    AutoBean<HomeItf> bean = AutoBeanUtils.getAutoBean(Home);

	    return AutoBeanCodex.encode(bean).getPayload();
	  }

	  HomeItf deserializeFromJson(String json) {
	    AutoBean<HomeItf> bean = AutoBeanCodex.decode(factory, HomeItf.class, json);
	    return bean.as();
	  }

	public static HomeJsonConverter getInstance() {
		return instance;
	}
}
