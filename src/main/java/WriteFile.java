import java.util.Formatter;

public class WriteFile {
    private Formatter x;

    public void openFile(){
        try{
            x = new Formatter("SaveData.txt");
        }
        catch (Exception e){
            System.out.println("you have an error");
        }
    }

    public void addRecords(String UserInput){
        x.format("%s\n",UserInput);
    }

    public void closeWrite () {
        x.close();
    }
}
