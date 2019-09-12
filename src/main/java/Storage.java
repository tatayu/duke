import java.util.*;

public class Storage {
    WriteFile WriteFileObject = new WriteFile();
    ReadFile ReadFileObject = new ReadFile();
    Parser CheckStringObject = new Parser();
    ArrayList<Task> taskObject = new ArrayList<>();
    DukeException DukeExceptionObject = new DukeException();
    private int count = 1 ;

    /**
     * Load the task list stored in the file
     */
    public void Load(){
        try {
            ReadFileObject.openFile();
            String SaveCount = ReadFileObject.readFile();
            count = Integer.parseInt(SaveCount) + 1;
        }
        catch (Exception e){
            DukeExceptionObject.EmptyFileException();
        }

        for(int i=0; i<count-1; i++){
            String temp = ReadFileObject.readFile();
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
    }

    /**
     * Save the task added in the file
     * @param count number of tasks stored in the file
     */
    public void Save(int count){
        WriteFileObject.openFile();
        String counter = Integer.toString(count - 1);
        WriteFileObject.addRecords(counter);

        for (int j = 0; j < count-1; j++) {
            String temp = taskObject.get(j).Save();
            WriteFileObject.addRecords(temp);
        }
        WriteFileObject.closeWrite();
    }

    /**
     * Get the array list of taskObject from the file
     * @return an array list of taskObject
     */
    public ArrayList<Task> getTaskObject (){ //get from file
        return taskObject;
    }

    /**
     * Pass the array list of taskObject to the file
     * @param taskObject an array list of taskObject
     */
    public void setTaskObject(ArrayList<Task> taskObject) { //give to file
        this.taskObject = taskObject;
    }

    /**
     * Get the number of tasks from the file
     * @return the number of tasks stored
     */
    public int getCount(){ //get from file
        return count;
    }

    /**
     * Pass the number of tasks to the file
     * @param count the number of tasks in list
     */
    public void setCount(int count){ //give to file
        this.count = count;
    }
}
