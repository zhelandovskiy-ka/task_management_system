package ru.kazhelandovskiy.task_management_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kazhelandovskiy.task_management_system.dto.CommentDto;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "label")
    private String label;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "priority")
    private String priority;

    @Column(name = "author")
    private String author;

    @Column(name = "performer")
    private String performer;

    @OneToMany(mappedBy = "taskId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentModel> commentsList;
}
