import java.util.ArrayList;

public class UI {

    /**
     * Print the boot up message
     */
    public void greeting() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    /**
     * Print goodbye message
     */
    public void bye(){
        System.out.println("  Bye. Hope to see you again soon!");
    }

    /**
     * Print the message together with the todo task added by the user
     * @param count the number of tasks in the list
     * @param taskObject the array list that stores all the taskObject
     */
    public void todo(int count, ArrayList<Task> taskObject){
        System.out.println("Got it. I've added this task:");
        System.out.println(taskObject.get(count - 1).toString());
        System.out.println("Now you have " + count + " tasks in the list.");
    }

    /**
     * Print the message together with the deadline task added by the user
     * @param count the index of the tasks in the list
     * @param taskObject the array list that stores all the taskObject
     */
    public void deadline(int count, ArrayList<Task> taskObject){
        System.out.println("Got it. I've added this task:");
        System.out.println(taskObject.get(count - 1).toString());
        System.out.println("Now you have " + count + " tasks in the list.");
    }

    /**
     * Print the message together with event task added by the user
     * @param count the number of tasks in the list
     * @param taskObject the array list that stores all the taskObject
     */
    public void event(int count, ArrayList<Task> taskObject){
        System.out.println("Got it. I've added this task:");
        System.out.println(taskObject.get(count - 1).toString());
        System.out.println("Now you have " + count + " tasks in the list.");
    }

    /**
     * Print the list of result of matching tasks that the user wants to find
     * @param count the number of tasks in the list
     * @param taskObject the array list that stores all the taskObject
     * @param find the string that stores the task that the user want to search for
     */
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

    /**
     * Print the list of tasks added by the user
     * @param count the number of tasks in the list
     * @param taskObject the array list that stores all the taskObject
     */
    public void list(int count, ArrayList<Task> taskObject){
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < count - 1; i++) {
            System.out.print(i + 1 + ". ");
            System.out.println(taskObject.get(i).toString());
        }
    }

    /**
     * Mark the task as done and print the message
     * @param TaskNum the index of the task
     * @param taskObject the array list that stores all the taskObject
     */
    public void done(int TaskNum, ArrayList<Task> taskObject){
        taskObject.get(TaskNum - 1).markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(taskObject.get(TaskNum - 1).toString());
    }

    /**
     * Delete the task that the user does not want
     * @param TaskNum the index of the task
     * @param taskObject the array list that stores all the taskObject
     * @param count store the number of tasks in the list
     */
    public void delete(int TaskNum, ArrayList<Task> taskObject, int count){
        System.out.println("Noted. I've removed this task: ");
        System.out.println(taskObject.get(TaskNum - 1).toString());
        taskObject.remove(TaskNum - 1);
        count--;
        System.out.println("Now you have " + (count - 1) + " tasks in the list.");
    }
}
