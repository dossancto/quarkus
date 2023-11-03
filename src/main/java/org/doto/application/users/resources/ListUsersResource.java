package org.doto.application.users.resources;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;
import org.doto.application.users.usecases.SelectUserUseCase;

@Path("/account")
public class ListUsersResource {
    final SelectUserUseCase _selectUser;

    public ListUsersResource(SelectUserUseCase selectUser){
        _selectUser = selectUser;
    }
    
    @GET
    @Path("/list")
    public List<RegisterResponseDto> listAll(){
        return _selectUser
        .listAll()
        .stream()
        .map(u ->
            new RegisterResponseDto(u.getEmail(), u.getFullname(), u.getUsername())
        )
        .toList();
    }

}