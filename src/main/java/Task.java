public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description){
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon(){
        return (isDone ? "[\u2713]" : "[\u2718]");
    }

    public void markAsDone(){
        isDone = true;
        getStatusIcon();
    }
    public void printTask(){
        System.out.println(getStatusIcon()+description);
    }
}
