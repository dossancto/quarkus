package org.doto.infra.repositories.todos;

import jakarta.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.doto.application.todos.data.TodoListRepository;
import org.doto.application.todos.entities.TodoListEntity;
import org.doto.application.users.data.UserRepository;
import org.doto.infra.repositories.users.MMUserRepository;
import org.doto.domain.exceptions.NotFoundException;

class InMemoryDatabase{
    public List<TodoListEntity> TodoLists = new ArrayList<>();

    public void add(TodoListEntity list){
        TodoLists.add(list);
    }
}

@Singleton
public class MMTodoListRepository implements TodoListRepository {
    InMemoryDatabase database = new InMemoryDatabase();

    final UserRepository _userRepository;

    public MMTodoListRepository(UserRepository userRepository){
        _userRepository = userRepository;
    }

    @Override
    public TodoListEntity create(TodoListEntity list) {
        list.setId(UUID.randomUUID());

        if(!_userRepository.findById(list.getUserId()).isPresent()){
            throw new NotFoundException("Can't find user.");
        }

        database.add(list);

        return list;
    }
}