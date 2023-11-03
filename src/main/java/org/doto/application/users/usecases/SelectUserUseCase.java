package org.doto.application.users.usecases;
import jakarta.inject.Singleton;
import java.util.List;
import org.doto.application.users.data.UserRepository;
import org.doto.application.users.entities.UserEntity;

@Singleton
public class SelectUserUseCase {
    final UserRepository _userRepository;

    public SelectUserUseCase(UserRepository userRepository){
        _userRepository = userRepository;
    }

    public List<UserEntity> listAll(){
        return _userRepository.listAll();
    }
}
