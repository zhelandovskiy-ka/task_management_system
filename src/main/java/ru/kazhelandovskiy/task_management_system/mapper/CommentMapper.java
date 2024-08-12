package ru.kazhelandovskiy.task_management_system.mapper;

import org.mapstruct.Mapper;
import ru.kazhelandovskiy.task_management_system.dto.CommentDto;
import ru.kazhelandovskiy.task_management_system.dto.TaskCreateDto;
import ru.kazhelandovskiy.task_management_system.dto.TaskDto;
import ru.kazhelandovskiy.task_management_system.model.CommentModel;
import ru.kazhelandovskiy.task_management_system.model.TaskModel;

@Mapper(componentModel = "spring")
public abstract class CommentMapper {
    public abstract CommentDto modelToDto(CommentModel commentModel);

    public abstract CommentModel dtoToModel(CommentDto commentDto);
}