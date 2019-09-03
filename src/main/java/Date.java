import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date {

    public void StringtoDate(String Input) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH/mm");
        System.out.println(sdf.parse(Input));
    }
}
