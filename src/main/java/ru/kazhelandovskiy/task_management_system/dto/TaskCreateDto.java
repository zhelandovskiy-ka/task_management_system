package ru.kazhelandovskiy.task_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreateDto {
    private String label;
    private String description;
    private String status;
    private String priority;
    private String author;
    private String performer;
}
