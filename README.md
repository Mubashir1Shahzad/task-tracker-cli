# Task Tracker CLI (Java + Maven)

A simple command-line Task Tracker application built in **Java** using **Maven** for dependency management and project structure.  
This project is based on the Task Tracker challenge from roadmap.sh.
Porject URL: https://roadmap.sh/projects/task-tracker

The application allows users to add, update, delete, and manage tasks directly from the terminal while storing data in JSON format.

---

## Features

- Add new tasks
- Update task descriptions
- Delete tasks
- Mark tasks as:
  - `todo`
  - `in-progress`
  - `done`
- List:
  - All tasks
  - Completed tasks
  - Pending tasks
  - In-progress tasks
- Persistent storage using JSON file
- Simple CLI interface

---

## Why Jackson?

Java does **not include a built-in modern JSON library** for easy object serialization/deserialization.

To solve this, this project uses **Jackson**, one of the most popular JSON libraries for Java.

Jackson is used for:

- Converting Java objects → JSON
- Reading JSON → Java objects
- Storing task data persistently

Official site:

https://github.com/FasterXML/jackson

---

## Tech Stack

- Java
- Maven
- Jackson Databind
- Command Line Interface (CLI)

---

## Project Structure

```bash
task-tracker/
│── src/
│   ├── main/
│   │   └── java/
│   │       └── com/tasktracker/
│   │            ├── Task.java
│   │            ├── AddTask.java
│   │            └── Main.java
|   |            |__ DeleteTask.java
|   |            |__ UpdateTask.java
|   |            |__ ListTasks.java
│── tasks.json
|__ data.json
│── pom.xml
│── README.md
```
## Clone Repository
```bash
git clone https://github.com/Mubashir1Shahzad/task-tracker-cli.git
cd task-tracker-cli
```

## Run Application
```bash
mvn compile exec:java -Dexec.mainClass="com.tasktracker.Main"
```

## Add Task
```bash
mvn compile exec:java -Dexec.mainClass="com.tasktracker.Main" -Dexec.args="add 'Buy groceries'"
```

## Update Task
```bash
mvn compile exec:java -Dexec.mainClass="com.tasktracker.Main" -Dexec.args="update 1 'Buy groceries and cook dinner'"
```

## List All Tasks
```bash
mvn compile exec:java -Dexec.mainClass="com.tasktracker.Main" -Dexec.args="list"
```

## List Completed Tasks
```bash
mvn compile exec:java -Dexec.mainClass="com.tasktracker.Main" -Dexec.args="list done"
```

## List Pending Tasks
```bash
mvn compile exec:java -Dexec.mainClass="com.tasktracker.Main" -Dexec.args="list todo"
```

## List In-Progress Tasks
```bash
mvn compile exec:java -Dexec.mainClass="com.tasktracker.Main" -Dexec.args="list in-progress"
```

## Delete Task
```bash
mvn compile exec:java -Dexec.mainClass="com.tasktracker.Main" -Dexec.args="delete 1"
```
## Mark In-Progress
```bash
mvn compile exec:java -Dexec.mainClass="com.tasktracker.Main" -Dexec.args="mark-in-progress 1"
```
## Mark Completed
```bash
mvn compile exec:java -Dexec.mainClass="com.tasktracker.Main" -Dexec.args="mark-done 1"
```
