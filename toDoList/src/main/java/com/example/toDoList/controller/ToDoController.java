package com.example.toDoList.controller;

import com.example.toDoList.models.ListCategory;
import com.example.toDoList.models.ToDo;
import com.example.toDoList.models.ToDoList;
import com.example.toDoList.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/to_dos")
public class ToDoController {


    @Autowired
    ToDoService toDoService;

    @GetMapping
    public ResponseEntity<List<ToDo>> getAllToDo() {
        List<ToDo> toDo = toDoService.getAllToDos();
        return new ResponseEntity<>(toDo, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable Long id) {
        Optional<ToDo> toDo = toDoService.getToDoById(id);
        if (toDo.isPresent()) {
            return new ResponseEntity<>(toDo.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ToDo> newToDo(@RequestBody ToDo toDo) {
        toDoService.saveToDo(toDo);
        return new ResponseEntity<>(toDo, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ToDo> updateToDo(@RequestBody ToDo toDo, @PathVariable Long id) {
        toDo.setId(id);
        toDoService.updateToDo(toDo);
        return new ResponseEntity<>(toDo, HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteToDo(@PathVariable Long id) {
        toDoService.deleteToDo(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/done")
    public ResponseEntity<ToDo> deleteCompletedToDos(@PathVariable Long id) {
        toDoService.deleteDoneToDo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //get all todos by due date
    @GetMapping(value = "/by_due_date/{dueDate}")
    public ResponseEntity<List<ToDo>> getAllToDosByDueDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dueDate) {
        List<ToDo> toDos = toDoService.findAllToDosByDueDate(dueDate);

        if (toDos.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(toDos, HttpStatus.OK);
        }
    }

}
