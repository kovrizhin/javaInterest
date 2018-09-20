import java.util.ArrayList;

/**
 * Created by oleg on 3/25/18.
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>(10000);
        ints.add(0, 100);
        ints.add(100, 100);
        System.out.println(ints);
    }
}
