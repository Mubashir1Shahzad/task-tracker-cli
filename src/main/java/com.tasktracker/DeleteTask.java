package com.tasktracker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

public class DeleteTask {
    ObjectMapper mapper = new ObjectMapper();
    ArrayList<Task> tasksList = new ArrayList<>();

    public static void main(String[] args) {
        DeleteTask t = new DeleteTask();
        t.deleteTask(1);
    }

    public DeleteTask() {
        try {
            tasksList = mapper.readValue(
                    new File("data.json"),
                    new TypeReference<ArrayList<Task>>() {}
            );
        } catch (IOException e) {
            System.out.println("Task List is empty!");
        }
    }

    public void deleteTask(int id) {
        boolean removed = tasksList.removeIf(task -> task.getId() == id);
        if (!removed) {
            System.out.println("Invalid command! Can not remove task that does not exist.");
        }

        deleteInJson();
    }

    private void deleteInJson() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("data.json"), tasksList);
        } catch (IOException e) {
            System.out.println("Due to some issue your task could not be deleted!");
        }
    }
}