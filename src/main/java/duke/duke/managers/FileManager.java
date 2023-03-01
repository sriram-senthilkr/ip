package duke.managers;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.Todo;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Handles the reading and writing of .txt file
 */
public class FileManager {

    /**
     * Retrieves contents of current .txt file, and adds the content to the current
     * task list
     * 
     * @param t the TaskManager object that hold the task list
     * @throws FileNotFoundException if the file does not already exist, and will
     *                               create a new one
     * @throws IOException           if the file is not successfully created
     */
    public static void retrieveFileContents(TaskManager t) {
        try {
            File f = new File("dukeData.txt");
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String nextLine = s.nextLine();
                String[] inputSplit = nextLine.split(" / ");
                String taskType = inputSplit[0];
                switch (taskType) {
                case "T":
                    addExistingTask(inputSplit[1], inputSplit[2], t);
                    break;
                case "D":
                    addExistingDeadline(inputSplit[1], inputSplit[2], inputSplit[3], t);
                    break;
                case "E":
                    addExistingEvent(inputSplit[1], inputSplit[2], inputSplit[3], inputSplit[4], t);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            try {
                File newFile = new File("dukeData.txt");
                newFile.createNewFile();
                System.out.println("File created: " + newFile.getName());
            } catch (IOException f) {
                System.out.println("File couldn't be created");
                f.printStackTrace();
            }

        }
    }

    /**
     * Writes to .txt file the current tasks, once user enters 'bye'
     * 
     * @param t the TaskManager object that hold the task list
     * @throws IOException if there is an error while writing to .txt file
     */
    public static void writeToFile(TaskManager t) {
        try {
            FileWriter fw = new FileWriter("dukeData.txt");
            for (int i = 0; i < t.taskCount; i++) {
                fw.write(t.tasks.get(i).formatted() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    /**
     * Adds existing Todo task from .txt file to given task list
     * 
     * @param status   isDone status of the given task
     * @param taskName name of given task
     * @param t        the TaskManager object that hold the task list
     */
    public static void addExistingTask(String status, String taskName, TaskManager t) {
        Task todo = new Todo(taskName);
        t.tasks.add(todo);
        if (status.equals("X")) {
            t.tasks.get(t.taskCount).setDone();
        }
        t.taskCount++;
    }

    /**
     * Adds existing Deadline task from .txt file to given task list
     * 
     * @param status        isDone status of the given task
     * @param taskName      name of given task
     * @param givenDeadline deadline of given task
     * @param t             the TaskManager object that hold the task list
     */
    public static void addExistingDeadline(String status, String taskName, String givenDeadline, TaskManager t) {
        Task deadline = new Deadline(taskName, givenDeadline);
        t.tasks.add(deadline);
        if (status.equals("X")) {
            t.tasks.get(t.taskCount).setDone();
        }
        t.taskCount++;
    }

    /**
     * Adds existing Event task from .txt file to given task list
     * 
     * @param status    isDone status of the given task
     * @param taskName  name of given task
     * @param startDate start date of given task
     * @param endDate   end date of given task
     * @param t         the TaskManager object that hold the task list
     */
    public static void addExistingEvent(String status, String taskName, String startDate, String endDate,
            TaskManager t) {
        Task event = new Event(taskName, startDate, endDate);
        t.tasks.add(event);
        if (status.equals("X")) {
            t.tasks.get(t.taskCount).setDone();
        }
        t.taskCount++;
    }
}
