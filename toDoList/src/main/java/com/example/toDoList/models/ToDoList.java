package com.example.toDoList.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity (name = "to_do_lists")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @OneToMany(mappedBy = "to_do_list")
    @JsonIgnoreProperties({"to_do_lists"})
    private List<ToDo> toDos;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties ({"to_do_lists"})
    private User user;

    public ToDoList(String title, List<ToDo> toDos, User user) {
        this.title = title;
        this.toDos = new ArrayList<>();
        this.user = user;

    }

    public ToDoList() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ToDo> getToDos() {
        return toDos;
    }

    public void setToDos(List<ToDo> toDos) {
        this.toDos = toDos;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
