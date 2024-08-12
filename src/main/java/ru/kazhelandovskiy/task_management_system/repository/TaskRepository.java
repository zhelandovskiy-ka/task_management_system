package ru.kazhelandovskiy.task_management_system.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kazhelandovskiy.task_management_system.model.TaskModel;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {
    boolean existsById(Long id);

    Page<TaskModel> findByAuthor(String author, Pageable pageable);

    Page<TaskModel> findByPerformer(String performer, Pageable pageable);
}
