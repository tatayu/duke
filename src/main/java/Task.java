public class Task {
    protected String description;
    protected boolean isDone;
    protected int Done = 0;

    public Task(String description){
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon(){
        return (isDone ? "[\u2713]" : "[\u2718]");
    }

    public void markAsDone(){
        isDone = true;
        Done = 1;
    }

    public String toString(){
        return (getStatusIcon());
    }

    public String Save(){
        return String.format("%d|%s",Done,description);
    }
}
