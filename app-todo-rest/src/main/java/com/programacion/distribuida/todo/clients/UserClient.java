package com.programacion.distribuida.todo.clients;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://jsonplaceholder.typicode.com")
public interface UserClient {
    @GET
    @Path("/users/{userId}")
    UserDTO getUser(@PathParam("userId") Integer userId);
}

class UserDTO {
    public Integer id;
    public Integer userId;
    public String title;
    public boolean completed;
}

