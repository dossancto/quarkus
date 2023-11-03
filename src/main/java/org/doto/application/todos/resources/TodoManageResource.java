package org.doto.application.todos.resources;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.UUID;
import org.doto.application.todos.entities.TodoEntity;
import org.doto.application.todos.usecases.CompleteTodoUseCase;
import org.doto.application.todos.usecases.CreateTodoDto;
import org.doto.application.todos.usecases.CreateTodoUseCase;


@Path("/todos")
public class TodoManageResource {
    final CreateTodoUseCase _createTodo;
    final CompleteTodoUseCase _completeTodo;

    public TodoManageResource(CreateTodoUseCase createTodo, CompleteTodoUseCase completeTodo){
        _createTodo = createTodo;
        _completeTodo = completeTodo;
    }

    @GET
    @Path("/create/{content}")
    public TodoEntity createTodo(String content){
        var data = new CreateTodoDto(content);
        return _createTodo.execute(data);
    }

    @GET
    @Path("/complete/{id}")
    public TodoEntity completeTodo(UUID id){
        return _completeTodo.execute(id, true);
    }

    @GET
    @Path("/uncomplete/{id}")
    public TodoEntity unCompleteTodo(UUID id){
        return _completeTodo.execute(id, false);
    }
    
}
