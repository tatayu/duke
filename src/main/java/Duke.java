import java.util.Scanner;
public class Duke {
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
    }
}
