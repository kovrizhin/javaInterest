import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: oleg
 * Date: 5/13/15
 * Time: 4:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class TimeClone {
    private Date date;

    public TimeClone(TimeClone timeClone) {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static void main(String[] args) {
        Date date = new Date();
//        TimeClone timeClone = new TimeClone();

//        timeClone.setDate(date);
//        date.setTime(12321312);
    }
}
