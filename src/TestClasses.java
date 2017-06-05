/**
 * Created with IntelliJ IDEA.
 * User: oleg
 * Date: 4/15/15
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestClasses {

    public static final void main(String[] args)  {
        B b = new C();
        A a = new C();
        Object d = new D();

        System.out.println(b instanceof A);
        System.out.println(a instanceof B);
        System.out.println(d instanceof C);
    }


    static class A {
    }

    static class B extends A {
    }

    static class C extends B {
    }

    static class D {
    }
}
