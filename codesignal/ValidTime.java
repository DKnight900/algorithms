package codesignal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidTime {
    public static void main(String[] args) {
        System.out.println(validTime("zaz"));
        System.out.println(validTime("07:75"));
    }

    static boolean validTime(String time) {
//        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        try {
            System.out.println(dateFormat.parse(time));
        } catch (ParseException e) {
            return false;
        }

        return true;
    }
}
