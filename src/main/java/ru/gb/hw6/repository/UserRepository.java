package ru.gb.hw6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.hw6.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
