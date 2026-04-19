package com.tasktracker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

/**
 * Handles updating the task's description and marking task as in-progress or done
 */
public class UpdateTask {
    ObjectMapper mapper = new ObjectMapper();
    ArrayList<Task> tasksList= new ArrayList<>();

    public static void main(String[] args) {
        UpdateTask t = new UpdateTask();
        t.markInProgress(1);
    }

    public UpdateTask() {
        try {
            tasksList = mapper.readValue(
                    new File("data.json"),
                    new TypeReference<ArrayList<Task>>() {}
            );
        } catch (IOException e) {
            System.out.println("Task List is empty!");
        }
    }

    public void updateDescription(int id, String description) {
        boolean updated = false;

        for (Task task : tasksList) {
            if (task.getId() == id) {
                updated = true;
                task.setDescription(description);
                task.setUpdatedAt();
            }
        }

        if (!updated) {
            System.out.println("Invalid Command! Can not update a task that does not exist.");
        }

        updateJson();
    }

    public void markInProgress(int id) {
        for (Task task : tasksList) {
            if (task.getId() == id) {
                task.setStatus("in-progress");
            }
        }

        updateJson();
    }

    public void markDone(int id) {
        for (Task task : tasksList) {
            if (task.getId() == id) {
                task.setStatus("done");
            }
        }

        updateJson();
    }

    private void updateJson() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("data.json"), tasksList);
        } catch (IOException e) {
            System.out.println("Due to some issue your task could not be updated!");
        }
    }
}