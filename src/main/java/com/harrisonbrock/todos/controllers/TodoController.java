package com.harrisonbrock.todos.controllers;

import com.harrisonbrock.todos.models.Todo;
import com.harrisonbrock.todos.models.User;
import com.harrisonbrock.todos.repositories.TodoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Api(value = "Demo TODO Application", description = "Do not use this it's only a demo")
@RestController
@RequestMapping("todos")
public class TodoController {

    private final TodoRepository repository;

    public TodoController(TodoRepository repository) {
        this.repository = repository;
    }


    @ApiOperation(value = "Get all Todos", response = List.class)
    @GetMapping
    public List<Todo> getAllTodos() {
        return repository.findAll();
    }


    @ApiOperation(value = "Get Todo base off user id", response = Todo.class)
    @GetMapping("/todoid/{id}")
    public Todo getTodoById(@PathVariable long id) {
        return repository.findById(id).orElse(null);
    }


    @ApiOperation(value = "Get all Todo that are not completed", response = List.class)
    @GetMapping("/active")
    public List<Todo> getTodosNotCompleted() {
        return repository.findByCompletedFalse();
    }

    @GetMapping("/users")
    public List<Objects[]> getTodoForUsers() {
        return repository.getTodoAndUser();
    }

    @PostMapping
    public Todo insertOneTodo(@RequestBody Todo todo) {
        return repository.save(todo);
    }
}

