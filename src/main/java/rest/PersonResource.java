package rest;

import entity.Person;
import facade.Facade;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import facade.Facade;
import java.util.List;
import entity.Person;
import facade.Facade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("person") 
public class PersonResource {
    private final static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final static Facade facade = new Facade();

    @Context
    private UriInfo context;

    public PersonResource() {
    }
    
    @GET
    @Path("complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPerson(@PathParam("id") long id) { 
        Person person = facade.getPerson(id);
        String text = gson.toJson(person);
        return text;     
    }
    
    @GET
    @Path("complete/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons() { 
        List<Person> persons = facade.getPersons();
        String text1 = gson.toJson(persons);
        return text1; 
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String postPerson(String content) {
        Person person = gson.fromJson(content, Person.class);
        if (person == null) {
            return gson.toJson(false);
        }
        facade.createPerson(person);
        return gson.toJson(true);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putPerson(String content) {
        Person person = gson.fromJson(content, Person.class);
        if (person == null) {
            return gson.toJson(false);
        }
        facade.editPerson(person);
        return gson.toJson(true);
    }

    @DELETE
    @Path("complete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String deletePerson(@PathParam("id") long id) {
        Person person = facade.getPerson(id);
        if (person == null) {
            return gson.toJson(false);
        }
        facade.deletePerson(person);
        return gson.toJson(true);
    }
}
