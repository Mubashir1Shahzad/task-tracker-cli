package com.tasktracker;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments provided.");
            return;
        }

        String operation = args[0];

        boolean validAdd = args[0].equals("add");
        boolean validDelete = args[0].equals("delete");
        boolean validateMark = (args[0].split("-")[0].equals("mark"));

        // proceeds only in case, exactly 2 arguments are provided for add, delete, mark-in-progress and mark-done commands
        if (( validAdd || validDelete || validateMark) && (args.length != 2)) {
            System.out.println("Invalid number of arguments provided to " + args[0] + " command.");
            return;
        }

        // proceeds if correct number of arguments are provided for list
        if ((args[0].equals("list")) && (args.length > 2)) {
            System.out.println("Invalid number of arguments provided to list command.");
            return;
        }

        // proceeds if correct number of arguments are provided for update
        if ((args[0].equals("update")) && (args.length != 3)) {
            System.out.println("Invalid number of arguments provided to update command.");
            return;
        }

        switch (operation) {
            case "add":
                AddTask addTask = new AddTask();
                addTask.addTaskToJson(args[1]);
                break;

            case "update":
                UpdateTask updateTask = new UpdateTask();
                updateTask.updateDescription(Integer.parseInt(args[1]), args[2]);
                break;

            case "delete":
                DeleteTask deleteTask = new DeleteTask();
                deleteTask.deleteTask(Integer.parseInt(args[1]));
                break;

            case "list":
                ListTasks listTasks = new ListTasks();
                if (args.length == 1) {
                    listTasks.listAllTasks();
                } else if (args[1].equals("done")) {
                    listTasks.listTasksDone();
                } else if (args[1].equals("todo")) {
                    listTasks.listTasksToDo();;
                } else if (args[1].equals("in-progress")){
                    listTasks.listTasksInProgress();
                }
                break;

            case "mark-in-progress":
                UpdateTask markAsInProgress = new UpdateTask();
                markAsInProgress.markInProgress(Integer.parseInt(args[1]));
                break;

            case "mark-done":
                UpdateTask markAsDone = new UpdateTask();
                markAsDone.markDone(Integer.parseInt(args[1]));
                break;

            default:
                System.out.println("Arguments given are not correct.");
                break;
        }
    }
}