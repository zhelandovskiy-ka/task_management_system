package ru.kazhelandovskiy.task_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler({
            FailedAuthenticationException.class,
            FailedRegistrationException.class,
            UserExistException.class
    })
    public ResponseEntity<Response> authException(RuntimeException e) {
        Response response = new Response(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    public ResponseEntity<Response> validException(BindException e) {
        Response response = new Response(e.getMessage());

        if (e.getMessage().contains("Email is not valid"))
            response.setMessage("Email is not valid");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({TaskNotFoundException.class, UserNotFoundException.class})
    public ResponseEntity<Response> notFoundException(RuntimeException e) {
        Response response = new Response(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
