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

public class FileManager {
    /*
     * retrieve contents of current .txt file
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

    /*
     * write task to .txt file
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

    /*
     * Add existing task to collection
     */
    public static void addExistingTask(String status, String taskName, TaskManager t) {
        Task todo = new Todo(taskName);
        t.tasks.add(todo);
        if (status.equals("X")) {
            t.tasks.get(t.taskCount).setDone();
        }
        t.taskCount++;
    }

    /*
     * Add existing deadline to collection
     */
    public static void addExistingDeadline(String status, String taskName, String givenDeadline, TaskManager t) {
        Task deadline = new Deadline(taskName, givenDeadline);
        t.tasks.add(deadline);
        if (status.equals("X")) {
            t.tasks.get(t.taskCount).setDone();
        }
        t.taskCount++;
    }

    /*
     * Add existing deadline to collection
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
