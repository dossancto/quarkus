package org.doto.application.todos.entities;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.doto.application.users.entities.UserEntity;



@Data
@Entity
@Table(name = "todos")
public class TodoListEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    private UUID userId;
    private UserEntity user;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}