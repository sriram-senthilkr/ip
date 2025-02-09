package duke.managers;

import duke.exceptions.InvalidCommandException;
import java.lang.ArrayIndexOutOfBoundsException;
import duke.ui.Ui;

/**
 * Handles the commands input by the user
 */
public class CommandManager {

    /**
     * Takes in the command input by the user, and executes the corresponing
     * operation
     * 
     * @param t            the TaskManager object that hold the task list
     * @param currentInput entire line of input by user
     * @throws InvalidCommandException        if the command is invalid
     * @throws ArrayIndexOutOfBoundsException if the command is correct, but the
     *                                        format of command is incorrect
     */
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
            case "find":
                t.findTask(currentInput);
                break;
            case "delete":
                t.deleteTask(currentInput);
                break;
            case "help":
                Ui.printHelp();
                break;
            case "bye":
                FileManager.writeToFile(t);
                Ui.printFarewell();
                System.exit(0);
            default:
                throw new InvalidCommandException();
            }
        } catch (InvalidCommandException e) {
            System.out.println(InvalidCommandException.invalidCommandMessage);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(
                    "\tYou have not followed the correct input format! \n\tFor guidance on the format, type 'help'.");
        }
        Ui.printHorizontalLine();
    }
}
