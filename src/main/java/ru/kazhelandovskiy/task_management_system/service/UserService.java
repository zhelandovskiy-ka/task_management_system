package ru.kazhelandovskiy.task_management_system.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kazhelandovskiy.task_management_system.dto.UserDto;
import ru.kazhelandovskiy.task_management_system.model.UserModel;

public interface UserService {
    UserDto createUser(UserModel userModel);

    UserModel getByEmailName(String username);

    UserDetailsService userDetailsService();

    UserDto getCurrentUser();

    boolean userExist(String email);
}
