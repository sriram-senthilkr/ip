package duke.ui;

/**
 * Handles pre-set User Interface elements of the application
 */
public class Ui {
    private static String LINE = "\t____________________________________________________________";
    private static String HELPMESSAGE = "\tWelcome to the help desk! Here are a list of commands that you can input: \n\n"
            + "\tGENERAL COMMANDS: \n" + "\t1. list -> \n" + "\t\tlists the tasks in your list. \n"
            + "\t2. find 'XXXX' -> \n" + "\t\tfind XXXX from all tasks, and lists them. \n" + "\t3. mark X -> \n"
            + "\t\tmarks the task at position X as 'done'. \n" + "\t4. unmark X -> \n"
            + "\t\tunmarks the task at position X as 'undone'. \n" + "\t5. delete X -> \n"
            + "\t\tdeletes the task at position X. \n" + "\t6. bye -> \n" + "\t\texits the application. \n\n"
            + "\tADDING TASKS: \n" + "\t1. todo 'XXXX' -> \n" + "\t\tadds a new todo task XXXX to the list. \n"
            + "\t2. deadline 'XXXX' /by 'YYYY' -> \n"
            + "\t\tadds a task with a deadline, with XXXX being the task and YYYY being the deadline. \n"
            + "\t3. event 'XXXX' /from 'YYYY' /to 'ZZZZ' -> \n"
            + "\t\tadds an event, with XXXX as the event name, YYYY as the start date, and ZZZZ as the end date.";

    /**
     * Prints a horizontal line
     */
    public static void printHorizontalLine() {
        System.out.println(LINE);
    }

    /**
     * Prints out greetings
     */
    public static void printGreetings() {
        String logo = " ____        _        \n" + "|  _ \\ _   _| | _____ \n" + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n" + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("\tHello! I'm Duke\n\tWhat can I do for you?");
        System.out.println(LINE + "\n");
    }

    /**
     * Print Farewell
     */
    public static void printFarewell() {
        System.out.println("\tBye. Hope to see you again soon!");
        printHorizontalLine();
    }

    /**
     * Prints out list of commands that can be executed
     */
    public static void printHelp() {
        System.out.println(HELPMESSAGE);
    }

}
