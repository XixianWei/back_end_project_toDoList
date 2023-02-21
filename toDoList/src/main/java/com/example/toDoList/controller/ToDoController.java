package com.example.toDoList.controller;

import com.example.toDoList.models.ToDo;
import com.example.toDoList.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/to_do")
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
        public ResponseEntity<ToDo> newToDo(@RequestBody ToDo toDo){
            toDoService.saveToDo(toDo);
            return new ResponseEntity<>(toDo, HttpStatus.CREATED);
        }

         @PutMapping(value = "/{id}")
            public ResponseEntity<ToDo> updateToDo (@RequestBody ToDo toDo, @PathVariable Long id){
             toDo.setId(id);
             toDoService.updateToDo(toDo);
             return new ResponseEntity<>(toDo, HttpStatus.OK);
            }

            @DeleteMapping(value = "/{id}")
            public ResponseEntity<Long> deleteToDo(@PathVariable Long id){
                toDoService.deleteToDo(id);
                return new ResponseEntity<>(id, HttpStatus.OK);
            }

}
