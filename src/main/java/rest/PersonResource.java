package rest;

import com.google.gson.Gson;
import entity.Person;
import facade.Facade;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("person") 
public class PersonResource {
    private static Gson gson = new Gson(); 
    private final static Facade facade = new Facade();

    @Context
    private UriInfo context;

    public PersonResource() {
    }
    
    @GET
    @Path("/api/person/complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPerson(@PathParam("id") long id) { 
        Person person = facade.getPerson(id);
        String text = gson.toJson(person);
        return text;     
    }
    
    @GET
    @Path("/api/person/complete/{all}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons() { 
        List<Person> persons = facade.getPersons();
        String text1 = gson.toJson(persons);
        return text1; 
    }
    
    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
