public class DukeException {

    /**
     * Print the error message if the description by a user is empty
     * @param command the user input
     */
    public void EmptyDescriptionException(String command){
        System.out.println("☹ OOPS!!! The description of a " + command + " cannot be empty.");
    }

    /**
     * Print the error message if the input does not match any of the format
     */
    public void DontKnowWhatItMeansException(){
        System.out.println(" ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    /**
     * Print the error message if the file is empty
     */
    public void EmptyFileException(){
        System.out.println("Your file is empty");
    }
}
