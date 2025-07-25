package com.programacion.distribuida.web.clients;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://jsonplaceholder.typicode.com")
public interface UserClient {
    @GET
    @Path("/users/{userId}")
    UserDTO getUser(@PathParam("userId") Integer userId);

    class UserDTO {
        public Integer id;
        public String name;
        public String username;
        public String email;
    }
}
