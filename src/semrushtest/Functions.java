package semrushtest;

import java.util.function.Function;

/**
 * Created by oleg on 10/17/16
 */
public class Functions {
    public static void main(String[] args) {
        Function<Integer, Integer> f1 = (i) -> i * 3;
        Function<Integer, Integer> f2 = (i) -> i * i;
        Function<Integer, Integer> f3 = (i) -> i / 2;

        Integer result = f1.compose(f2).andThen(f3).apply(4);
        System.out.println(result);
    }
}
