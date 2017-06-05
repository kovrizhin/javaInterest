package semrushtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by oleg on 10/17/16
 */
public class CopyOnWriteList {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> foo = new CopyOnWriteArrayList<Integer>();
        foo.addAll(Arrays.asList(1,2,3,4));
        System.out.println(foo);
    }
}
