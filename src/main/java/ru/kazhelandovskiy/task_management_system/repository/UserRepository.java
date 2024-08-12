package ru.kazhelandovskiy.task_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kazhelandovskiy.task_management_system.model.UserModel;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);

    boolean existsByEmail(String email);
}
