package com.example.toDoList.respositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.toDoList.models.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
