package ru.kazhelandovskiy.task_management_system.exception;

public class FailedAuthenticationException extends RuntimeException {
    public FailedAuthenticationException() {
        super("Authorization failed");
    }
}
