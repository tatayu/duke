import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Date {
    /**
     *Convert the user input date and time in the format dd/MM/yyyy HH/mm into system
     *recognisable time and print
     * @param Input User input of time in the format of dd/MM/yyyy HH/mm
     * @throws ParseException error has been reached unexpectedly while parsing
     */
    public void StringtoDate(String Input) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH/mm");
        System.out.println(sdf.parse(Input));
    }
}
