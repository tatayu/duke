public class Task {
    protected String description;
    protected boolean isDone;
    protected int Done = 0;

    /**
     * Set the description and the status of the task
     * @param description the description of the task
     */
    public Task(String description){
        this.description = description;
        this.isDone = false;
    }

    /**
     * Check and get the status of the task
     * @return the string of the status of the task
     */
    public String getStatusIcon(){
        return (isDone ? "[Y]" : "[N]");
    }

    /**
     * change the status of the task by marking it as done
     */
    public void markAsDone(){
        isDone = true;
        Done = 1;
    }

    /**
     * Convert the status of the task to string
     * @return the status of the task to string
     */
    public String toString(){
        return (getStatusIcon());
    }

    /**
     * Get the string of the task and its status in saved format
     * @return the string of the task and its status in saved format
     */
    public String Save(){
        return String.format("%d|%s",Done,description);
    }
}
