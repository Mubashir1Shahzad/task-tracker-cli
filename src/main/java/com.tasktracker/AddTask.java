package com.tasktracker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AddTask {
    public static void main(String[] args) {
        AddTask addTask = new AddTask();
        addTask.addTaskToJson("doing some other coding work");
    }

    public AddTask() {}

    public void addTaskToJson(String description) {
        ObjectMapper mapper = new ObjectMapper();

        // deserializing
        List<Task> taskList = new ArrayList<Task>();

        try {
            taskList = mapper.readValue(new File("data.json"), new TypeReference<ArrayList<Task>>() {});
        } catch (IOException e) {}

        int id = (taskList.getLast().getId()) + 1;
        taskList.add(new Task(id, description));

        // serializing
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("data.json"), taskList);
        } catch (IOException e) {
            System.out.println("Error occurred while serializing the object.");
            e.getCause();
        }
    }
}