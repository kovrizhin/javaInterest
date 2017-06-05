import java.util.*;

/**
 * Created by oleg on 1/28/16.
 */
public class GenericTest {


    public static void main(String[] args) {
        Gener1<? super java.util.List> a = new Gener1<>();
        a.setA(new LinkedList());
        Object a1 = a.getA();

        Gener1<? extends java.util.List> b = new Gener1<>();
//        b.setA(new ArrayList());
        List a2 = b.getA();
//
//
        Gener2<? super GenericTest> c = new Gener2<>();
//        a.setA(new GenericTest());
        Object a3 = a.getA();

        Gener2<? extends GenericTest> d = new Gener2<>();
//        a.setA(new Object());
        Object a4 = a.getA();
//        Object a3 = a4;

//        Gener1<java.util.List> a = new Gener1<>();
//        a.setA(new ArrayList());
//        Object a1 = a.getA();
        ArrayList<? extends String> test = new ArrayList<>();
        String test1 = "Test";
//        test.add(test1);
        String s = test.get(1);
    }


    public static class Gener1<T>{
        T a;

        public T getA() {
            return a;
        }

        public void setA(T a) {
            this.a = a;
        }
    }

    public static class Gener2<T extends GenericTest>{
        T a;

        public T getA() {
            return a;
        }

        public void setA(T a) {
            this.a = a;
        }
    }

//    public static class Gener3<? extends String>{

//
//
//    }

    class GenericTest2  extends GenericTest{

    }



}
