package duke.managers;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.Todo;

public class TaskManager {
    private Task[] tasks = new Task[100];
    private int taskCount = 0;

    /**
     * Adds a task to collection
     */
    public void addTask(String task) {
        tasks[taskCount] = new Task(task);
        taskCount++;
    }

    /**
     * Lists all the tasks in Task
     */
    public void listTasks() {
        System.out.println("\tHere are the tasks in your list:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println("\t" + (i + 1) + ". " + tasks[i].toString());
        }
    }

    /**
     * Marks the task from the number of the task given
     */
    public void markTask(String currentInput) {
        String[] modifyTask = currentInput.split(" ");
        int taskIndex = Integer.parseInt(modifyTask[1]) - 1;
        tasks[taskIndex].setDone();
        System.out.println("\tNice! I've marked this task as done:");
        System.out.println("    " + "[X] " + tasks[taskIndex].getTaskName());
    }

    /**
     * Unmarks the task from the number of the task given
     */
    public void unmarkTask(String currentInput) {
        String[] modifyTask = currentInput.split(" ");
        int taskIndex = Integer.parseInt(modifyTask[1]) - 1;
        tasks[taskIndex].setUndone();
        System.out.println("\tOK, I've marked this task as not done yet:");
        System.out.println("    " + "[ ] " + tasks[taskIndex].getTaskName());
    }

    /**
     * Adds deadline to task, and adds it to collection
     */
    public void addDeadline(String currentInput) {
        String[] operation = currentInput.split("/by");
        String by = operation[1];
        String taskName = operation[0].replace("deadline ", "");
        Task deadline = new Deadline(taskName, by);
        tasks[taskCount] = deadline;
        taskCount++;
        System.out.println("\tGot it. I've added this task:\n" + "\t  " + deadline.toString());
        System.out.println("\tNow you have " + taskCount + " tasks in the list.");
    }

    /**
     * Adds todo to task, and adds it to collection
     */
    public void addTodo(String currentInput) {
        String[] operation = currentInput.split("todo ");
        String taskName = operation[1];
        Task todo = new Todo(taskName);
        tasks[taskCount] = todo;
        taskCount++;
        System.out.println("\tGot it. I've added this task:\n" + "\t" + todo.toString());
        System.out.println("\tNow you have " + taskCount + " tasks in the list.");
    }

    /**
     * Adds event to task, and adds it to collection
     */
    public void addEvent(String currentInput) {
        String[] operation = currentInput.split("/from");
        String[] operation2 = operation[1].split("/to");
        String from = operation2[0];
        String to = operation2[1];
        String taskName = operation[0].replace("event ", "");
        Task event = new Event(taskName, from, to);
        tasks[taskCount] = event;
        taskCount++;
        System.out.println("\tGot it. I've added this task:\n" + "\t  " + event.toString());
        System.out.println("\tNow you have " + taskCount + " tasks in the list.");
    }

}
