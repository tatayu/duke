import java.util.Scanner;
public class Duke {
    /* Level 1:Greet,Echo,Exit
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        while(true){
            Scanner input = new Scanner(System.in);
            String echo;
            echo = input.nextLine();
            if(echo.equals("bye") ){
                System.out.println("  Bye. Hope to see you again soon!");
                break;
            }
            else {
                System.out.println("  "+echo);
            }
        }
    }*/

    //Level 2:Add,List
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        String list[] = new String[100];
        int count = 0;
        while (true){
            Scanner input = new Scanner(System.in);
            String command = input.nextLine();
            if(command.equals("bye")){
                System.out.println("  Bye. Hope to see you again soon!");
                break;
            }
            else if(command.equals("list")){
               for(int i = 0; i < count; i++){
                   System.out.println("  "+(i+1)+". "+list[i]);
               }
            }
            else{
                list[count] = command;
                System.out.println("  added: "+command);
                count ++;
            }
        }
    }
}
