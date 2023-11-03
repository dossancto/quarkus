package org.doto.application.users.resources;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.doto.application.users.usecases.RegisterUserDto;
import org.doto.application.users.usecases.RegisterUserUseCase;



@Path("/account")
public class UserRegisterResource {
    final RegisterUserUseCase _registerUser;

    public UserRegisterResource(RegisterUserUseCase registerUser){
        _registerUser = registerUser;
    }

    @POST
    @Path("/register")
    public RegisterResponseDto registerUser(RegisterUserDto userDto){
        var user = _registerUser.execute(userDto);

        return new RegisterResponseDto(user.email, user.fullname, user.username);
    }
}
