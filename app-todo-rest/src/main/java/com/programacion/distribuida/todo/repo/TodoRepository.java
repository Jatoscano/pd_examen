package com.programacion.distribuida.todo.repo;


import com.programacion.distribuida.todo.db.Todo;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
@ApplicationScoped
public class TodoRepository implements PanacheRepositoryBase<Todo, Integer> {

    public List<Todo> findByTitle(String title) {
        String query = "SELECT o.title FROM Todo o WHERE o.title LIKE :title";
        return this.list(query, title);
    }

    public Optional<Todo> update(Integer id, Todo todo) {
        var obj = this.findByIdOptional(id);
        if (obj.isEmpty()) {
            return Optional.empty();
        }

        var authorObj = obj.get();
        authorObj.setTitle(todo.getTitle());
        return Optional.of(authorObj);
    }
}