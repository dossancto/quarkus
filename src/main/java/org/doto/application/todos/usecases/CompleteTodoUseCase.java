package org.doto.application.todos.usecases;

import jakarta.inject.Singleton;
import java.util.UUID;
import org.doto.application.todos.data.TodoRepository;
import org.doto.application.todos.entities.TodoEntity;

@Singleton
public class CompleteTodoUseCase {
    final TodoRepository _todoRepository;

    public CompleteTodoUseCase(TodoRepository todoRepository){
        _todoRepository = todoRepository;
    }

    public TodoEntity execute(UUID todoId){ return execute(todoId, true); }

    public TodoEntity execute(UUID todoId, boolean completed)
    {
        var todo = _todoRepository.findById(todoId).orElseThrow();

        todo.completed = completed;

        return _todoRepository.update(todo);
    }
}