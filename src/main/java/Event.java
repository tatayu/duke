public class Event extends Task {

    protected String by;

    /**
     * Take the user input and set description and by
     * @param description the description of the task
     * @param by the timeline set by the user
     */
    public Event(String description, String by){
        super(description);
        this.by = by;
    }

    /**
     * Convert the user input to a string in displaced format
     * @return the string of the user input in displaced format
     */
    @Override
    public String toString(){
        return "[E]" + super.toString() + description + "(at: " + by + ")";
    }

    /**
     * Convert the user input to a string in saved format
     * @return the string of the user input in saved format
     */
    @Override
    public String Save(){
         return String.format("E|%s|%s",super.Save(),by);
    }
}
