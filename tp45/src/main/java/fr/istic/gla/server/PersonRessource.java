
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

import fr.istic.gla.shared.Person;

/*
 * This class is an example of services class
 */

@Path("/Persons")
public class PersonRessource {
	private EntityManager manager;
 
    	
    public PersonRessource() {
         EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		manager = factory.createEntityManager();
    }

 
    @GET @Path("createperson/{name}/{lastname}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Long createPerson(@PathParam("name") String name,@PathParam("lastname") String lastname){

    Person p = new Person(name,lastname);

    EntityTransaction tx = manager.getTransaction();
    tx.begin();
    manager.persist(p);
    tx.commit();

    return p.getId();
    }
    
    @GET @Path("person/{name}")
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Person> getPerson(@PathParam("name") String name){
    CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
    CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
    Root<Person> from = query.from(Person.class);
    query.select(from).where(from.get("name").in(name));
    return manager.createQuery(query).getResultList();
    }
    
    @GET @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Person findById(@PathParam("id") String arg0) {
        return null;
    }

    @DELETE @Path("delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Person deleteById(@PathParam("id") String arg0) {
        return null;
    }

    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
      return "Hello Jersey";
    }
    
}
