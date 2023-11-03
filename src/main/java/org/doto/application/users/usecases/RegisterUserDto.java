package org.doto.application.users.usecases;
import org.doto.application.users.entities.UserEntity;

public record RegisterUserDto(String fullname, String username, String email, String password) {
    public UserEntity toModel(){
        return new UserEntity(username(), fullname(), email(), password());
    }
}
