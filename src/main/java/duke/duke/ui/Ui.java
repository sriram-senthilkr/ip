package duke.ui;

public class Ui {
    private static String LINE = "\t____________________________________________________________";
    private static String HELPMESSAGE = "\tWelcome to the help desk! Here are a list of commands that you can input: \n\n"
            + "\tGENERAL COMMANDS: \n" + "\t1. list -> \n" + "\t\tlists the tasks in your list. \n"
            + "\t2. mark X -> \n" + "\t\tmarks the task at position X as 'done'. \n" + "\t3. unmark X -> \n"
            + "\t\tunmarks the task at position X as 'undone'. \n" + "\t4. bye -> \n"
            + "\t\texits the application. \n\n" + "\tADDING TASKS: \n" + "\t5. todo 'XXXX' -> \n"
            + "\t\tadds a new todo task XXXX to the list. \n" + "\t6. deadline 'XXXX' /by 'YYYY' -> \n"
            + "\t\tadds a task with a deadline, with XXXX being the task and YYYY being the deadline. \n"
            + "\t7. event 'XXXX' /from 'YYYY' /to 'ZZZZ' -> \n"
            + "\t\tadds an event, with XXXX as the event name, YYYY as the start date, and ZZZZ as the end date.";

    public static void printHorizontalLine() {
        System.out.println(LINE);
    }

    /**
     * Duke greetings
     */
    public static void printGreetings() {
        String logo = " ____        _        \n" + "|  _ \\ _   _| | _____ \n" + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n" + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("\tHello! I'm Duke\n\tWhat can I do for you?");
        System.out.println(LINE + "\n");
    }

    /*
     * Print Farewell
     */
    public static void printFarewell() {
        System.out.println("\tBye. Hope to see you again soon!");
        printHorizontalLine();
    }

    public static void printHelp() {
        System.out.println(HELPMESSAGE);
    }

}
