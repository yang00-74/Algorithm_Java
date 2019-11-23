import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = sdf.parse("1980-10-04 12:12:12");
        Date d2 = sdf.parse("1980-10-04 12:12:10");

        long t1 = d1.getTime();
        long t2 = d2.getTime();

        long t = t1 - t2;

        System.out.println(t / 1000);
    }


}
