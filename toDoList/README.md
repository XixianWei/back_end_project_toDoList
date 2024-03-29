# README


# Get Orgnised by GYST


## Project Description
This is a simple ToDoList application that allows users to create, view, update and delete to-do items. The application allows users to sign up for an account, log in and start creating to-do lists.


### Features

- User registration and login
- Create, view, update and delete to-do items
- Create to-do lists by category
- Assign to-do items to different lists
- Mark to-do items as completed
- Search for to-do items
- Search by to-do lists by category
- Search to-do items by due-date



## How to use the Project:
1. Clone the project from the repository to your local machine: 
   - ssh: `git@github.com:XixianWei/back_end_project_toDoList.git`
2. Navigate to the project directory in the command line.
3. Once the project is running, navigate to localhost:8080 in your web browser or Postman.
4. From there, you can register a new user account or log in to an existing account.
5. Once you're logged in, you can create new to-do lists and add to-dos to those lists.
6. You can view all of your to-do lists and to-dos, edit them, or delete them as needed.

## URLs:
Add a user:
POST(body)
http://localhost:8080/users

Get all users:
GET
http://localhost:8080/users

Get all categories of to-do lists:
GET
http://localhost:8080/to_do_lists/category

Filter get all to-do lists by category
Get
http://localhost:8080/to_do_lists/category/{CATAGORY}

Add a to-do list:
POST(body)
http://localhost:8080/to_do_lists

Delete a to do list:
DELETE
http://localhost:8080/to_do_lists/{id}

Get all to-do lists:
GET
http://localhost:8080/to_do_lists

Update a to-do list:
PUT(body)
http://localhost:8080/to_do_lists/{id}

Get list by id:
GET
http://localhost:8080/to_do_lists/{id}


Add a to-do:
POST(body)
http://localhost:8080/to_dos/13

Filter all to-dos by due date:
GET
http://localhost:8080/to_dos/by_due_date/2023-02-28

Get a user and their lists:
GET
http://localhost:8080/users/user-list/{id}

Delete a finished to-do from a user's list
PUT
http://localhost:8080/users/{id}/to-do-list/{id}/to-do/{id}



### What was our motivation?
Our motivation for developing a to-do list application was to help users keep track of their tasks and improve their productivity. To-do list applications can also be useful for organizations to manage their projects and improve team collaboration. Additionally, developing a to-do list application can be a good exercise in software development and provide experience with technologies such as Java, Spring Boot, and MySQL.


### What did we learn?

- How to set up a Spring Boot application.
- How to implement the CRUD (Create, Read, Update, Delete) operations for a database using Spring Data JPA.
- How to handle HTTP requests and responses using Spring MVC.
- How to write RESTful APIs using Spring.
- How to handle exceptions and error responses in a Spring application.
- How to implement relationships between entities in a database using JPA.
- How to use Hibernate to create and manage database tables.
- How to work with Git for version control and collaboration. 
- How to work in an agile development environment with a team.


## Credits:
- Diana:`https://github.com/PrincessDiana1`
- Ryder: `https://github.com/rrydderr`
- Xixian: `https://github.com/XixianWei`