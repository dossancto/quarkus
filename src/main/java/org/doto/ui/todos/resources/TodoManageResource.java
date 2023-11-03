package org.doto.ui.todos.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import java.util.ArrayList;
import java.util.UUID;
import org.doto.application.todos.entities.TodoEntity;
import org.doto.application.todos.entities.TodoListEntity;
import org.doto.application.todos.usecases.CompleteTodoUseCase;
import org.doto.application.todos.usecases.CreateTodoDto;
import org.doto.application.todos.usecases.CreateTodoListDto;
import org.doto.application.todos.usecases.CreateTodoListUseCase;
import org.doto.application.todos.usecases.CreateTodoUseCase;
import org.doto.domain.exceptions.ValidationFailException;


@Path("/todos")
public class TodoManageResource {
    final CreateTodoUseCase _createTodo;
    final CompleteTodoUseCase _completeTodo;
    final CreateTodoListUseCase _todoListUseCase;

    public TodoManageResource(CreateTodoUseCase createTodo, CompleteTodoUseCase completeTodo, CreateTodoListUseCase todoListUseCase){
        _createTodo = createTodo;
        _completeTodo = completeTodo;
        _todoListUseCase = todoListUseCase;
    }

    @POST
    @Path("/create")
    public TodoEntity createTodo(CreateTodoDto content){
        if(content == null){ throw new ValidationFailException("Empty request body", new ArrayList<String>()); }

        return _createTodo.execute(content);
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
    
    @POST
    @Path("/create-list")
    public TodoListEntity createList(CreateTodoListDto content){
        if(content == null){
            throw new ValidationFailException("Empty request body", new ArrayList<String>());
        }
        return _todoListUseCase.execute(content);
    }

}
