import java.util.Scanner;

public class Duke {
    private static String LINE = "    ____________________________________________________________";

    public static void main(String[] args) {

        /**
         * Duke greetings
         */
        String logo = " ____        _        \n" + "|  _ \\ _   _| | _____ \n" + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n" + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("    Hello! I'm Duke\n    What can I do for you?");
        System.out.println(LINE + "\n");

        /**
         * Takes in user inputs, and echoes them. If user input == "bye", then program
         * exits
         */
        Scanner userInput = new Scanner(System.in);
        String currentInput = userInput.nextLine();

        TaskManager t = new TaskManager();
        while (!"bye".equals(currentInput)) {
            System.out.println(LINE);

            // marks the task as completed
            if (currentInput.startsWith("mark")) {
                t.markTask(currentInput);

                // unmarks the task
            } else if (currentInput.startsWith("unmark")) {
                t.unmarkTask(currentInput);

                // sets deadline to the task
            } else if (currentInput.startsWith("deadline")) {
                t.addDeadline(currentInput);

                // lists the task
            } else if (currentInput.startsWith("list")) {
                t.listTasks();

                // adds a todo task
            } else if (currentInput.startsWith("todo")) {
                t.addTodo(currentInput);

                // adds event task
            } else if (currentInput.startsWith("event")) {
                t.addEvent(currentInput);

                // adds the given task to collection
            } else {
                System.out.println("    " + "added: " + currentInput);
                t.addTask(currentInput);
            }

            System.out.println(LINE + "\n");
            currentInput = userInput.nextLine();
        }

        /**
         * Duke exits
         */
        System.out.println(LINE);
        System.out.println("    " + "Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }
}
