package com.example.toDoList.respositories;

import com.example.toDoList.models.ToDoList;
import com.example.toDoList.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT toDoList FROM ToDoList toDoList WHERE user.id = :userId AND toDoList.id = :toDoListId")
    ToDoList findToDoListById(@Param("userId") Long userId, @Param("toDoListId") Long toDoListId);
}


