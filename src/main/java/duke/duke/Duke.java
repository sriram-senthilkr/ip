package duke;

import java.util.Scanner;

import duke.managers.CommandManager;
import duke.managers.TaskManager;
import duke.ui.Ui;

public class Duke {

    public static void main(String[] args) {

        TaskManager t = new TaskManager();

        Ui.printGreetings();

        Scanner userInput = new Scanner(System.in);
        // String currentInput = userInput.nextLine();
        // String command = currentInput.split(" ")[0];

        while (true) {
            String currentInput = userInput.nextLine();
            CommandManager.handleCommand(t, currentInput);
        }
    }

}
