package org.doto.application.todos.entities;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;
import org.doto.application.users.entities.UserEntity;



@Data
public class TodoListEntity {
    private UUID id;
    private String name;

    private UUID userId;
    private UserEntity user;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}