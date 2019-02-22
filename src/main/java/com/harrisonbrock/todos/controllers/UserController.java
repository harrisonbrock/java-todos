package com.harrisonbrock.todos.controllers;

import com.harrisonbrock.todos.models.User;
import com.harrisonbrock.todos.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/userid/{id}")
    public User getUserById(@PathVariable long id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/username/{name}")
    public User getUserById(@PathVariable String name) {
        return repository.findByUsername(name);
    }

    @PostMapping
    public User insertOneUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }
}
