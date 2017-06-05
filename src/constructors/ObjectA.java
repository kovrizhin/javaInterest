package constructors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oleg
 * Date: 6/30/15
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class ObjectA {
    protected Integer a;
    public ArrayList<Double> doubles = new ArrayList<>();
    public ArrayList<String> strings = new ArrayList<>();


    public ObjectA(Boolean bool) {
        this(bool, 5);
    }

    protected ObjectA(Boolean bool, Integer in) {

    }

    public void printA(){
        System.out.println(a);
    }

    public static void main(String[] args) {
//        System.out.println(bool);
//        a = 5;

        System.out.println();
        System.out.println();
    }
}
