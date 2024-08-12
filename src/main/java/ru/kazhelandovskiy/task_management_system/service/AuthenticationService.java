package ru.kazhelandovskiy.task_management_system.service;

import ru.kazhelandovskiy.task_management_system.dto.JwtAuthenticationResponse;
import ru.kazhelandovskiy.task_management_system.dto.SignInUpDto;

public interface AuthenticationService {
    JwtAuthenticationResponse signUp(SignInUpDto signUpDto);

    JwtAuthenticationResponse signIn(SignInUpDto signInDto);
}
