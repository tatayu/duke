import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    private boolean flag = true;
    private int count = 1;
    Parser CheckStringObject = new Parser();
    ArrayList<Task> taskObject = new ArrayList<>();
    DukeException DukeExceptionObject = new DukeException();
    UI UIObject = new UI();
    String[] instruction = new String[500];
    String[] find = new String[500];

    Scanner input = new Scanner(System.in);

    public void run() {
        while (true) {
            flag = true;
            String command = input.nextLine();
            int TaskNum = CheckStringObject.split(command);

            if (command.equals("bye")) {
                UIObject.bye();
                break;
            } else if (command.equals("list")) {
                UIObject.list(count, taskObject);
            } else if (TaskNum > 0 && TaskNum < count) {
                instruction = command.split(" ", 2);
                System.out.println(instruction[0]);
                if (instruction[0].equals("done")) {
                   UIObject.done(TaskNum, taskObject);
                } else {
                    UIObject.delete(TaskNum, taskObject, count);
                    count --;
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
                    UIObject.todo(count, taskObject);
                    count++;
                }
            } else if (TaskNum == -2) {//deadline
                try {
                    int position = CheckStringObject.position(command);
                    String desc = command.substring(9, position);
                    String by = command.substring(position + 1, command.length());
                    taskObject.add(new Deadline(desc, by));
                } catch (Exception e) {
                    DukeExceptionObject.EmptyDescriptionException(command);
                    flag = false;
                }

                if (flag == true) {
                    UIObject.deadline(count, taskObject);
                    count++;
                }
            } else if (TaskNum == -3) {//event
                try {
                    int position = CheckStringObject.position(command);
                    String desc = command.substring(6, position);
                    String by = command.substring(position + 1, command.length());
                    taskObject.add(new Event(desc, by));
                } catch (Exception e) {
                    DukeExceptionObject.EmptyDescriptionException(command);
                    flag = false;
                }
                if (flag == true) {
                    UIObject.event(count, taskObject);
                    count++;
                }
            } else if (TaskNum == -4) {//find
                find = command.split(" ", 2);
                UIObject.find(count, taskObject, find);
            } else {
                DukeExceptionObject.DontKnowWhatItMeansException();
            }
        }
    }

    public ArrayList<Task> getTaskObject (){ //get from file
        return taskObject;
    }
    public void setTaskObject(ArrayList<Task> taskObject) { //give to file
        this.taskObject = taskObject;
    }
    public int getCount(){ //get from file
        return count;
    }
    public void setCount(int count){ //give to file
        this.count = count;
    }
}
