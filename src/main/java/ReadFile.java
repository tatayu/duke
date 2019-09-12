import java.util.*;
import java.io.*;
public class ReadFile {

    private Scanner x;

    /**
     * open the file that saves all the data
     * @throws Exception error has reached unexpectedly while opening the file
     */
    public void openFile(){
        try{
            x = new Scanner(new File("SaveData.txt"));
        }
        catch (Exception e){
            System.out.println("Could not find file");
        }
    }

    /**
     * Read the string of tasks line by line
     * @return the task in the form of string in the file
     */
    public String readFile(){
            String a = x.nextLine();
        return a;
    }
}
