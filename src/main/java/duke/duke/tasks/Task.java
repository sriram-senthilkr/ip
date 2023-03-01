package duke.tasks;

/**
 * The base task class
 */
public class Task {
    protected String taskName;
    protected boolean isDone;

    /**
     * Stores name of task
     * 
     * @param taskName name of the task
     */

    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    /**
     * Returns the name of the task
     * 
     * @return name of the task
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * Returns "X" if task is done, " " otherwise
     * 
     * @return isDone status of the task
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Sets isDone status of the task as true
     */
    public void setDone() {
        this.isDone = true;
    }

    /**
     * Sets isDone status of the task as false
     */
    public void setUndone() {
        this.isDone = false;
    }

    /**
     * Returns isDone status and name of task in CLI format
     * 
     * @return formatted task description for CLI display
     */
    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.getTaskName();
    }

    /**
     * Returns isDone status and name of task in .txt format
     * 
     * @return formatted task description to store in .txt file
     */
    public String formatted() {
        return " / " + this.getStatusIcon() + " / " + this.getTaskName();
    }

}
