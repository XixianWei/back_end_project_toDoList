package com.example.toDoList.respositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.toDoList.models.ToDo;

import java.time.LocalDate;
import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findToDoByDueDate(LocalDate dueDate);
}
