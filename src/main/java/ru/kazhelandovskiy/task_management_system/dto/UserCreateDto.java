package ru.kazhelandovskiy.task_management_system.dto;

import lombok.Data;

@Data
public class UserCreateDto {
    private String email;

    private String password;
}
