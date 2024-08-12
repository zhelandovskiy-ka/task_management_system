package ru.kazhelandovskiy.task_management_system.dto;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private Long taskId;
    private String text;
}