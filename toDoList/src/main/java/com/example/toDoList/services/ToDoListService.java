package com.example.toDoList.services;

import com.example.toDoList.models.ToDoList;
import com.example.toDoList.respositories.ToDoListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoListService {
    @Autowired
    ToDoListRepository toDoListRepository;

    public List<ToDoList> getAllToDoLists(){
        return toDoListRepository.findAll();
    }

    public Optional getListById(Long id){
        return toDoListRepository.findById(id);
    }

    //create to do list
    public void saveToDoList(ToDoList toDoList){
        toDoListRepository.save(toDoList);
    }


    //update to do list
    public void updateToDoList (ToDoList toDoList, Long id){
        ToDoList listToUpdate = toDoListRepository.findById(id).get();
        listToUpdate.setTitle(listToUpdate.getTitle());
        toDoListRepository.save(listToUpdate);
    }

    //delete to do list
    public void deleteToDoList(Long id){
        toDoListRepository.deleteById(id);
    }





}
