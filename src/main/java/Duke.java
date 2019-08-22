import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        Task[] taskObject= new Task[101];
        int count = 1;
        Scanner input = new Scanner(System.in);
        CheckString CheckStringObject = new CheckString();

        while(true){
            String command = input.nextLine();
            int TaskNum = CheckStringObject.split(command);

            if(command.equals("bye")){
                System.out.println("  Bye. Hope to see you again soon!");
                break;
            }
            else if(TaskNum != 0 && TaskNum < count){
                taskObject[TaskNum].markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                taskObject[TaskNum].printTask();
            }
            else if(command.equals("list")){
                for(int i = 1; i < count; i ++){
                    System.out.print(i + ". ");
                    taskObject[i].printTask();
                }
            }
            else {
                taskObject[count] = new Task(command);
                count ++;
            }
        }
    }
}
