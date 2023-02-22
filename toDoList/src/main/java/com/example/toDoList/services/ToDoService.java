package com.example.toDoList.services;

import com.example.toDoList.models.ToDo;
import com.example.toDoList.models.ToDo;
import com.example.toDoList.models.ToDoList;
import com.example.toDoList.respositories.ToDoListRepository;
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

    @Autowired
    ToDoListRepository toDoListRepository;

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

    public void deleteDoneToDo(Long id){
        // method to mark todo as done
        ToDo toDo = toDoRepository.findById(id).orElseThrow();
        toDo.setDone(true);
        toDoRepository.save(toDo);
        //delete the todo
        ToDoList toDoList = toDo.getToDoList();
        List<ToDo> toDos = toDoList.getToDos();
        toDos.remove(toDo);
        toDoListRepository.save(toDoList);


    }


    //method to delete todo when done
////    public void deleteDoneToDo(ToDoList toDoList){
//        //define a list of todos
//        List<ToDo> toDos = toDoList.getToDos();
//
//        //check if todo is done in a while loop
//        int i = 0;
//        while(i < toDos.size()){
//            ToDo toDo = toDos.get(i);
//            if(toDo.isDone()){ toDos.remove(i);
//        }
//            else {
//                i ++;
//            }
//            break;
//    }







}
