package com.example.toDoList.models;

public class ToDoListDTO {

    private Long id;
    private String title;
    private ListCategory listCategory;

    public ToDoListDTO(Long id, String title, ListCategory listCategory) {
        this.id = id;
        this.title = title;
        this.listCategory = listCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ListCategory getListCategory() {
        return listCategory;
    }

    public void setListCategory(ListCategory listCategory) {
        this.listCategory = listCategory;
    }
}
