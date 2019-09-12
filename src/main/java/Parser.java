public class Parser {
    private int index;
    String[] check = new String[500];
    String[] ReadCheck = new String[100];

    /**
     * Check whether the string is a number
     * @param s A part of the user input string
     * @return true if the string is a number and false if the string is not a number
     */
    public static boolean isNumeric(final String s){ //check if the string is a number
        return s.chars().allMatch(Character::isDigit);
    }

    /**
     * Check the type of command input by the user
     * @param UserInput command input by the user
     * @return a number which indicates the type of command
     */
    public int split(String UserInput){
        check = UserInput.split(" "); //split the string at the space

        if(check[0].equals("done") || check[0].equals("delete")) {
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
        else if(check[0].equals("find")){
            index = -4;
        }
        else {
            index = -5;
        }
        return index;
    }

    /**
     * Get the position of "/"
     * @param command input by the user
     * @return the position of the "/"
     */
    public int position(String command){
        return command.indexOf("/");
    }

    /**
     * Split the task at "|"
     * @param str The string of task read from the string
     */
    public void ReadSplit(String str){
        ReadCheck = str.split("\\|");
    }

    /**
     * Get the type of the task
     * @return a string of the type of the task
     */
    public String data0(){ //check the type of task
        return ReadCheck[0];
    }

    /**
     * Get the status of the task
     * @return a string of the status of the task
     */
    public String data1(){ //check the status of task
        return ReadCheck[1];
    }

    /**
     * Get the description of the task
     * @return a string of the description of the task
     */
    public String data2(){
        return ReadCheck[2];
    }

    /**
     * Get the timeline of the task
     * @return a string of the timeline of the task
     */
    public String data3(){
        return ReadCheck[3];
    }
}
