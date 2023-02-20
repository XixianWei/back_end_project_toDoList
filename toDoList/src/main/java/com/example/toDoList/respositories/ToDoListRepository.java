package com.example.toDoList.respositories;

import com.example.toDoList.models.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository <ToDoList, Long> {
}
