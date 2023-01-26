public class TaskManager {
    private Task[] tasks = new Task[100];
    private int taskCount = 0;

    public void addTask(String task) {
        tasks[taskCount] = new Task(task);
        taskCount++;
    }

    public void listTasks() {
        System.out.println("    " + "Here are the tasks in your list:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println("    " + (i + 1) + ". [" + tasks[i].getStatusIcon() + "] " + tasks[i].getTaskName());
        }
    }

    public void markTask(String taskNumber) {
        int taskIndex = Integer.parseInt(taskNumber) - 1;
        tasks[taskIndex].setDone();
        System.out.println("    " + "Nice! I've marked this task as done:");
        System.out.println("    " + "[X] " + tasks[taskIndex].getTaskName());
    }

    public void unmarkTask(String taskNumber) {
        int taskIndex = Integer.parseInt(taskNumber) - 1;
        tasks[taskIndex].setUndone();
        System.out.println("    " + "OK, I've marked this task as not done yet:");
        System.out.println("    " + "[ ] " + tasks[taskIndex].getTaskName());
    }

}
