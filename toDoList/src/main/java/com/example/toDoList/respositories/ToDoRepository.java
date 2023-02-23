package com.example.toDoList.respositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.toDoList.models.ToDo;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    //find the to-dos by due
    List<ToDo> findToDoByDueDate(LocalDate dueDate);
}
