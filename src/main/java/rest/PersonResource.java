package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import facade.Facade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

@Path("person")
public class PersonResource {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static Facade facade = new Facade();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public PersonResource() {
    }

    /**
     * Retrieves representation of an instance of entity.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
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
        /*Person p1 = new Person("bob@gmail.com", "Bob", "Jensen");
        p1 = gson.fromJson(content, Person.class);
        return gson.toJson(p1);
/*        return content;
        return "true\n";*/
    }
}
