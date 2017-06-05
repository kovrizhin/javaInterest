package hackerTest;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by oleg on 10/27/16
 */
public class TestCalendar {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.MILLISECOND));
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.MILLISECOND));
    }
}
