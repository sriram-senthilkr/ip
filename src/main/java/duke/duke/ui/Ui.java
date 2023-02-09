package duke.ui;

public class Ui {
    private static String LINE = "    ____________________________________________________________";

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

}
