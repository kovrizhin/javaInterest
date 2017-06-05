package annotations;

import java.lang.annotation.Annotation;

/**
 * Created by oleg on 2/7/17
 */
public class Main {

    public static void main(String[] args) {
        @Simple(test = "test") String test;
//        @NoSoSimple String test2;
//        Simple simple = new NoSoSimple();
        Local.Inner inner = new Local().new Inner();
//        Simple.Test test1 = new Simple().new Test();


        Simple simple2 = new Simple() {
            @Override
            public boolean equals(Object obj) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public String toString() {
                return null;
            }

            @Override
            public Class<? extends Annotation> annotationType() {
                return null;
            }

//            @Override
//            public String value() {
//                return null;
//            }

            @Override
            public String test() {
                return null;
            }
        };
    }
}
