package ru.kazhelandovskiy.task_management_system;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition
@SpringBootApplication
public class TaskManagementSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaskManagementSystemApplication.class, args);
	}
}
