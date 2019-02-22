package com.harrisonbrock.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long todoid;

    @Column(nullable = false)
    private String description;

//    @Temporal(TemporalType.DATE)
//    private Date datestarted;

    private boolean completed;

    @ManyToOne()
    @JoinColumn(name = "userid")
    @JsonIgnore
    private User user;
}
