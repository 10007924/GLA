
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

import fr.istic.gla.shared.Equipements;

/*
 * This class is an example of services class
 */

@Path("/Equipementss")
public class EquipementsRessource {

	private EntityManager manager;
	 
	
    public EquipementsRessource() {
         EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		manager = factory.createEntityManager();
    }

 
    @GET @Path("createEquipements/{name}/{lastname}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Long createEquipements(){

    Equipements p = new Equipements();

    EntityTransaction tx = manager.getTransaction();
    tx.begin();
    manager.persist(p);
    tx.commit();

    return p.getId();
    }
    
    @GET @Path("Equipements/{name}")
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Equipements> getEquipements(@PathParam("name") String name){
    CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
    CriteriaQuery<Equipements> query = criteriaBuilder.createQuery(Equipements.class);
    Root<Equipements> from = query.from(Equipements.class);
    query.select(from).where(from.get("name").in(name));
    return manager.createQuery(query).getResultList();
    }
    
    @GET @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Equipements findById(@PathParam("id") String arg0) {
        return null;
    }

    @DELETE @Path("delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Equipements deleteById(@PathParam("id") String arg0) {
        return null;
    }

    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
      return "Hello Jersey";
    }
    
}
