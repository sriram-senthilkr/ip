package duke.tasks;

public class Deadline extends Task {
    protected String by;

    /**
     * Stores the deadline event's name and dealine
     * 
     * @param taskName name of the task
     * @param by       dealdine of task
     */
    public Deadline(String taskName, String by) {
        super(taskName);
        this.by = by;
    }

    /**
     * Returns type of task, isDone status, name of task, and due date in .txt
     * format
     * 
     * @return formatted task description for CLI display
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + by + ")";
    }

    /**
     * Returns type of task, isDone status, name of task, and due date in .txt
     * format
     * 
     * @return formatted task description to store in .txt file
     */
    @Override
    public String formatted() {
        return "D" + super.formatted() + " / " + by;
    }
}
