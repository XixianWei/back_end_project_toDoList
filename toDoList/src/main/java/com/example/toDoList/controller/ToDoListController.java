package com.example.toDoList.controller;

import com.example.toDoList.models.*;
import com.example.toDoList.services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/to_do_lists")
public class ToDoListController {
    @Autowired
    ToDoListService toDoListService;


    public static ToDoListDTO mapToDoListEntityToDTO(ToDoList toDoList) {
        return new ToDoListDTO(toDoList.getId(), toDoList.getTitle(), toDoList.getListCategory());
    }

    @GetMapping
    public ResponseEntity<List<ToDoListDTO>> getAllToDoLists(){
        List<ToDoList> toDoLists = toDoListService.getAllToDoLists();
        List<ToDoListDTO> toDoListDTOS = new ArrayList<>();
        for(ToDoList toDoList : toDoLists){
            ToDoListDTO toDoListDTO = new ToDoListDTO(toDoList.getId(),toDoList.getTitle(),toDoList.getListCategory());
            toDoListDTOS.add(toDoListDTO);
        }
        return new ResponseEntity<>(toDoListDTOS, HttpStatus.OK);
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
    public ResponseEntity<List<ToDoListDTO>> newToDoList(@RequestBody ToDoListDTO toDoListDTO){
        ToDoList toDoList = new ToDoList();
        toDoList.setTitle(toDoListDTO.getTitle());
        toDoList.setListCategory(toDoListDTO.getListCategory());

        toDoListService.saveToDoList(toDoList);
        List<ToDoList> toDoLists = toDoListService.getAllToDoLists();
        List<ToDoListDTO> toDoListDTOS = new ArrayList<>();
        for(ToDoList list : toDoLists){
            ToDoListDTO dto = new ToDoListDTO(list.getId(), list.getTitle(), list.getListCategory());
            toDoListDTOS.add(dto);
        }
        return new ResponseEntity<>(toDoListDTOS, HttpStatus.CREATED);
    }

    //update to do list
    @PutMapping(value = "/{id}")
    public ResponseEntity<ToDoList> updateToDoList (@RequestBody ToDoList toDoList, @PathVariable Long id){
        toDoList.setId(id);
        toDoListService.updateToDoList(toDoList);
        return new ResponseEntity<>(toDoList, HttpStatus.OK);
    }

    //delete a to do list
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteToDoList(@PathVariable Long id){
        toDoListService.deleteToDoList(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    // get lists by category
    @GetMapping(value = "/category/{listCategory}")
    public ResponseEntity<List<ToDoListDTO>> getToDoListByCategory(@PathVariable ListCategory listCategory) {
        List<ToDoList> toDoLists = toDoListService.findAllListsByCategory(listCategory);

        if (toDoLists.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            List<ToDoListDTO> toDoListDTOS = new ArrayList<>();
            for (ToDoList toDoList : toDoLists) {
                ToDoListDTO toDoListDTO = new ToDoListDTO(toDoList.getId(), toDoList.getTitle(), toDoList.getListCategory());
                toDoListDTOS.add(toDoListDTO);
            }
            return new ResponseEntity<>(toDoListDTOS, HttpStatus.OK);
        }
    }

    //get categories
    @GetMapping(value = "/category")
    public ResponseEntity<List<String>> getAllListCategories() {
        List<String> categories = new ArrayList<>();
        for (ListCategory category : ListCategory.values()) {
            categories.add(category.name());
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

}
