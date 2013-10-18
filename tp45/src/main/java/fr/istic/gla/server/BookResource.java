
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

import fr.istic.gla.shared.Book;
import fr.istic.gla.shared.BookItf;

/*
 * This class is an example of services class
 */

@Path("/books")
public class BookResource {

    private List<Book> books = new ArrayList<Book>();

    	
    public BookResource() {
        for (int i = 0; i < 20; i++) {
            books.add(new Book(i, "Title " + i, "Author " + i, new Double(Math.random()*20).intValue()));
        }
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Book> list() {
        return books;
    }
    
    @GET @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public BookItf findById(@PathParam("id") String arg0) {
        return books.get(Integer.parseInt(arg0));
    }

    @DELETE @Path("delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public BookItf deleteById(@PathParam("id") String arg0) {
        return books.remove(Integer.parseInt(arg0));
    }

    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
      return "Hello Jersey";
    }
    
}
