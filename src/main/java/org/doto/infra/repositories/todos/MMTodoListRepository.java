package org.doto.infra.repositories.todos;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;
import org.doto.application.todos.data.TodoListRepository;
import org.doto.application.todos.entities.TodoListEntity;


@ApplicationScoped
public class MMTodoListRepository implements TodoListRepository, PanacheRepositoryBase<TodoListEntity, UUID> {
    @Override
    public TodoListEntity create(TodoListEntity list) {
        this.persist(list);
        return list;
    }
}
