package ru.kazhelandovskiy.task_management_system.service;

import ru.kazhelandovskiy.task_management_system.dto.CommentCreateDto;
import ru.kazhelandovskiy.task_management_system.dto.CommentDto;

public interface CommentService {
    CommentDto addCommentToTask(CommentCreateDto commentCreateDto);
}
