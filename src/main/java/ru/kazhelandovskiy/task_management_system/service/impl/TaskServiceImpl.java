package ru.kazhelandovskiy.task_management_system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.kazhelandovskiy.task_management_system.dto.TaskCreateDto;
import ru.kazhelandovskiy.task_management_system.dto.TaskDto;
import ru.kazhelandovskiy.task_management_system.dto.TaskUpdateDto;
import ru.kazhelandovskiy.task_management_system.exception.TaskNotFoundException;
import ru.kazhelandovskiy.task_management_system.mapper.TaskMapper;
import ru.kazhelandovskiy.task_management_system.model.TaskModel;
import ru.kazhelandovskiy.task_management_system.repository.TaskRepository;
import ru.kazhelandovskiy.task_management_system.service.TaskService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::modelToDto)
                .toList();
    }

    @Override
    public List<TaskDto> getAllTasksByUser(String user) {
        return taskRepository.findAll()
                .stream()
                .filter(task -> task.getAuthor().equals(user))
                .map(taskMapper::modelToDto)
                .toList();
    }

    @Override
    public TaskDto createTask(TaskCreateDto taskDto) {
        TaskModel dtoToModel = taskMapper.createDtoToModel(taskDto);
        TaskModel savedModel = taskRepository.save(dtoToModel);

        return taskMapper.modelToDto(savedModel);
    }

    @Override
    public TaskDto editTask(TaskUpdateDto taskDto) {
        TaskModel taskModel = taskRepository.findById(taskDto.getId())
                .orElseThrow(() -> new RuntimeException("task not found"));

        if (taskDto.getLabel() != null)
            taskModel.setLabel(taskDto.getLabel());
        if (taskDto.getDescription() != null)
            taskModel.setDescription(taskDto.getDescription());
        if (taskDto.getStatus() != null)
            taskModel.setStatus(taskDto.getStatus());
        if (taskDto.getPriority() != null)
            taskModel.setPriority(taskDto.getPriority());
        if (taskDto.getPerformer() != null)
            taskModel.setPerformer(taskDto.getPerformer());
        if (taskDto.getAuthor() != null)
            taskModel.setAuthor(taskDto.getAuthor());

        return taskMapper.modelToDto(taskRepository.save(taskModel));
    }

    @Override
    public boolean deleteTask(Long id) {
        Optional<TaskModel> taskModel = taskRepository.findById(id);
        if (taskModel.isPresent()) {
            taskRepository.delete(taskModel.get());
            return true;
        }

        throw new TaskNotFoundException();
    }

    @Override
    public TaskDto getTaskById(Long id) {
        return taskMapper.modelToDto(getById(id));
    }

    @Override
    public boolean changeStatus(Long id, String status, String user) {
        TaskModel taskModel = getById(id);
        if (taskModel != null
                && (taskModel.getPerformer().equals(user) || taskModel.getAuthor().equals(user))) {
            taskModel.setStatus(status);
            taskRepository.save(taskModel);

            return true;
        }

        return false;
    }

    @Override
    public boolean changePerformer(Long id, String performer, String user) {
        TaskModel taskModel = getById(id);
        if (taskModel != null && taskModel.getAuthor().equals(user)) {
            taskModel.setPerformer(performer);
            taskRepository.save(taskModel);

            return true;
        }

        return false;
    }

    @Override
    public Page<TaskDto> getTasksByAuthor(String author, Pageable pageable) {
        return taskRepository.findByAuthor(author, pageable).map(taskMapper::modelToDto);
    }

    @Override
    public Page<TaskDto> getTaskByPerformer(String performer, Pageable pageable) {
        return taskRepository.findByPerformer(performer, pageable).map(taskMapper::modelToDto);
    }

    private TaskModel getById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
}
