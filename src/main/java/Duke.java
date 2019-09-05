import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        //Task[] taskObject= new Task[101];
        ArrayList<Task> taskObject = new ArrayList<>();

        int count = 1;
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        CheckString CheckStringObject = new CheckString();
        DukeException DukeExceptionObject = new DukeException();
        WriteFile WriteFileObject = new WriteFile();
        ReadFile ReadFileObject = new ReadFile();
        Date DateObject = new Date();
        String[] instruction = new String[500];
        String[] find = new String[500];
        //Read file
        try {
            ReadFileObject.openFile();
            String SaveCount = ReadFileObject.readFile();
            count = Integer.parseInt(SaveCount) + 1;
            //System.out.println(count);
        }
        catch (Exception e){
            DukeExceptionObject.EmptyFileException();
        }
        for(int i=0; i<count-1; i++){
            String temp = ReadFileObject.readFile();
//            System.out.println(temp);
//            System.out.println(i);
            CheckStringObject.ReadSplit(temp);

            if(CheckStringObject.data0().equals("T")){
                taskObject.add(new Todo(CheckStringObject.data2()));
                if(CheckStringObject.data1().equals("1")){
                    taskObject.get(i).markAsDone();
                }
            }
            else if(CheckStringObject.data0().equals("D")){
                taskObject.add(new Deadline(CheckStringObject.data2(), CheckStringObject.data3()));
                if(CheckStringObject.data1().equals("1")){
                    taskObject.get(i).markAsDone();
                }
            }
            else if(CheckStringObject.data0().equals("E")){
                taskObject.add(new Event(CheckStringObject.data2(), CheckStringObject.data3()));
                if(CheckStringObject.data1().equals("1")){
                    taskObject.get(i).markAsDone();
                }
            }
        }

        //Add Task && Mark as Done
        while(true) {
            flag = true;
            String command = input.nextLine();
            int TaskNum = CheckStringObject.split(command);

            if (command.equals("bye")) {
                System.out.println("  Bye. Hope to see you again soon!");
                break;
            } else if (command.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < count - 1; i++) {
                    System.out.print(i + 1 + ". ");
                    System.out.println(taskObject.get(i).toString());
                }
            } else if (TaskNum > 0 && TaskNum < count) {
               instruction = command.split(" ",2);
               System.out.println(instruction[0]);
                if(instruction[0].equals("done")) {
                    taskObject.get(TaskNum - 1).markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(taskObject.get(TaskNum - 1).toString());
                }
                else {
                    System.out.println("Noted. I've removed this task: ");
                    System.out.println(taskObject.get(TaskNum - 1).toString());
                    taskObject.remove(TaskNum-1);
                    count --;
                    System.out.println("Now you have " + (count-1) + " tasks in the list.");
                }
            } else if (TaskNum == -1) { //todo
                try {
                    String[] temp = command.split(" ", 2);
                    taskObject.add(new Todo(temp[1]));
                } catch (Exception e) {
                    DukeExceptionObject.EmptyDescriptionException(command);
                    flag = false;
                }

                if (flag == true) {
                    System.out.println("Got it. I've added this task:");
                    System.out.println(taskObject.get(count - 1).toString());
                    System.out.println("Now you have " + count + " tasks in the list.");
                    count++;
                }
            } else if (TaskNum == -2) {//deadline
                try {
                    int position = CheckStringObject.position(command);
                    String desc = command.substring(9, position);
                    String by = command.substring(position + 1, command.length());
                    //taskObject[count] = new Deadline(desc, by); //put params
                    taskObject.add(new Deadline(desc, by));
                    //DateObject.StringtoDate(by);
                } catch (Exception e) {
                    DukeExceptionObject.EmptyDescriptionException(command);
                    flag = false;
                }

                if (flag == true) {
                    System.out.println("Got it. I've added this task:");
                    System.out.println(taskObject.get(count-1).toString());
                    System.out.println("Now you have " + count + " tasks in the list.");
                    count++;
                }
            } else if (TaskNum == -3) {//event
                try {
                    int position = CheckStringObject.position(command);
                    String desc = command.substring(6, position);
                    String by = command.substring(position + 1, command.length());
                    //taskObject[count] = new Event(desc, by);
                    taskObject.add(new Event(desc, by));
                    //DateObject.StringtoDate(by);
                } catch (Exception e) {
                    DukeExceptionObject.EmptyDescriptionException(command);
                    flag = false;
                }
                if (flag == true) {
                    System.out.println("Got it. I've added this task:");
                    System.out.println(taskObject.get(count-1).toString());
                    System.out.println("Now you have " + count + " tasks in the list.");
                    count++;
                }
            }
            else if (TaskNum == -4){//find
                find = command.split(" ",2);
                System.out.println("Here are the matching tasks in your list:");
                for(int i=0; i<count-1; i++){
                    String temp = taskObject.get(i).description;
                    if(temp.contains(find[1])){
                        System.out.print(i + 1 + ". ");
                        System.out.println(taskObject.get(i).toString());
                    }
                }
            }
            else {
                DukeExceptionObject.DontKnowWhatItMeansException();
            }

            //System.out.println("hi");
            //Write to file
            WriteFileObject.openFile();
            String counter = Integer.toString(count - 1);
            WriteFileObject.addRecords(counter);

            for (int j = 0; j < count-1; j++) {
                String temp = taskObject.get(j).Save();
                WriteFileObject.addRecords(temp);
            }
            WriteFileObject.closeWrite();
        }
    }
}