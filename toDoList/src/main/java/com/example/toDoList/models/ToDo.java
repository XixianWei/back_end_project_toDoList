package com.example.toDoList.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "toDo")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column (name = "description")
    private String description;

    @Column (name = "due")
    private String due;

    @Column (name = "done")
    private boolean done;

    @ManyToOne
    @JoinColumn (name = "to_do_list_id")
    @JsonIgnoreProperties({"to_do"})
    private ToDoList toDoList;


    public ToDo(String title, String description, String due, ToDoList toDoList) {
        this.title = title;
        this.description = description;
        this.due = due;
        this.done = false;
        this.toDoList = toDoList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }
}
