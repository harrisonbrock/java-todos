package com.harrisonbrock.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;

    private String username;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    @JsonIgnore
    private Set<Todo> todos;
}
