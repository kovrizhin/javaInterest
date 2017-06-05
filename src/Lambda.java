import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by oleg on 4/14/16.
 */
public class Lambda {

    public static void main(String[] args) {
//        System.out.println();
        Function<Integer, Integer> a = (i) -> {
            int b = 35353;
            return i + b;
        };
        Integer apply = a.apply(1);
        System.out.println(apply);
    }
}
