package com.example.toDoList.services;

import com.example.toDoList.models.ToDo;
import com.example.toDoList.models.ToDoList;
import com.example.toDoList.models.User;
import com.example.toDoList.respositories.ToDoListRepository;
import com.example.toDoList.respositories.ToDoRepository;
import com.example.toDoList.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ToDoListRepository toDoListRepository;

    @Autowired
    ToDoRepository toDoRepository;


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user){return userRepository.save(user);}

    public void deleteUser(Long id){userRepository.deleteById(id);}


    // delete a user's to-do from their to-do list when done
    public void markToDoAsDoneAndDelete(Long userId, Long ToDoListId,Long toDoId){
        // get the user by id
        User user = userRepository.findById(userId).orElseThrow();
        //get the to-do list by id
        ToDoList toDoList = userRepository.findToDoListById(userId,ToDoListId);
        //get the to-do by id
        ToDo toDo = toDoListRepository.findToDoById(toDoId, ToDoListId);

        //mark the to-do as done
        toDo.setDone(true);
        toDoRepository.save(toDo);

        //delete the to-do from the to-do list
        toDoListRepository.deleteToDoById(toDoId,ToDoListId);
        toDoListRepository.save(toDoList);
    }


}
