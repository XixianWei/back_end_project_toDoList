package com.example.toDoList.respositories;

import com.example.toDoList.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
