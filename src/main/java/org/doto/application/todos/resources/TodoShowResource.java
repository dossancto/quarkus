package org.doto.application.todos.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;
import org.doto.application.todos.entities.TodoEntity;
import org.doto.application.todos.usecases.SelectTodoUseCase;


@Path("/todos")
public class TodoShowResource {
    final SelectTodoUseCase _selectTodo;

    public TodoShowResource(SelectTodoUseCase selectTodo){
        _selectTodo = selectTodo;
    }

    @GET
    @Path("/list")
    public List<TodoEntity> listAll(){
        return _selectTodo.allTodos();
    }

    @GET
    @Path("/list/completed")
    public List<TodoEntity> listCompleted(){
        return _selectTodo.completedTodos(true);
    }

    @GET
    @Path("/list/not-completed")
    public List<TodoEntity> listNotCompleted(){
        return _selectTodo.completedTodos(false);
    }
}
