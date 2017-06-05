import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 5/10/16.
 */
public class GenericByteCode {


    public List<Double> get(int i, double d, Thread thread) {
        List<Double> doubleList = new ArrayList<>();
        return doubleList;
    }

    public static void main(String[] args) {
        Holder<Integer> holder = new Holder<>();
        holder.setTest(1);
        holder.getTest();
    }
}
