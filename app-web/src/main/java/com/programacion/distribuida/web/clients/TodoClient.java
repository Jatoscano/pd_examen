package com.programacion.distribuida.web.clients;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import java.util.List;

@RegisterRestClient(baseUri = "http://app-todo-rest:8080")
public interface TodoClient {
    @GET
    @Path("/todos")
    List<TodoDTO> listTodos();

    class TodoDTO {
        public Long id;
        public Long userId;
        public String title;
        public boolean completed;
    }
}
