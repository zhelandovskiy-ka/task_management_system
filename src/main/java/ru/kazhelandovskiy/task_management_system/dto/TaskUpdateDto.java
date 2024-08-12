package ru.kazhelandovskiy.task_management_system.dto;

import lombok.Data;

@Data
public class TaskUpdateDto {
    private Long id;
    private String label;
    private String description;
    private String status;
    private String priority;
    private String author;
    private String performer;
}
