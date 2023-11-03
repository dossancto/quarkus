package org.doto.application.todos.entities;
import java.util.UUID;

public class TodoEntity {
    public UUID id;
    public String body;
    public boolean completed;

    public TodoEntity(String body){
        this.body = body;

        this.id = UUID.randomUUID();
        this.completed = false;
    }

    public TodoEntity(UUID id, String body, boolean completed){
        this.id = id;
        this.body = body;
        this.completed = completed;
    }
}