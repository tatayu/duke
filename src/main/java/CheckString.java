public class CheckString {
    private int index;
    String[] check = new String[500];
    String[] time = new String[500];
    String[] stuff = new String[500];

    public static boolean isNumeric(final String s){ //check if the string is a number
        return s.chars().allMatch(Character::isDigit);
    }

    public int split(String UserInput){
        check = UserInput.split(" "); //split the string at the space

        if(check[0].equals("done")) {
            if (isNumeric(check[1])) {
                index = Integer.parseInt(check[1]);
            }
        }
        else if(check[0].equals("todo")){
            index = -1;
        }
        else if(check[0].equals("deadline")){
            index = -2;
        }
        else if (check[0].equals("event")){
            index = -3;
        }
        else {
            index = -4;
        }
        return index;
    }

    public int position(String command){
        return command.indexOf("/");
    }
}
