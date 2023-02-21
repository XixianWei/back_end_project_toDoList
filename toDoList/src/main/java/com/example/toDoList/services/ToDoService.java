package com.example.toDoList.services;

import com.example.toDoList.models.ToDo;
import com.example.toDoList.models.ToDo;
import com.example.toDoList.respositories.ToDoRepository;

import com.example.toDoList.respositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    @Autowired
    ToDoRepository toDoRepository;

    public List<ToDo> getAllToDos(){
        return toDoRepository.findAll();
    }

    public Optional getToDoById(Long id){
        return toDoRepository.findById(id);
    }

    //create to do
    public void saveToDo(ToDo toDo){
        toDoRepository.save(toDo);
    }


    //update to do list
    public ToDo updateToDo (ToDo toDo){
        return toDoRepository.save(toDo);
    }

    //delete to do list
    public void deleteToDo(Long id){
        toDoRepository.deleteById(id);
    }





}
