package duke.managers;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.Todo;
import java.util.ArrayList;

/**
 * Handles all operations related to modifying the task in tasks tasks is an
 * ArrayList containing all the input task
 */

public class TaskManager {
    public ArrayList<Task> tasks = new ArrayList<Task>();
    public int taskCount = 0;

    /**
     * Adds a task to collection, and increases the count of tasks
     * 
     * @param task name of task to be added to the list
     */
    public void addTask(String task) {
        tasks.add(new Task(task));
        taskCount++;
    }

    /**
     * Lists all the tasks in Task
     * 
     */
    public void listTasks() {
        System.out.println("\tHere are the tasks in your list:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println("\t" + (i + 1) + ". " + tasks.get(i).toString());
        }
    }

    /**
     * Marks the task from the number of the task given
     * 
     * @param currentInput the entire string of input from the user
     */
    public void markTask(String currentInput) {
        String[] modifyTask = currentInput.split(" ");
        int taskIndex = Integer.parseInt(modifyTask[1]) - 1;
        tasks.get(taskIndex).setDone();
        System.out.println("\tNice! I've marked this task as done:");
        System.out.println("    " + "[X] " + tasks.get(taskIndex).getTaskName());
    }

    /**
     * Unmarks the task from the number of the task given
     * 
     * @param currentInput the entire string of input from the user
     */
    public void unmarkTask(String currentInput) {
        String[] modifyTask = currentInput.split(" ");
        int taskIndex = Integer.parseInt(modifyTask[1]) - 1;
        tasks.get(taskIndex).setUndone();
        System.out.println("\tOK, I've marked this task as not done yet:");
        System.out.println("    " + "[ ] " + tasks.get(taskIndex).getTaskName());
    }

    /**
     * Adds deadline-task to task list
     * 
     * @param currentInput the entire string of input from the user
     */
    public void addDeadline(String currentInput) {
        String[] operation = currentInput.split("/by ");
        String by = operation[1];
        String taskName = operation[0].replace("deadline ", "");
        Task deadline = new Deadline(taskName, by);
        tasks.add(deadline);
        taskCount++;
        System.out.println("\tGot it. I've added this task:\n" + "\t  " + deadline.toString());
        System.out.println("\tNow you have " + taskCount + " tasks in the list.");
    }

    /**
     * Adds todo-task to task list
     * 
     * @param currentInput the entire string of input from the user
     */
    public void addTodo(String currentInput) {
        String[] operation = currentInput.split("todo ");
        String taskName = operation[1];
        Task todo = new Todo(taskName);
        tasks.add(todo);
        taskCount++;
        System.out.println("\tGot it. I've added this task:\n" + "\t" + todo.toString());
        System.out.println("\tNow you have " + taskCount + " tasks in the list.");
    }

    /**
     * Adds event-task to task list
     * 
     * @param currentInput the entire string of input from the user
     */
    public void addEvent(String currentInput) {
        String[] operation = currentInput.split("/from");
        String[] operation2 = operation[1].split("/to");
        String from = operation2[0];
        String to = operation2[1];
        String taskName = operation[0].replace("event ", "");
        Task event = new Event(taskName, from, to);
        tasks.add(event);
        taskCount++;
        System.out.println("\tGot it. I've added this task:\n" + "\t  " + event.toString());
        System.out.println("\tNow you have " + taskCount + " tasks in the list.");
    }

    /**
     * Deletes task from task list
     * 
     * @param currentInput the entire string of input from the user
     */
    public void deleteTask(String currentInput) {
        String[] modifyTask = currentInput.split(" ");
        int taskIndex = Integer.parseInt(modifyTask[1]) - 1;
        System.out.println("\tNoted. I've removed this task:");
        System.out.println("\t" + tasks.get(taskIndex).toString());
        tasks.remove(taskIndex);
        taskCount--;
        System.out.println("\tNow you have " + taskCount + " tasks in the list.");
    }

    /**
     * Finds given task
     * 
     * @param currentInput the entire string of input from the user
     */
    public void findTask(String currentInput) {
        int count = 0;
        String[] modifyTask = currentInput.split(" ", 2);
        System.out.println("\tHere are the matching tasks in your list:");
        for (Task task : tasks) {
            if (task.getTaskName().equals(modifyTask[1]) || task.getTaskName().equals(modifyTask[1] + " ")) {
                count++;
                System.out.println("\t" + count + ". " + task.toString());
            }
        }
        if (count == 0) {
            System.out.println("\tSorry there were no matching tasks :(");
        }
    }

}
