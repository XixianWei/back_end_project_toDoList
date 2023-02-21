package com.example.toDoList.components;

import com.example.toDoList.models.ListCategory;
import com.example.toDoList.models.ToDo;
import com.example.toDoList.models.ToDoList;
import com.example.toDoList.models.User;
import com.example.toDoList.respositories.ToDoListRepository;
import com.example.toDoList.respositories.ToDoRepository;
import com.example.toDoList.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.ArrayList;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ToDoRepository toDoRepository;

    @Autowired
    ToDoListRepository toDoListRepository;

    @Autowired
    UserRepository userRepository;


    public DataLoader() {

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        //Amy
        //Household
        User amy = new User("Amy", "amy@gmail.com", new ArrayList<>());
        userRepository.save(amy);

        //create a shopping list
        ToDoList shoppingList = new ToDoList("Shopping List", new ArrayList<>(), amy, ListCategory.HOUSEHOLD);
        toDoListRepository.save(shoppingList);

        //create a to-do
        ToDo paint = new ToDo("Buy some paints", "For house", "26th Feb 2023", shoppingList);
        toDoRepository.save(paint);

        ToDo chair = new ToDo("Buy 4 chairs", "For house", "26th Feb 2023", shoppingList);
        toDoRepository.save(chair);

        ToDo curtain = new ToDo("Buy curtains", "For house", "26th Feb 2023", shoppingList);
        toDoRepository.save(curtain);

        ToDo tomatoes = new ToDo("Buy some tomatoes", "For dinner", "28th Feb 2023", shoppingList);
        toDoRepository.save(tomatoes);

        ToDo eggs = new ToDo("Buy eggs", "For dinner", "28th Feb 2023", shoppingList);
        toDoRepository.save(tomatoes);

        //Health

        //create a list
        ToDoList journal = new ToDoList("Journal", new ArrayList<>(), amy, ListCategory.HEALTH);
        toDoListRepository.save(journal);

        //create a to-do
        ToDo writeEntry = new ToDo("Write gratitude", "For the day", "Daily", shoppingList);
        toDoRepository.save(writeEntry);

        //Self-care
        //create a list
        ToDoList moodBoard = new ToDoList("My mood board", new ArrayList<>(), amy, ListCategory.SELFCARE);
        toDoListRepository.save(moodBoard);

        //create a to-do
        ToDo getCanvas = new ToDo("layout pictures for board", "for vision board", "3rd Mar 2023", moodBoard);
        toDoRepository.save(getCanvas);


        //Work

        //create a list
        ToDoList launchWebsite = new ToDoList("Launch website", new ArrayList<>(), amy, ListCategory.WORK);
        toDoListRepository.save(launchWebsite);

        //create a to-do
        ToDo createwebsite = new ToDo("Create Html", "For site", "Monday", shoppingList);
        toDoRepository.save(createwebsite);

        //User Tom

        //Self Care

        User tom = new User("Tom", "tom@gmail.com", new ArrayList<>());
        userRepository.save(tom);

        ToDoList morningRoutine = new ToDoList("morningRoutine", new ArrayList<>(), tom, ListCategory.SELFCARE);
        toDoListRepository.save(morningRoutine);

        ToDo wakeUp = new ToDo("wake up 7am", "Journal and skincare", "daily", morningRoutine);
        toDoRepository.save(wakeUp);

        //Work
        ToDoList presentation = new ToDoList("presentation", new ArrayList<>(), tom, ListCategory.WORK);
        toDoListRepository.save(presentation);

        ToDo prepare = new ToDo("Java Class", "create powerpoint", "Friday", presentation);
        toDoRepository.save(prepare);

        //Health
        ToDoList workoutRoutine = new ToDoList("Sleep", new ArrayList<>(), tom, ListCategory.HEALTH);
        toDoListRepository.save(workoutRoutine);

        ToDo getUp = new ToDo("sleep", "end the day with me", "Daily", workoutRoutine);
        toDoRepository.save(getUp);


        //User Katy

        //Work

        User katy = new User("Katy", "katy@gmail.com", new ArrayList<>());
        userRepository.save(katy);

        ToDoList studyPlan = new ToDoList("Study Plan", new ArrayList<>(), katy, ListCategory.WORK);
        toDoListRepository.save(studyPlan);

        ToDo revisionguide = new ToDo("study", "Create study guide", "daily", studyPlan);
        toDoRepository.save(revisionguide);

        // Household
        ToDoList plantTracker = new ToDoList("Plant Tracker", new ArrayList<>(), katy, ListCategory.HOUSEHOLD);
        toDoListRepository.save(plantTracker);

        ToDo waterPlant = new ToDo("plant check", "Water plants", "every other day", plantTracker);
        toDoRepository.save(waterPlant);


        //User Mike

        //Work

        User mike = new User("Mike", "mike@gmail.com", new ArrayList<>());
        userRepository.save(mike);

        ToDoList meetingSchedule = new ToDoList("Meeting", new ArrayList<>(), mike, ListCategory.WORK);
        toDoListRepository.save(meetingSchedule);

        ToDo setMeeting = new ToDo("meeting", "Schedule meeting with Kate", "Thursday", meetingSchedule);
        toDoRepository.save(setMeeting);

        //Self Care
        ToDoList eveningRoutine = new ToDoList("Sleep", new ArrayList<>(), mike, ListCategory.SELFCARE);
        toDoListRepository.save(eveningRoutine);

        ToDo unWind = new ToDo("sleep", "end the day with me", "Daily", eveningRoutine);
        toDoRepository.save(unWind);

        //Household
        ToDoList cleanHouse = new ToDoList("Clean", new ArrayList<>(), mike, ListCategory.HOUSEHOLD);
        toDoListRepository.save(cleanHouse);

        ToDo tidyUp = new ToDo("tidyUp", "clean up house every weekend", "Saturday", cleanHouse);
        toDoRepository.save(tidyUp);


    }


}
