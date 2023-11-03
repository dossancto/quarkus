package org.doto.application.users.resources;
import org.doto.application.users.entities.UserEntity;

public record RegisterResponseDto(String email, String fullname, String username) {
    public static RegisterResponseDto fromModel(UserEntity user){
        return new RegisterResponseDto(user.getEmail(), user.getFullname(), user.getUsername())
    }
}

