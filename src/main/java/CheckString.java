public class CheckString {
    private int index;
    String[] check = new String[500];

    public static boolean isNumeric(final String s){ //check if the string is a number
        return s.chars().allMatch(Character::isDigit);
    }

    public int split(String UserInput){
        check = UserInput.split(" ",2); //split the string at the space

        if(check[0].equals("done")) {
            if (isNumeric(check[1])) {
                index = Integer.parseInt(check[1]);
            }
        }
        else {
            index = 0;
        }
        return index;
    }
}
