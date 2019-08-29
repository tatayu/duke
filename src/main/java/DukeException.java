public class DukeException {

    public void EmptyDescriptionException(String command){
        System.out.println("☹ OOPS!!! The description of a " + command + " cannot be empty.");
    }

    public void DontKnowWhatItMeansException(){
        System.out.println(" ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }
}
