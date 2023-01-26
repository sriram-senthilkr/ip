public class TaskManager {
    private Task[] tasks = new Task[100];
    private int taskCount = 0;

    public void addTask(String task) {
        tasks[taskCount] = new Task(task);
        taskCount++;
    }

    public void listTasks() {
        for (int i = 0; i < taskCount; i++) {
            System.out.println("    " + (i + 1) + ". " + tasks[i].getTaskName());
        }
    }
}
