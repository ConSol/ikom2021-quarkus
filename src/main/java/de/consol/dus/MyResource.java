package de.consol.dus;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class MyResource {

    @GET
    public List<User> hello() {
        return List.of(
            User.of("John Doe"),
            User.of("Jane Doe"));
    }

    @GET
    @Path("{name}")
    public User helloWithParameter(@PathParam("name") String name) {
        return User.of(name);
    }
}