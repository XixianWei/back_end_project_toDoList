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

    @Enumerated
    ListCategory listCategory;

    @OneToMany(mappedBy = "toDoList")
    @JsonIgnoreProperties({"toDoList"})
    private List<ToDo> toDos;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties ({"toDoLists"})
    private User user;

    public ToDoList(String title, List<ToDo> toDos, User user, ListCategory listCategory) {
        this.title = title;
        this.toDos = new ArrayList<>();
        this.user = user;
        this.listCategory = listCategory;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ListCategory getListCategory() {
        return listCategory;
    }

    public void setListCategory(ListCategory listCategory) {
        this.listCategory = listCategory;
    }
}
