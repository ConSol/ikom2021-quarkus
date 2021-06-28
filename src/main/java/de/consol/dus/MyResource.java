package de.consol.dus;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class MyResource {

    private static final Logger logger = LoggerFactory.getLogger(MyResource.class);

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public User createUser(User newUser) {
        logger.info("Received user: {}", newUser);
        return newUser;
    }
}