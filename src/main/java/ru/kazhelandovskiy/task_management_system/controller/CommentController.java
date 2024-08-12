package ru.kazhelandovskiy.task_management_system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kazhelandovskiy.task_management_system.dto.CommentCreateDto;
import ru.kazhelandovskiy.task_management_system.dto.CommentDto;
import ru.kazhelandovskiy.task_management_system.dto.TaskCreateDto;
import ru.kazhelandovskiy.task_management_system.dto.TaskDto;
import ru.kazhelandovskiy.task_management_system.service.CommentService;
import ru.kazhelandovskiy.task_management_system.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;

    @Operation(
            summary = "Добавить комментарий к задаче",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Комментарий добавлен",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = CommentDto.class))
                                    )
                            }
                    ),
                    @ApiResponse(responseCode = "400", description = "Некорректный запрос"),
                    @ApiResponse(responseCode = "404", description = "Объект не найден"),
                    @ApiResponse(responseCode = "500", description = "Внутрення ошибка сервера")
            }
    )
    @PostMapping
    public CommentDto addCommentToTask(@RequestBody CommentCreateDto commentCreateDto) {
        return commentService.addCommentToTask(commentCreateDto);
    }
}
