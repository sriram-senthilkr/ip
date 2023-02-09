import java.util.Scanner;

public class Duke {
    private static String LINE = "    ____________________________________________________________";

    public static void printGreetings() {
        /**
         * Duke greetings
         */
        String logo = " ____        _        \n" + "|  _ \\ _   _| | _____ \n" + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n" + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("    Hello! I'm Duke\n    What can I do for you?");
        System.out.println(LINE + "\n");
    }

    public static void printFarewell() {
        System.out.println("\tBye. Hope to see you again soon!");
        printHorizontalLine();
    }

    public static void printHorizontalLine() {
        System.out.println(LINE);
    }

    public static void main(String[] args) {

        printGreetings();

        /**
         * Takes in user inputs, and echoes them. If user input == "bye", then program
         * exits
         */
        Scanner userInput = new Scanner(System.in);
        String currentInput = userInput.nextLine();

        TaskManager t = new TaskManager();

        String command = currentInput.split(" ")[0];

        while (true) {
            printHorizontalLine();
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
                printFarewell();
                System.exit(0);
            default:
                System.out.println(" " + "added: " + currentInput);
                t.addTask(currentInput);
            }
            printHorizontalLine();
            currentInput = userInput.nextLine();
            command = currentInput.split(" ")[0];
        }

    }

}
