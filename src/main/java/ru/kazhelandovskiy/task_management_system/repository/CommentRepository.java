package ru.kazhelandovskiy.task_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kazhelandovskiy.task_management_system.model.CommentModel;
import ru.kazhelandovskiy.task_management_system.model.TaskModel;

@Repository
public interface CommentRepository extends JpaRepository<CommentModel, Long> {
}
