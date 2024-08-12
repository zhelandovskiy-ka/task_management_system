package ru.kazhelandovskiy.task_management_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignInUpDto {
    @Email(message = "Email is not valid")
    @Size(min = 5, max = 255, message = "Size must been between 5 and 255")
    @NotBlank
    private String email;

    @Size(min = 8, max = 255, message = "Size must been between 8 and 255")
    @NotBlank
    private String password;
}
