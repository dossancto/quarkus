package org.doto.infra.repositories.users;

import jakarta.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.doto.application.users.data.UserRepository;
import org.doto.application.users.entities.UserEntity;

class MemoryDb{
    public List<UserEntity> Users = new ArrayList<>();

    public void add(UserEntity user){
        Users.add(user);
    }
}

@Singleton
public class MMUserRepository implements UserRepository {
    MemoryDb memdb = new MemoryDb();

    @Override
    public UserEntity create(UserEntity user){
        memdb.add(user);

        return user;
    }

    @Override
    public Optional<UserEntity> findByEmail(String email){
        return memdb.Users.stream().filter(user -> user.email.equals(email)).findFirst();
    }

    @Override
    public Optional<UserEntity> findById(UUID id){
        return memdb.Users.stream().filter(user -> user.id.equals(id)).findFirst();
    }

    @Override
    public List<UserEntity> listAll(){
        return memdb.Users;
    }
}

