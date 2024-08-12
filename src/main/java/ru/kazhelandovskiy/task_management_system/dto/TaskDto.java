package ru.kazhelandovskiy.task_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;
    private String label;
    private String description;
    private String status;
    private String priority;
    private String author;
    private String performer;
    private List<CommentDto> commentsList;
}
