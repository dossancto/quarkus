package org.doto.application.users.data;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.doto.application.users.entities.UserEntity;

public interface UserRepository {
    UserEntity create(UserEntity user);

    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findById(UUID id);
    List<UserEntity> listAll();
}

