package ru.kazhelandovskiy.task_management_system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FailedRegistrationException extends RuntimeException {
    public FailedRegistrationException() {
        super("Registration failed");
    }
}
