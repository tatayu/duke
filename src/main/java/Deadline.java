public class Deadline extends Task{

    protected String by;

    public Deadline(String description, String by){
        super(description);
        this.by = by;
    }

    @Override
    public String toString(){
        return "[D]" + super.toString() + description + "(by: " + by + ")";
    }

    @Override
    public String Save(){
        return String.format("D|%s|%s",super.Save(),by);
    }
}
