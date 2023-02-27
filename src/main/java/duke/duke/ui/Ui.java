package duke.ui;

public class Ui {
    private static String LINE = "    ____________________________________________________________";
    private static String HELPMESSAGE = "    Welcome to the help desk! Here are a list of commands that you can input. \n"
            + "    1. list : \n" + "\tlists the tasks in your list. \n" + "    2. mark X : \n"
            + "\tmarks the task at position X as 'done' \n" + "    3. unmark X : \n"
            + "\tunmarks the task at position X as 'undone' \n" + "    4. deadline 'XXXX' /by 'YYYY' : \n"
            + "\tadds a task with a deadline, with XXXX being the task and YYYY being the deadline \n"
            + "    5. event 'XXXX' /from 'YYYY' /to 'ZZZZ' : \n"
            + "\tadds an event, with XXXX as the event name, YYYY as the start date, and ZZZZ as the end date";

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

        System.out.println("    Hello! I'm Duke\n    What can I do for you?");
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
