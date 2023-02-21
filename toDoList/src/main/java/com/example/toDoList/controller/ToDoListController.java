package com.example.toDoList.controller;

import com.example.toDoList.models.ToDoList;
import com.example.toDoList.services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/to_do_list")
public class ToDoListController {
    @Autowired
    ToDoListService toDoListService;

    @GetMapping
    public ResponseEntity<List<ToDoList>> getAllToDoLists(){
        List<ToDoList> toDoLists = toDoListService.getAllToDoLists();
        return new ResponseEntity<>(toDoLists, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ToDoList> getToDoListById(@PathVariable Long id){
        Optional<ToDoList> todoList = toDoListService.getListById(id);
        if (todoList.isPresent()){
            return new ResponseEntity<>(todoList.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //create a new to do list
    @PostMapping
    public ResponseEntity<List<ToDoList>> newToDoList(@RequestBody ToDoList toDoList){
        toDoListService.saveToDoList(toDoList);
        return new ResponseEntity<>(toDoListService.getAllToDoLists(), HttpStatus.CREATED);
    }

    //update to do list
    @PutMapping(value = "/{id}")
    public ResponseEntity<ToDoList> updateToDoList (@RequestBody ToDoList toDoList, @PathVariable Long id){
        toDoList.setId(id);
        toDoListService.updateToDoList(toDoList);
        return new ResponseEntity<>(toDoList, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteToDoList(@PathVariable Long id){
        toDoListService.deleteToDoList(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }



}
