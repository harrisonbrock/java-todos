package com.harrisonbrock.todos.repositories;

import com.harrisonbrock.todos.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
