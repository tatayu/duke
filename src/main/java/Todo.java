public class Todo extends Task {

    protected String by;

    /**
     * Take the user input and set description and by
     * @param description the description of the task
     */
    public Todo(String description){

        super(description);
    }

    /**
     * Convert the user input to a string in displaced format
     * @return the string of the user input in displaced format
     */
    @Override
    public String toString(){

        return "[T]" + super.toString()+ description;
    }

    /**
     * Convert the user input to a string in saved format
     * @return the string of the user input in saved format
     */
    @Override
    public String Save(){

        return String.format("T|%s",super.Save());
    }
}
