package com.programacion.distribuida.web.rest;

import com.programacion.distribuida.web.clients.TodoClient;
import com.programacion.distribuida.web.clients.UserClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
public class TodoWebResource {
    @Inject
    TodoClient todoClient;
    @Inject
    UserClient userClient;

    @GET
    public List<TodoWithUser> listTodosWithUser() {
        return todoClient.listTodos().stream()
            .map(todo -> {
                var user = userClient.getUser(todo.userId);
                return new TodoWithUser(todo.id, todo.title, todo.completed, user.name);
            })
            .collect(Collectors.toList());
    }

    public static class TodoWithUser {
        public Long id;
        public String title;
        public boolean completed;
        public String userName;
        public TodoWithUser(Long id, String title, boolean completed, String userName) {
            this.id = id;
            this.title = title;
            this.completed = completed;
            this.userName = userName;
        }
    }
}

