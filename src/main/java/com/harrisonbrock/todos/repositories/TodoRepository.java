package com.harrisonbrock.todos.repositories;

import com.harrisonbrock.todos.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
