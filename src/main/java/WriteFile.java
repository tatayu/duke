import java.util.Formatter;

public class WriteFile {
    private Formatter x;

    /**
     * Open the file that saves all the data
     * @throws Exception error has reached unexpectedly while opening the file
     */
    public void openFile(){
        try{
            x = new Formatter("SaveData.txt");
        }
        catch (Exception e){
            System.out.println("you have an error");
        }
    }

    /**
     * Store the user input to the file
     * @param UserInput input by the user
     */
    public void addRecords(String UserInput){
        x.format("%s\n",UserInput);
    }

    /**
     * close the file
     */
    public void closeWrite () {
        x.close();
    }
}
