package com.example.toDoList.respositories;

import com.example.toDoList.models.ListCategory;
import com.example.toDoList.models.ToDo;
import com.example.toDoList.models.ToDoList;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ToDoListRepository extends JpaRepository <ToDoList, Long> {

    //find the to-do lists by category
    List<ToDoList> findByListCategory(ListCategory listCategory);

    //find to-do in list by id
    @Query("SELECT toDo FROM ToDo toDo WHERE toDo.id = :toDoId AND toDo.toDoList.id = :toDoListId")
    ToDo findToDoById(@Param("toDoId") Long toDoId , @Param("toDoListId") Long toDoListId);

    // delete a to-do by id
    @Modifying
    @Transactional
    @Query ("DELETE FROM ToDo toDo WHERE toDo.id = :toDoId AND toDo.toDoList.id = :toDoListId")
    void deleteToDoById(@Param("toDoId") Long toDoId, @Param("toDoListId") Long toDoListId);
}
