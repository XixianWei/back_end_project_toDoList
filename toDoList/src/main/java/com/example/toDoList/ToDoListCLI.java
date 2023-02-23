package com.example.toDoList;

import com.example.toDoList.models.ToDoList;
import com.example.toDoList.models.User;
import com.example.toDoList.models.UserDTO;
import com.example.toDoList.services.ToDoListService;
import com.example.toDoList.services.ToDoService;
import com.example.toDoList.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ToDoListCLI {

private static final Scanner scanner = new Scanner(System.in);
    private static UserService userService = new UserService();
    private static ToDoListService toDoListService = new ToDoListService();
    private static ToDoService toDoService = new ToDoService();

    public static void main(String[] args) {


        System.out.println("Hello! Welcome to GetOrganised - The app that helps you GYST!");

        //present user with options to choose
        while (true) {
            System.out.println("Let's get started. What would you like to do? (1-3)");
            System.out.println("1. Register a new account");
            System.out.println("2. Login");
            System.out.println("3. Exit application");

            int reader = scanner.nextInt();
            scanner.nextLine();


            //switch statement to allow user to choose option
            switch (reader) {
                case 1:
                    System.out.println("You have chosen to register a new account");

                    System.out.println("Please enter your full name: ");
                    String fullname = scanner.nextLine();

                    System.out.println("Please enter your email address: ");
                    String emailAddress = scanner.nextLine();


                    //check if  user details are correct -
                    String confirmDetails = "no";
                    while (!confirmDetails.equals("yes")) {
                        System.out.println("Thank you for registering your details.");
                        System.out.println("Please confirm that the following is correct: ");
                        System.out.println("Full name: " + fullname);
                        System.out.println("Email: " + emailAddress);
                        System.out.println("Enter 'yes' to confirm or 'no' to re-enter your details.");

                        confirmDetails = scanner.nextLine();

                        if (!confirmDetails.equals("yes")) {
                            System.out.println("Please re-enter your details:");
                            System.out.print("Full name: ");
                            fullname = scanner.nextLine();

                            System.out.print("Email: ");
                            emailAddress = scanner.nextLine();
                        }
                    }
                    //create user and pass them to adduser method in service
                    User newUser = new User(fullname, emailAddress, new ArrayList<>() {
                    });
                    userService.addUser(newUser);


                    return;


            }


        }


    }
}
