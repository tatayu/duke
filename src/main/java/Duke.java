import javax.print.DocFlavor;
import java.util.EmptyStackException;
import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        Task[] taskObject= new Task[101];

        int count = 1;
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        CheckString CheckStringObject = new CheckString();
        DukeException DukeExceptionObject = new DukeException();
        WriteFile WriteFileObject = new WriteFile();
        ReadFile ReadFileObject = new ReadFile();

        try {
            ReadFileObject.openFile();
            String SaveCount = ReadFileObject.readFile();
            count = Integer.parseInt(SaveCount) + 1;
        }
        catch (Exception e){
            DukeExceptionObject.EmptyFileException();
        }

        for(int i=1; i<count; i++){
            String temp = ReadFileObject.readFile();
            CheckStringObject.ReadSplit(temp);
            if(CheckStringObject.data0().equals("T")){
                if(CheckStringObject.data1().equals("1")){
                    taskObject[i].markAsDone();
                }
                taskObject[i] = new Todo(CheckStringObject.data2());
            }
            else if(CheckStringObject.data0().equals("D")){
                if(CheckStringObject.data1().equals("1")){
                    taskObject[i].markAsDone();
                }
                taskObject[i] = new Deadline(CheckStringObject.data2(), CheckStringObject.data3());
            }
            else if(CheckStringObject.data0().equals("E")){
                if(CheckStringObject.data1().equals("1")){
                    taskObject[i].markAsDone();
                }
                taskObject[i] = new Event(CheckStringObject.data2(), CheckStringObject.data3());
            }
        }

        while(true){
            flag = true;
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
            else if(TaskNum == -1 ){ //todo
                try{
                    String[] temp = command.split(" ",2);
                    taskObject[count] = new Todo(temp[1]);
                }
                catch (Exception e){
                    DukeExceptionObject.EmptyDescriptionException(command);
                    flag = false;
                }

                if(flag == true) {
                    System.out.println("Got it. I've added this task:");
                    System.out.println(taskObject[count].toString());
                    System.out.println("Now you have " + count + " tasks in the list.");
                    count++;
                }
            }
            else if(TaskNum == -2){//deadline
                try{
                    int position = CheckStringObject.position(command);
                    String desc = command.substring(9, position);
                    String by = command.substring(position+1, command.length());
                    taskObject[count] = new Deadline(desc, by); //put params
                }
                catch (Exception e) {
                    DukeExceptionObject.EmptyDescriptionException(command);
                    flag = false;
                }

                if(flag == true) {
                    System.out.println("Got it. I've added this task:");
                    System.out.println(taskObject[count].toString());
                    System.out.println("Now you have " + count + " tasks in the list.");
                    count++;
                }
            }
            else if(TaskNum == -3){//event
                try{
                    int position = CheckStringObject.position(command);
                    String desc = command.substring(6, position);
                    String by = command.substring(position+1, command.length());
                    taskObject[count] = new Event(desc, by);
                }
                catch (Exception e){
                    DukeExceptionObject.EmptyDescriptionException(command);
                    flag = false;
                }
                if(flag == true){
                    System.out.println("Got it. I've added this task:");
                    System.out.println(taskObject[count].toString());
                    System.out.println("Now you have "+count+" tasks in the list.");
                    count ++;
                }
            }
            else {
                DukeExceptionObject.DontKnowWhatItMeansException();
            }
        }

        WriteFileObject.openFile();
        String counter = Integer.toString(count - 1);
        WriteFileObject.addRecords(counter);

        for(int j=1; j<count; j++){
            String temp = taskObject[j].Save();
            WriteFileObject.addRecords(temp);
        }
        WriteFileObject.closeWrite();

    }
}