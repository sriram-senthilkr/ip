package duke;

import java.util.Scanner;

import duke.managers.*;
import duke.ui.Ui;

public class Duke {

    public static void main(String[] args) {

        TaskManager t = new TaskManager();
        FileManager.retrieveFileContents(t);
        Ui.printGreetings();
        Scanner userInput = new Scanner(System.in);

        while (true) {
            String currentInput = userInput.nextLine();
            CommandManager.handleCommand(t, currentInput);
        }
    }

}
