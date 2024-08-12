package ru.kazhelandovskiy.task_management_system.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.kazhelandovskiy.task_management_system.dto.TaskCreateDto;
import ru.kazhelandovskiy.task_management_system.dto.TaskDto;
import ru.kazhelandovskiy.task_management_system.dto.TaskUpdateDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getAllTasks();

    List<TaskDto> getAllTasksByUser(String user);

    TaskDto createTask(TaskCreateDto taskDto);

    TaskDto editTask(TaskUpdateDto taskDto);

    boolean deleteTask(Long id);

    TaskDto getTaskById(Long id);

    boolean changeStatus(Long id, String status, String user);

    boolean changePerformer(Long id, String performer, String user);

    Page<TaskDto> getTasksByAuthor(String author, Pageable pageable);

    Page<TaskDto> getTaskByPerformer(String performer, Pageable pageable);
}