package com.example.toDoList.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @JsonIgnoreProperties({"users"})
    @OneToMany(mappedBy = "user")
    private List<ToDoList> toDoLists;

    //constructors
    public User(String name, String email, List<ToDoList> toDoLists) {
        this.name = name;
        this.email = email;
        this.toDoLists = new ArrayList<>();
    }

    public User() {}

    //getters & setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ToDoList> getToDos() {
        return toDoLists;
    }

    public void setToDos(List<ToDoList> toDoLists) {
        this.toDoLists = toDoLists;
    }
}
