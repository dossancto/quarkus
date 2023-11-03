package org.doto.application.todos.usecases;

import jakarta.inject.Singleton;
import java.util.List;
import org.doto.application.todos.data.TodoRepository;
import org.doto.application.todos.entities.TodoEntity;

@Singleton
public class SelectTodoUseCase {
    final TodoRepository _todoRepository;

    public SelectTodoUseCase(TodoRepository todoRepository){
        _todoRepository = todoRepository;
    }

    public List<TodoEntity> completedTodos(boolean completed){
        return _todoRepository.allCompleted(completed);
    }

    public List<TodoEntity> allTodos(){
        return _todoRepository.all();
    }
}
