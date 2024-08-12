package ru.kazhelandovskiy.task_management_system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kazhelandovskiy.task_management_system.dto.JwtAuthenticationResponse;
import ru.kazhelandovskiy.task_management_system.dto.SignInUpDto;
import ru.kazhelandovskiy.task_management_system.exception.FailedAuthenticationException;
import ru.kazhelandovskiy.task_management_system.exception.UserNotFoundException;
import ru.kazhelandovskiy.task_management_system.mapper.UserMapper;
import ru.kazhelandovskiy.task_management_system.model.UserModel;
import ru.kazhelandovskiy.task_management_system.service.AuthenticationService;
import ru.kazhelandovskiy.task_management_system.service.JwtService;
import ru.kazhelandovskiy.task_management_system.service.UserService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signUp(SignInUpDto signUpDto) {
        UserModel user = new UserModel();
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        userService.createUser(user);

        String token = jwtService.generateToken(user);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse(token);

        if (jwtAuthenticationResponse.getToken().isBlank())
            throw new FailedAuthenticationException();

        return jwtAuthenticationResponse;
    }

    @Override
    public JwtAuthenticationResponse signIn(SignInUpDto signInDto) {
        if (!userService.userExist(signInDto.getEmail()))
            throw new UserNotFoundException();

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(signInDto.getEmail(), signInDto.getPassword());

        try {
            authenticationManager.authenticate(authentication);
        } catch (Exception e) {
            throw new FailedAuthenticationException();
        }

        UserDetails user = userService.userDetailsService().loadUserByUsername(signInDto.getEmail());
        String token = jwtService.generateToken(user);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse(token);

        if (jwtAuthenticationResponse.getToken().isBlank())
            throw new FailedAuthenticationException();

        return jwtAuthenticationResponse;
    }
}
