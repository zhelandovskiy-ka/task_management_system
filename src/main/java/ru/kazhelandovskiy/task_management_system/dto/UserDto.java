package ru.kazhelandovskiy.task_management_system.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;

    private String email;

    private String password;
}
