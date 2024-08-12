package ru.kazhelandovskiy.task_management_system.dto;

import lombok.Data;

@Data
public class CommentCreateDto {
    private Long taskId;
    private String text;
}