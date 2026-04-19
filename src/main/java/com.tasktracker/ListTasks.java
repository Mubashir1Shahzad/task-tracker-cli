package com.tasktracker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class ListTasks {
    ObjectMapper mapper = new ObjectMapper();
    ArrayList<Task> tasksList = new ArrayList<>();

    public static void main(String[] args) {
        ListTasks lt = new ListTasks();
        lt.listTasksDone();
    }

    public ListTasks() {
        try {
            tasksList = mapper.readValue(
                    new File("data.json"),
                    new TypeReference<ArrayList<Task>>(){}
            );
        } catch (IOException e) {
            System.out.println("Task List is empty!");
        }
    }

    public void listAllTasks() {
        for (Task task : tasksList) {
            System.out.println(task);
        }
    }

    public void listTasksToDo() {
        for (Task task : tasksList) {
            if (task.getStatus().equals("todo")) {
                System.out.println(task);
            }
        }
    }

    public void listTasksInProgress() {
        for (Task task : tasksList) {
            if (task.getStatus().equals("in-progress")) {
                System.out.println(task);
            }
        }
    }

    public void listTasksDone() {
        for (Task task : tasksList) {
            if (task.getStatus().equals("done")) {
                System.out.println(task);
            }
        }
    }
}