package ru.kazhelandovskiy.task_management_system.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.kazhelandovskiy.task_management_system.dto.TaskCreateDto;
import ru.kazhelandovskiy.task_management_system.dto.TaskDto;
import ru.kazhelandovskiy.task_management_system.service.TaskService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskServiceImplTest {
    @MockBean
    TaskService taskService;

    @Test
    void getAllTasks() {
        TaskDto taskDto = new TaskDto(1L, "Task 1", "Description", "In Progress", "High", "Author", "Performer", null);
        List<TaskDto> list = new ArrayList<>();
        list.add(taskDto);

        Mockito.when(taskService.getAllTasks()).thenReturn(list);
        assertEquals(list.get(0).getLabel(), taskService.getAllTasks().get(0).getLabel());
    }

    @Test
    void getAllTaskById() {
        TaskDto taskDto = new TaskDto(1L, "Task 1", "Description", "In Progress", "High", "Author", "Performer", null);
        Mockito.when(taskService.getTaskById(1L)).thenReturn(taskDto);
        assertEquals(taskDto.getLabel(), taskService.getTaskById(1L).getLabel());
    }

    @Test
    void createTask() {
        TaskDto taskDto = new TaskDto(1L, "Task 1", "Description", "In Progress", "High", "Author", "Performer", null);
        TaskCreateDto taskCreateDto = new TaskCreateDto("Task 1", "Description", "In Progress", "High", "Author", "Performer");

        Mockito.when(taskService.createTask(taskCreateDto)).thenReturn(taskDto);
        assertEquals(taskDto.getLabel(), taskService.createTask(taskCreateDto).getLabel());
    }
}