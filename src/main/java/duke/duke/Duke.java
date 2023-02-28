package duke;

import java.util.Scanner;

import duke.managers.CommandManager;
import duke.managers.TaskManager;
import duke.managers.FileManager;
import duke.ui.Ui;

public class Duke {

    public static void main(String[] args) {

        TaskManager t = new TaskManager();
        // t.retrieveFileContents();
        FileManager.retrieveFileContents(t);
        Ui.printGreetings();
        Scanner userInput = new Scanner(System.in);

        while (true) {
            String currentInput = userInput.nextLine();
            CommandManager.handleCommand(t, currentInput);
        }
    }

}
