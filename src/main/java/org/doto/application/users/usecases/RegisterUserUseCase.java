package org.doto.application.users.usecases;
import br.com.fluentvalidator.context.ValidationResult;
import jakarta.inject.Singleton;
import java.util.Collection;
import org.doto.application.users.data.UserRepository;
import org.doto.application.users.entities.UserEntity;
import org.doto.application.users.entities.UserValidator;
import org.doto.domain.exceptions.ValidationFailException;

@Singleton
public class RegisterUserUseCase {
    final UserRepository _userRepository;
    final UserValidator _userValidator;

    public RegisterUserUseCase(UserRepository userRepository, UserValidator userValidator){
        _userRepository = userRepository;
        _userValidator = userValidator;
    }

    public UserEntity execute(RegisterUserDto userDto) throws ValidationFailException
    {
        var user = userDto.toModel();
        
        final ValidationResult result = _userValidator.validate(user);

        if(!result.isValid()){
            throw new ValidationFailException("Fail while validation User", result.getErrors());
        }

        return _userRepository.create(user);
    }
}
