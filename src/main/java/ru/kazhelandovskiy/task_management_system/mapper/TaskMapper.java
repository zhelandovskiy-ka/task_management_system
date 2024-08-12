package ru.kazhelandovskiy.task_management_system.mapper;

import org.mapstruct.Mapper;
import ru.kazhelandovskiy.task_management_system.dto.TaskCreateDto;
import ru.kazhelandovskiy.task_management_system.dto.TaskDto;
import ru.kazhelandovskiy.task_management_system.model.TaskModel;

@Mapper(componentModel = "spring")
public abstract class TaskMapper {
    public abstract TaskDto modelToDto(TaskModel taskModel);

    public abstract TaskModel dtoToModel(TaskDto taskDto);

    public abstract TaskModel createDtoToModel(TaskCreateDto taskDto);
}