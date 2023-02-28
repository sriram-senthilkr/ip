package duke;

import java.util.Scanner;

import duke.managers.CommandManager_2;
import duke.managers.TaskManager_2;
import duke.ui.Ui;

public class Duke {

    public static void main(String[] args) {

        TaskManager_2 t = new TaskManager_2();
        Ui.printGreetings();
        Scanner userInput = new Scanner(System.in);

        while (true) {
            String currentInput = userInput.nextLine();
            CommandManager_2.handleCommand(t, currentInput);
        }
    }

}
