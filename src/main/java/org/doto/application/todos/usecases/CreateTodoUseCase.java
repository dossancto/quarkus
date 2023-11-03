package org.doto.application.todos.usecases;
import jakarta.inject.Singleton;
import org.doto.application.todos.data.TodoRepository;
import org.doto.application.todos.entities.TodoEntity;

@Singleton
public class CreateTodoUseCase {
    final TodoRepository _todoRepository;

    public CreateTodoUseCase(TodoRepository todoRepository){
        _todoRepository = todoRepository;
    }

    public TodoEntity execute(CreateTodoDto todoDto)
    {
        var todo = new TodoEntity(todoDto.body());

        return _todoRepository.create(todo);
    }
}