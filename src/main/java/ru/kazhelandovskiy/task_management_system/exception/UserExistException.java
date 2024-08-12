package ru.kazhelandovskiy.task_management_system.exception;

public class UserExistException extends RuntimeException {
    public UserExistException() {
        super("User already exist");
    }
}
