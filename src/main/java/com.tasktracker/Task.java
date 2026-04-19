package com.tasktracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * General class to be used by all the classes for serialization and deserialization
 */
public class Task {
    private int id;
    private String description;
    private String status;
    private String createdAt;
    private String updatedAt;

    // used by jackson for deserializing
    public Task() {}

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        status = "done";
        createdAt = (LocalDate.now().toString()) + " " + (LocalTime.now().truncatedTo(ChronoUnit.SECONDS).toString());
        updatedAt = createdAt;
    }

    @Override
    public String toString() {
        String taskOutput = "id: " + getId() + "\ndescription: " + getDescription() + "\nstatus: " + getStatus();
        taskOutput += "\ncreatedAt: " + getCreatedAt() + "\nupdatedAt: " + getUpdatedAt() + "\n";
        return taskOutput;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        updatedAt = (LocalDate.now().toString()) + " " + (LocalTime.now().truncatedTo(ChronoUnit.SECONDS).toString());
    }
}