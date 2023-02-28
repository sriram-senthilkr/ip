package duke.managers;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.Todo;
import java.util.ArrayList;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TaskManager {
    // private Task[] tasks = new Task[100];
    private ArrayList<Task> tasks = new ArrayList<Task>();
    private int taskCount = 0;

    private static String FILEPATH = "src/main/java/duke/duke/data/duke.txt";

    public void retrieveFileContents() {
        try {
            File f = new File(FILEPATH);
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String nextLine = s.nextLine();
                String[] inputSplit = nextLine.split(" / ");
                String taskType = inputSplit[0];
                switch (taskType) {
                case "T":
                    addExistingTask(inputSplit[1], inputSplit[2]);
                    break;
                case "D":
                    addExistingDeadline(inputSplit[1], inputSplit[2], inputSplit[3]);
                    break;
                case "E":
                    addExistingEvent(inputSplit[1], inputSplit[2], inputSplit[3], inputSplit[4]);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            try {
                File newFile = new File(FILEPATH);
                newFile.createNewFile();
                System.out.println("File created: " + newFile.getName());
            } catch (IOException f) {
                System.out.println("File couldn't be created");
                f.printStackTrace();
            }

        }
    }

    /*
     * Add existing task to collection
     */
    public void addExistingTask(String status, String taskName) {
        Task todo = new Todo(taskName);
        tasks[taskCount] = todo;
        if (status.equals("X")) {
            tasks[taskCount].setDone();
        }
        taskCount++;
    }

    /*
     * Add existing deadline to collection
     */
    public void addExistingDeadline(String status, String taskName, String givenDeadline) {
        Task deadline = new Deadline(taskName, givenDeadline);
        tasks[taskCount] = deadline;
        if (status.equals("X")) {
            tasks[taskCount].setDone();
        }
        taskCount++;
    }

    /*
     * Add existing deadline to collection
     */
    public void addExistingEvent(String status, String taskName, String startDate, String endDate) {
        Task event = new Event(taskName, startDate, endDate);
        tasks[taskCount] = event;
        if (status.equals("X")) {
            tasks[taskCount].setDone();
        }
        taskCount++;
    }

    /*
     * write task to .txt file
     */
    public void writeToFile() {
        try {
            FileWriter fw = new FileWriter(FILEPATH);
            for (int i = 0; i < taskCount; i++) {
                fw.write(tasks[i].formatted() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    /**
     * Adds a task to collection
     */
    public void addTask(String task) {
        tasks.add(new Task(task));
        taskCount++;
    }

    /**
     * Lists all the tasks in Task
     */
    public void listTasks() {
        System.out.println("\tHere are the tasks in your list:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println("\t" + (i + 1) + ". " + tasks.get(i).toString());
        }
    }

    /**
     * Marks the task from the number of the task given
     */
    public void markTask(String currentInput) {
        String[] modifyTask = currentInput.split(" ");
        int taskIndex = Integer.parseInt(modifyTask[1]) - 1;
        tasks.get(taskIndex).setDone();
        System.out.println("\tNice! I've marked this task as done:");
        System.out.println("    " + "[X] " + tasks.get(taskIndex).getTaskName());
    }

    /**
     * Unmarks the task from the number of the task given
     */
    public void unmarkTask(String currentInput) {
        String[] modifyTask = currentInput.split(" ");
        int taskIndex = Integer.parseInt(modifyTask[1]) - 1;
        tasks.get(taskIndex).setUndone();
        System.out.println("\tOK, I've marked this task as not done yet:");
        System.out.println("    " + "[ ] " + tasks.get(taskIndex).getTaskName());
    }

    /**
     * Adds deadline to task, and adds it to collection
     */
    public void addDeadline(String currentInput) {
        String[] operation = currentInput.split("/by");
        String by = operation[1];
        String taskName = operation[0].replace("deadline ", "");
        Task deadline = new Deadline(taskName, by);
        tasks.add(deadline);
        taskCount++;
        System.out.println("\tGot it. I've added this task:\n" + "\t  " + deadline.toString());
        System.out.println("\tNow you have " + taskCount + " tasks in the list.");
    }

    /**
     * Adds todo to task, and adds it to collection
     */
    public void addTodo(String currentInput) {
        String[] operation = currentInput.split("todo ");
        String taskName = operation[1];
        Task todo = new Todo(taskName);
        tasks.add(todo);
        taskCount++;
        System.out.println("\tGot it. I've added this task:\n" + "\t" + todo.toString());
        System.out.println("\tNow you have " + taskCount + " tasks in the list.");
    }

    /**
     * Adds event to task, and adds it to collection
     */
    public void addEvent(String currentInput) {
        String[] operation = currentInput.split("/from");
        String[] operation2 = operation[1].split("/to");
        String from = operation2[0];
        String to = operation2[1];
        String taskName = operation[0].replace("event ", "");
        Task event = new Event(taskName, from, to);
        tasks.add(event);
        taskCount++;
        System.out.println("\tGot it. I've added this task:\n" + "\t  " + event.toString());
        System.out.println("\tNow you have " + taskCount + " tasks in the list.");
    }

    /**
     * Deletes event from task, and removes it from collection
     */
    public void deleteTask(String currentInput) {
        String[] modifyTask = currentInput.split(" ");
        int taskIndex = Integer.parseInt(modifyTask[1]) - 1;
        System.out.println("\tNoted. I've removed this task:");
        System.out.println("\t" + tasks.get(taskIndex).toString());
        tasks.remove(taskIndex);
        taskCount--;
        System.out.println("\tNow you have " + taskCount + " tasks in the list.");
    }

}
