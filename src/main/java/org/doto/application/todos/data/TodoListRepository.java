package org.doto.application.todos.data;

import org.doto.application.todos.entities.TodoListEntity;

public interface TodoListRepository {
    TodoListEntity create(TodoListEntity list);
}