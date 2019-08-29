import java.util.*;
import java.io.*;
public class ReadFile {

    private Scanner x;

    public void openFile(){
        try{
            x = new Scanner(new File("SaveData.txt"));
        }
        catch (Exception e){
            System.out.println("Could not find file");
        }
    }

    public String readFile(){
            String a = x.next();
        return a;
    }
}
