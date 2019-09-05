import java.util.ArrayList;
import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {

        ArrayList<Task> taskObject = new ArrayList<>();
        int count = 1;

        Storage StorageObject = new Storage();
        TaskList TaskListObject = new TaskList();
        UI UIObject = new UI();

        UIObject.greeting();

        StorageObject.Load();
        count = StorageObject.getCount();
        taskObject = StorageObject.getTaskObject();

        TaskListObject.setTaskObject(taskObject);
        TaskListObject.setCount(count);
        TaskListObject.run();


        count = TaskListObject.getCount();
        taskObject = TaskListObject.getTaskObject();
        StorageObject.Save(count);
        StorageObject.setTaskObject(taskObject);
        StorageObject.setCount(count);
    }
}