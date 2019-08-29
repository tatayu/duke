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
            else if(command.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 1; i < count; i++) {
                    System.out.print(i + ". ");
                    System.out.println(taskObject[i].toString());
                }
            }
            else if(TaskNum > 0 && TaskNum < count){
                taskObject[TaskNum].markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(taskObject[TaskNum].toString());
            }

            else if(TaskNum == -1){ //todo
                int position = CheckStringObject.position(command);
                String desc = command.substring(5, position);
                String by = command.substring(position+1, command.length());
                taskObject[count] = new Todo(desc, by);
                System.out.println("Got it. I've added this task:");
                System.out.println(taskObject[count].toString());
                System.out.println("Now you have "+count+" tasks in the list.");
                count ++;
            }
            else if(TaskNum == -2){//deadline
                int position = CheckStringObject.position(command);
                String desc = command.substring(9, position);
                String by = command.substring(position+1, command.length());
                taskObject[count] = new Deadline(desc, by); //put params
                System.out.println("Got it. I've added this task:");
                System.out.println(taskObject[count].toString());
                System.out.println("Now you have "+count+" tasks in the list.");
                count ++;

            }
            else if(TaskNum == -3){//event
                int position = CheckStringObject.position(command);
                String desc = command.substring(6, position);
                String by = command.substring(position+1, command.length());
                taskObject[count] = new Event(desc, by);
                System.out.println("Got it. I've added this task:");
                System.out.println(taskObject[count].toString());
                System.out.println("Now you have "+count+" tasks in the list.");
                count ++;
            }
        }
    }
}

