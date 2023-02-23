package com.example.toDoList.controller;

import com.example.toDoList.models.ListCategory;
import com.example.toDoList.models.ToDoList;
import com.example.toDoList.models.User;
import com.example.toDoList.models.UserDTO;
import com.example.toDoList.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User user : users){
            UserDTO userDTO =new UserDTO(user.getId(), user.getName(), user.getEmail());
            userDTOS.add(userDTO);
        }
        return new ResponseEntity<>(userDTOS,HttpStatus.OK);
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

    // delete a user's to-do from their to-do list when done
    @PutMapping("/{userId}/to-do-list/{toDoListId}/to-do/{toDoId}")
    public void DeleteDoneToDo(@PathVariable Long userId, @PathVariable Long toDoListId, @PathVariable Long toDoId){
        userService.markToDoAsDoneAndDelete(userId,toDoListId,toDoId);
    }





}
