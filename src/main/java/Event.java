public class Event extends Task {

    protected String by;

    public Event(String description, String by){
        super(description);
        this.by = by;
    }

    @Override
    public String toString(){
        return "[E]" + super.toString() + description + "(at: " + by + ")";
    }

    @Override
    public String Save(){
         return String.format("E|%s|%s",super.Save(),by);
    }

}
