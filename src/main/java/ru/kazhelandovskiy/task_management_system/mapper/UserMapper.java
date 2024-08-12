package ru.kazhelandovskiy.task_management_system.mapper;

import org.mapstruct.Mapper;
import ru.kazhelandovskiy.task_management_system.dto.TaskCreateDto;
import ru.kazhelandovskiy.task_management_system.dto.TaskDto;
import ru.kazhelandovskiy.task_management_system.dto.UserCreateDto;
import ru.kazhelandovskiy.task_management_system.dto.UserDto;
import ru.kazhelandovskiy.task_management_system.model.TaskModel;
import ru.kazhelandovskiy.task_management_system.model.UserModel;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public abstract UserDto modelToDto(UserModel userModel);

    public abstract UserModel dtoToModel(UserDto userDto);

    public abstract UserModel createDtoToModel(UserCreateDto userDto);
    public abstract UserCreateDto modelToCreateDto(UserModel userModel);
}