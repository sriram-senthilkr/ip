package duke.tasks;

public class Todo extends Task {

    /**
     * Saves name os task to Todo class
     * 
     * @param name of task
     */
    public Todo(String taskName) {
        super(taskName);
    }

    /**
     * Returns type of task, isDone status and name of task in CLI format
     * 
     * @return formatted task description for CLI display
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Returns type of task, isDone status and name of task in .txt format
     * 
     * @return formatted task description to store in .txt file
     */
    @Override
    public String formatted() {
        return "T" + super.formatted();
    }
}
