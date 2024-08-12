package ru.kazhelandovskiy.task_management_system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kazhelandovskiy.task_management_system.dto.JwtAuthenticationResponse;
import ru.kazhelandovskiy.task_management_system.dto.SignInUpDto;
import ru.kazhelandovskiy.task_management_system.dto.TaskDto;
import ru.kazhelandovskiy.task_management_system.service.AuthenticationService;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authenticationService;

    @Operation(
            summary = "Зарегистрировать нового пользователя",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Пользователь зарегистрирован",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = JwtAuthenticationResponse.class))
                                    )
                            }
                    ),
                    @ApiResponse(responseCode = "400", description = "Некорректный запрос"),
                    @ApiResponse(responseCode = "404", description = "Объект не найден"),
                    @ApiResponse(responseCode = "500", description = "Внутрення ошибка сервера")
            }
    )
    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignInUpDto signUpDto) {
        return authenticationService.signUp(signUpDto);
    }

    @Operation(
            summary = "Выполнить аутентификацию",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Аутентификация выполнена",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = JwtAuthenticationResponse.class))
                                    )
                            }
                    ),
                    @ApiResponse(responseCode = "400", description = "Некорректный запрос"),
                    @ApiResponse(responseCode = "404", description = "Объект не найден"),
                    @ApiResponse(responseCode = "500", description = "Внутрення ошибка сервера")
            }
    )
    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInUpDto signInDto) {
        return authenticationService.signIn(signInDto);
    }
}
