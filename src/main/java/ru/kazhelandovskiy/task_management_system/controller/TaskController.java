package ru.kazhelandovskiy.task_management_system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.kazhelandovskiy.task_management_system.dto.TaskCreateDto;
import ru.kazhelandovskiy.task_management_system.dto.TaskDto;
import ru.kazhelandovskiy.task_management_system.dto.TaskUpdateDto;
import ru.kazhelandovskiy.task_management_system.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService taskService;

    @Operation(
            summary = "Получить все задачи",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Задачи получены",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = TaskDto.class))
                                    )

                            }
                    ),
                    @ApiResponse(responseCode = "400", description = "Некорректный запрос"),
                    @ApiResponse(responseCode = "404", description = "Объект не найден"),
                    @ApiResponse(responseCode = "500", description = "Внутрення ошибка сервера")
            }
    )
    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @Operation(
            summary = "Получить задачу по id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Задача получена",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = TaskDto.class))
                                    )

                            }
                    ),
                    @ApiResponse(responseCode = "400", description = "Некорректный запрос"),
                    @ApiResponse(responseCode = "404", description = "Объект не найден"),
                    @ApiResponse(responseCode = "500", description = "Внутрення ошибка сервера")
            }
    )
    @GetMapping("/{id}")
    public TaskDto getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @Operation(
            summary = "Создать задачу",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Задача создана",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = TaskDto.class))
                                    )

                            }
                    ),
                    @ApiResponse(responseCode = "400", description = "Некорректный запрос"),
                    @ApiResponse(responseCode = "404", description = "Объект не найден"),
                    @ApiResponse(responseCode = "500", description = "Внутрення ошибка сервера")
            }
    )
    @PostMapping
    public TaskDto createTask(@RequestBody TaskCreateDto taskDto) {
        return taskService.createTask(taskDto);
    }

    @Operation(
            summary = "Изменить задачу",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Задача изменена",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = TaskDto.class))
                                    )

                            }
                    ),
                    @ApiResponse(responseCode = "400", description = "Некорректный запрос"),
                    @ApiResponse(responseCode = "404", description = "Объект не найден"),
                    @ApiResponse(responseCode = "500", description = "Внутрення ошибка сервера")
            }
    )
    @PutMapping
    public TaskDto editTask(@RequestBody TaskUpdateDto taskDto) {
        return taskService.editTask(taskDto);
    }

    @Operation(
            summary = "Удалить задачу",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Задача удалена",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(type = "boolean"))
                                    )

                            }
                    ),
                    @ApiResponse(responseCode = "400", description = "Некорректный запрос"),
                    @ApiResponse(responseCode = "404", description = "Объект не найден"),
                    @ApiResponse(responseCode = "500", description = "Внутрення ошибка сервера")
            }
    )
    @DeleteMapping("/{id}")
    public boolean deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id);
    }

    @Operation(
            summary = "Получить все задачи по автору",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Задачи получены",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = TaskDto.class))
                                    )

                            }
                    ),
                    @ApiResponse(responseCode = "400", description = "Некорректный запрос"),
                    @ApiResponse(responseCode = "404", description = "Объект не найден"),
                    @ApiResponse(responseCode = "500", description = "Внутрення ошибка сервера")
            }
    )
    @GetMapping("/by-author")
    public Page<TaskDto> getTasksByAuthor(@RequestParam String author, Pageable pageable) {
        return taskService.getTasksByAuthor(author, pageable);
    }

    @Operation(
            summary = "Получить все задачи по исполнителю",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Задачи получены",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = TaskDto.class))
                                    )

                            }
                    ),
                    @ApiResponse(responseCode = "400", description = "Некорректный запрос"),
                    @ApiResponse(responseCode = "404", description = "Объект не найден"),
                    @ApiResponse(responseCode = "500", description = "Внутрення ошибка сервера")
            }
    )
    @GetMapping("/by-performer")
    public Page<TaskDto> getTasksByPerformer(@RequestParam String performer, Pageable pageable) {
        return taskService.getTaskByPerformer(performer, pageable);
    }
}
