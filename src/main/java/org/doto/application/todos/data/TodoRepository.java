package org.doto.application.todos.data;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.doto.application.todos.entities.TodoEntity;

public interface TodoRepository {
    TodoEntity create(TodoEntity todo);
    TodoEntity update(TodoEntity todo);

    List<TodoEntity> allCompleted(boolean completed);
    List<TodoEntity> all();
    Optional<TodoEntity> findById(UUID id);

    void delete(UUID id);
}

