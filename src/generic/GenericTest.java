package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 10/17/16
 */
public class GenericTest {
    public static void main(String[] args) {
        ArrayList integers = new ArrayList<Integer>();
        List<? extends Number> list = integers;
        Number number = list.get(0);
        Number number1 = new Number() {
            @Override
            public int intValue() {
                return 0;
            }

            @Override
            public long longValue() {
                return 0;
            }

            @Override
            public float floatValue() {
                return 0;
            }

            @Override
            public double doubleValue() {
                return 0;
            }
        };
//        list.add(number1);

        ArrayList<Number> integers2 = new ArrayList<>();
        List<? super Number> list2 = integers2;

        list2.add(0.1);
        list2.add(0);

        Object object = list2.get(0);
    }
}
