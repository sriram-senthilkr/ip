package duke.managers;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
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
                    t.addExistingTask(inputSplit[1], inputSplit[2]);
                    break;
                case "D":
                    t.addExistingDeadline(inputSplit[1], inputSplit[2], inputSplit[3]);
                    break;
                case "E":
                    t.addExistingEvent(inputSplit[1], inputSplit[2], inputSplit[3], inputSplit[4]);
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
}
