package de.consol.dus;

import java.util.NoSuchElementException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class MyResource {

    private final UserRepository userRepository;

    public MyResource(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GET
    public Iterable<User> hello() {
        return userRepository.findAll();
    }

    @GET
    @Path("{name}")
    public User helloWithParameter(@PathParam("name") String name) {
        return userRepository.findByUsername(name).orElseThrow(NoSuchElementException::new);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }
}