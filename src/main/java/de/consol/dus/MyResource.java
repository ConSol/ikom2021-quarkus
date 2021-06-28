package de.consol.dus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public User hello() {
        return User.of("John Doe");
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public User helloWithParameter(@PathParam("name") String name) {
        return User.of(name);
    }
}