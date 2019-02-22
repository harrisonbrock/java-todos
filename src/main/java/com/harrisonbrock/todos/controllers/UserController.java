package com.harrisonbrock.todos.controllers;

import com.harrisonbrock.todos.models.User;
import com.harrisonbrock.todos.repositories.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(value = "Demo TODO Application", description = "Do not use this it's only a demo")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @ApiOperation(value = "List all User", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieve list"),
            @ApiResponse(code = 401, message = "You are not authorized to the view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @ApiOperation(value = "Get User base off user id", response = User.class)
    @GetMapping("/userid/{id}")
    public User getUserById(@PathVariable long id) {
        return repository.findById(id).orElse(null);
    }

    @ApiOperation(value = "Get User base off user username", response = User.class)
    @GetMapping("/username/{name}")
    public User getUserByName(@PathVariable String name) {
        return repository.findByUsername(name);
    }

    @PostMapping
    public User insertOneUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @PutMapping("/userid/{id}")
    public User updateUser(@RequestBody User updateUser, @PathVariable long id) {
        Optional<User> user = repository.findById(id);

        if (user.isPresent()) {
            updateUser.setUserid(id);
            repository.save(updateUser);
            return updateUser;
        }
        return  null;
    }
}
