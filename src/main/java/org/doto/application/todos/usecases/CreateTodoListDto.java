package org.doto.application.todos.usecases;
import java.util.UUID;
import org.doto.application.todos.entities.TodoListEntity;


public record CreateTodoListDto(String name, UUID userId) {
    public TodoListEntity toModel(){
        var list = new TodoListEntity();

        list.setName(name());
        list.setUserId(userId());

        return list;
    }
}