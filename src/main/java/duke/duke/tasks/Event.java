package duke.tasks;

/**
 * Handles Event-type of tasks
 */
public class Event extends Task {
    protected String from;
    protected String to;

    /**
     * Stores the event's name, start time, and end time
     * 
     * @param taskName name of the task
     * @param from     start time of the task
     * @param to       end time of the task
     */
    public Event(String taskName, String from, String to) {
        super(taskName);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns type of task, isDone status, name of task, and its from-to data in
     * CLI format
     * 
     * @return formatted task description for CLI display
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from:" + from + "to:" + to + ")";
    }

    /**
     * Returns type of task, isDone status, name of task, and its from-to data .txt
     * format
     * 
     * @return formatted task description to store in .txt file
     */
    @Override
    public String formatted() {
        return "E" + super.formatted() + " / " + from + " / " + to;
    }
}
