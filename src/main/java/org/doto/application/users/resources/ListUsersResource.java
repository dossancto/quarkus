package org.doto.application.users.resources;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;
import org.doto.application.users.entities.UserEntity;
import org.doto.application.users.usecases.SelectUserUseCase;


@Path("/account")
public class ListUsersResource {
    final SelectUserUseCase _selectUser;

    public ListUsersResource(SelectUserUseCase selectUser){
        _selectUser = selectUser;
    }
    
    @GET
    @Path("/list")
    public List<UserEntity> listAll(){
        return _selectUser
        .listAll()
        .stream()
        .toList();
    }

}