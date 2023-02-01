import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        /*
         * Duke greetings
         */
        String logo = " ____        _        \n" + "|  _ \\ _   _| | _____ \n" + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n" + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("    Hello! I'm Duke\n    What can I do for you?");
        System.out.println("    ____________________________________________________________\n");

        /*
         * Takes in user inputs, and echoes them. If user input == "bye", then program
         * exits
         */
        Scanner userInput = new Scanner(System.in);
        String currentInput = userInput.nextLine();
        // while (!"bye".equals(currentInput)) {
        // System.out.println("
        // ____________________________________________________________");
        // System.out.println(" " + currentInput);
        // System.out.println("
        // ____________________________________________________________\n");
        // currentInput = userInput.nextLine();
        // }

        TaskManager t = new TaskManager();
        while (!"bye".equals(currentInput)) {
            System.out.println("    ____________________________________________________________");

            switch (currentInput) {
            case "list":
                t.listTasks();
                break;
            default:
                System.out.println("    " + "added: " + currentInput);
                t.addTask(currentInput);
                break;
            }
            System.out.println("    ____________________________________________________________\n");
            currentInput = userInput.nextLine();

            if (currentInput.startsWith("mark")) {
                String[] operation = currentInput.split(" ");
                t.markTask(operation[1]);
            } else if (currentInput.startsWith("unmark")) {
                String[] operation = currentInput.split(" ");
                t.unmarkTask(operation[1]);
            } else if ("list".equals(currentInput)) {
                t.listTasks();
            } else {
                System.out.println("    " + "added: " + currentInput);
                t.addTask(currentInput);
            }

            System.out.println("    ____________________________________________________________\n");
            currentInput = userInput.nextLine();
        }

        /*
         * Duke exits
         */
        System.out.println("    ____________________________________________________________");
        System.out.println("    " + "Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
    }
}
