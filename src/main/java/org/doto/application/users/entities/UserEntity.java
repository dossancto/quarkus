package org.doto.application.users.entities;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UserEntity {
    public UUID id;
    public String username;
    public String fullname;
    public String email;
    public String password;
    public String salt;

    public UserEntity(String username, String fullname, String email, String password){
        this.id = UUID.randomUUID();
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }
}

