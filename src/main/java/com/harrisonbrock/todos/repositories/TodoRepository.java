package com.harrisonbrock.todos.repositories;

import com.harrisonbrock.todos.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Query(value = "select u.username, t.description from todo t, users u where t.userid = u.userid order by u.username", nativeQuery = true)
    List<Objects[]> getTodoAndUser();
    List<Todo> findByCompletedFalse();
}
