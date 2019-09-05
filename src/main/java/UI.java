import java.util.ArrayList;

public class UI {

    public void greeting() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    public void bye(){
        System.out.println("  Bye. Hope to see you again soon!");
    }

    public void todo(int count, ArrayList<Task> taskObject){
        System.out.println("Got it. I've added this task:");
        System.out.println(taskObject.get(count - 1).toString());
        System.out.println("Now you have " + count + " tasks in the list.");
    }

    public void deadline(int count, ArrayList<Task> taskObject){
        System.out.println("Got it. I've added this task:");
        System.out.println(taskObject.get(count - 1).toString());
        System.out.println("Now you have " + count + " tasks in the list.");
    }

    public void event(int count, ArrayList<Task> taskObject){
        System.out.println("Got it. I've added this task:");
        System.out.println(taskObject.get(count - 1).toString());
        System.out.println("Now you have " + count + " tasks in the list.");
    }

    public void find(int count, ArrayList<Task> taskObject, String[] find){
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < count - 1; i++) {
            String temp = taskObject.get(i).description;
            if (temp.contains(find[1])) {
                System.out.print(i + 1 + ". ");
                System.out.println(taskObject.get(i).toString());
            }
        }
    }

    public void list(int count, ArrayList<Task> taskObject){
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < count - 1; i++) {
            System.out.print(i + 1 + ". ");
            System.out.println(taskObject.get(i).toString());
        }
    }

    public void done(int TaskNum, ArrayList<Task> taskObject){
        taskObject.get(TaskNum - 1).markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(taskObject.get(TaskNum - 1).toString());
    }

    public void delete(int TaskNum, ArrayList<Task> taskObject, int count){
        System.out.println("Noted. I've removed this task: ");
        System.out.println(taskObject.get(TaskNum - 1).toString());
        taskObject.remove(TaskNum - 1);
        count--;
        System.out.println("Now you have " + (count - 1) + " tasks in the list.");
    }
}
