package duke.managers;

import duke.exceptions.DukeException;
import duke.ui.Ui;

public class CommandManager {

    public static void handleCommand(TaskManager t, String currentInput) {
        String command = currentInput.split(" ")[0];
        Ui.printHorizontalLine();
        try {
            switch (command) {
            case "mark":
                t.markTask(currentInput);
                break;
            case "unmark":
                t.unmarkTask(currentInput);
                break;
            case "deadline":
                t.addDeadline(currentInput);
                break;
            case "list":
                t.listTasks();
                break;
            case "todo":
                t.addTodo(currentInput);
                break;
            case "event":
                t.addEvent(currentInput);
                break;
            case "bye":
                Ui.printFarewell();
                System.exit(0);
            default:
                throw new DukeException();
            }
        } catch (DukeException e) {
            System.out.println("\tunknown command");
        }
        Ui.printHorizontalLine();
    }
}
