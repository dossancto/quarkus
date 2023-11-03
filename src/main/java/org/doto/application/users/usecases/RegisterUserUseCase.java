package org.doto.application.users.usecases;

import jakarta.inject.Singleton;
import java.util.ArrayList;
import org.doto.adapters.CryptografyAdapter;
import org.doto.application.users.data.UserRepository;
import org.doto.application.users.entities.UserEntity;
import org.doto.application.users.entities.UserValidator;
import org.doto.domain.exceptions.ValidationFailException;
import org.doto.lib.validations.ValidationUtils;

@Singleton
public class RegisterUserUseCase {
    final UserRepository _userRepository;
    final UserValidator _userValidator;
    final CryptografyAdapter _cryptografy;

    public RegisterUserUseCase(UserRepository userRepository, UserValidator userValidator,
            CryptografyAdapter cryptografy) {
        _userRepository = userRepository;
        _userValidator = userValidator;
        _cryptografy = cryptografy;
    }

    public UserEntity execute(RegisterUserDto userDto) {
        var user = userDto.toModel();

        validContext(user);

        var credentials = _cryptografy.HashPassword(user.password);

        user.setPassword(credentials.hashedPassword());
        user.setSalt(credentials.salt());

        return _userRepository.create(user);
    }

    private void validContext(UserEntity user){
        ValidationUtils.Validate(_userValidator, user, "Fail while validation user");
        assertUniqueEmail(user.email);
    }

    private void assertUniqueEmail(String email){
        if (_userRepository.findByEmail(email).isPresent()) {
            var msg = String.format("Account with email '%s' already exists.", email);
            throw new ValidationFailException(msg, new ArrayList<String>());
        }
    }
}
