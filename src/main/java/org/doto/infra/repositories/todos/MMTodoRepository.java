package org.doto.infra.repositories.todos;

import jakarta.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;
import org.doto.application.todos.data.TodoRepository;
import org.doto.application.todos.entities.TodoEntity;
import org.doto.domain.exceptions.NotFoundException;

class TempDb{
    public final List<TodoEntity> todos = new ArrayList<>();

    public void add(TodoEntity t){
        todos.add(t);
    }
}

@Singleton
public class MMTodoRepository implements TodoRepository {
    Logger logger = Logger.getLogger(getClass().getName());
    TempDb db = new TempDb();

    @Override
    public TodoEntity create(TodoEntity todo){
        db.add(todo);
        return todo;
    }

    @Override
    public TodoEntity update(TodoEntity todo){
        var t = findById(todo.id).orElseThrow(() -> new NotFoundException(String.format("todo with id '%s' not found", todo.id)));
        var i = db.todos.indexOf(t);

        db.todos.set(i, todo);

        return todo;
    }

    @Override
    public List<TodoEntity> allCompleted(boolean completed)
    {
        return all()
        .stream()
        .filter(todo -> todo.completed == completed)
        .toList();
    }

    @Override
    public List<TodoEntity> all()
    {
        return db.todos;
    }

    @Override
    public Optional<TodoEntity> findById(UUID id)
    {
        return all()
        .stream()
        .filter(todo -> todo.id.equals(id))
        .findAny();
    }

    @Override
    public void delete(UUID id){
        var t = findById(id);
        if(t.isEmpty()){ return; }

        db.todos.remove(t.get());
    }
}

