package com.example.toDoList.controller;

import com.example.toDoList.models.ToDoList;
import com.example.toDoList.models.User;
import com.example.toDoList.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    //add a new user
    @PostMapping
    public ResponseEntity<User> newUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //update a user by id
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long id){
        user.setId(id);
        userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    //get a user by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //delete a user by id
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }



}
