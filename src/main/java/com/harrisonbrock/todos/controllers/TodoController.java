package com.harrisonbrock.todos.controllers;

import com.harrisonbrock.todos.models.Todo;
import com.harrisonbrock.todos.repositories.TodoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("todos")
public class TodoController {

    private final TodoRepository repository;

    public TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    @GetMapping("/todoid/{id}")
    public Todo getTodoById(@PathVariable long id) {
        return repository.findById(id).orElse(null);
    }
}

