package org.doto.application.todos.usecases;
import jakarta.inject.Singleton;
import java.time.LocalDateTime;
import org.doto.application.todos.data.TodoListRepository;
import org.doto.application.todos.entities.TodoListEntity;

@Singleton
public class CreateTodoListUseCase {
    final TodoListRepository _listRepository;

    public CreateTodoListUseCase(TodoListRepository listRepository){
        _listRepository = listRepository;
    }

    public TodoListEntity execute(CreateTodoListDto listDto){
        var list = listDto.toModel();

        list.setCreatedAt(LocalDateTime.now());
        list.setUpdatedAt(LocalDateTime.now());

        return _listRepository.create(list);
    }
}