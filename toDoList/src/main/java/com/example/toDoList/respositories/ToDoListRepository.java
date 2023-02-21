package com.example.toDoList.respositories;

import com.example.toDoList.models.ListCategory;
import com.example.toDoList.models.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoListRepository extends JpaRepository <ToDoList, Long> {
    List<ToDoList> findByListCategory(ListCategory listCategory);
}
