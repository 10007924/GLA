
package fr.istic.gla.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
public class HomeRessource {

    private List<Person> people = new ArrayList<Person>();

    	
    public HomeRessource() {
        for (int i = 0; i < 20; i++) {
            people.add(new Person());
        }
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Person> list() {
        return people;
    }
    
    @GET @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Person findById(@PathParam("id") String arg0) {
        return people.get(Integer.parseInt(arg0));
    }

    @DELETE @Path("delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Person deleteById(@PathParam("id") String arg0) {
        return people.remove(Integer.parseInt(arg0));
    }

    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
      return "Hello Jersey";
    }
    
}
