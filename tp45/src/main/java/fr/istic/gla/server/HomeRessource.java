
package fr.istic.gla.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.gla.shared.Home;

/*
 * This class is an example of services class
 */

@Path("/Home")
public class HomeRessource {

	private EntityManager manager;
	 
	
    public HomeRessource() {
         EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		manager = factory.createEntityManager();
    }

 
    @GET @Path("createHome")
    @Produces({ MediaType.APPLICATION_JSON })
    public Long createHome(){

    Home h = new Home();

    EntityTransaction tx = manager.getTransaction();
    tx.begin();
    manager.persist(h);
    tx.commit();

    return h.getId();
    }
    
    @GET @Path("Home/{name}")
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Home> getHome(@PathParam("name") String name){
    CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
    CriteriaQuery<Home> query = criteriaBuilder.createQuery(Home.class);
    Root<Home> from = query.from(Home.class);
    query.select(from).where(from.get("name").in(name));
    return manager.createQuery(query).getResultList();
    }
    
    @GET @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Home findById(@PathParam("id") String arg0) {
        return null;
    }

    @DELETE @Path("delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Home deleteById(@PathParam("id") String arg0) {
        return null;
    }

    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
      return "Hello Jersey";
    }
    
}
