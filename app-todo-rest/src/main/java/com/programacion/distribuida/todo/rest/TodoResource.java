package com.programacion.distribuida.todo.rest;

import com.programacion.distribuida.todo.db.Todo;
import com.programacion.distribuida.todo.repo.TodoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {
    @Inject
    TodoRepository todoRepository;

    @GET
    public List<Todo> list() {
        return todoRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Todo get(@PathParam("id") Long id) {
        return todoRepository.findById(id);
    }

    @POST
    @Transactional
    public Response create(Todo todo) {
        todoRepository.persist(todo);
        return Response.status(Response.Status.CREATED).entity(todo).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Todo todo) {
        Todo entity = todoRepository.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.setTitle(todo.getTitle());
        entity.setCompleted(todo.isCompleted());
        entity.setUserId(todo.getUserId());
        return Response.ok(entity).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = todoRepository.deleteById(id);
        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}

