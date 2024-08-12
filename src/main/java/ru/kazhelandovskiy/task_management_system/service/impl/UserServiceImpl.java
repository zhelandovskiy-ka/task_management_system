package ru.kazhelandovskiy.task_management_system.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.kazhelandovskiy.task_management_system.dto.UserDto;
import ru.kazhelandovskiy.task_management_system.exception.UserExistException;
import ru.kazhelandovskiy.task_management_system.exception.UserNotFoundException;
import ru.kazhelandovskiy.task_management_system.mapper.UserMapper;
import ru.kazhelandovskiy.task_management_system.model.UserModel;
import ru.kazhelandovskiy.task_management_system.repository.UserRepository;
import ru.kazhelandovskiy.task_management_system.service.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(UserModel userModel) {
        if (userRepository.existsByEmail(userModel.getEmail()))
            throw new UserExistException();

        return userMapper.modelToDto(userRepository.save(userModel));
    }

    @Override
    public UserModel getByEmailName(String email) {
        return userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
    }

    public UserDetailsService userDetailsService() {
        return this::getByEmailName;
    }

    public UserDto getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        return userMapper.modelToDto(getByEmailName(username));
    }

    @Override
    public boolean userExist(String email) {
        return userRepository.existsByEmail(email);
    }
}
