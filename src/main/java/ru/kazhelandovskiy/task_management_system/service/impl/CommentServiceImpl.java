package ru.kazhelandovskiy.task_management_system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kazhelandovskiy.task_management_system.dto.CommentCreateDto;
import ru.kazhelandovskiy.task_management_system.dto.CommentDto;
import ru.kazhelandovskiy.task_management_system.exception.TaskNotFoundException;
import ru.kazhelandovskiy.task_management_system.mapper.CommentMapper;
import ru.kazhelandovskiy.task_management_system.model.CommentModel;
import ru.kazhelandovskiy.task_management_system.model.TaskModel;
import ru.kazhelandovskiy.task_management_system.repository.CommentRepository;
import ru.kazhelandovskiy.task_management_system.repository.TaskRepository;
import ru.kazhelandovskiy.task_management_system.service.CommentService;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;
    private final CommentMapper commentMapper;

    @Override
    public CommentDto addCommentToTask(CommentCreateDto commentCreateDto) {
        TaskModel taskModel = taskRepository.findById(commentCreateDto.getTaskId()).orElse(null);

        if (taskModel != null) {
            CommentModel commentModel = new CommentModel();
            commentModel.setTaskId(commentCreateDto.getTaskId());
            commentModel.setText(commentCreateDto.getText());

            return commentMapper.modelToDto(commentRepository.save(commentModel));
        } else
            throw new TaskNotFoundException();
    }
}