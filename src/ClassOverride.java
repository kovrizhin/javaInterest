import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: oleg
 * Date: 4/14/14
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClassOverride {

   static A a = new B();

    public static void main(String[] args) {
        System.out.println(((Object) a).toString());
        System.out.println(((A) a).toString());
        System.out.println(((B) a).toString());
        System.out.println(((A) a).getString());
        System.out.println(((B) a).getString());
    }
}

class A {
    @Override
    public String toString() {
//        HashMap
        return "Aaaa";
    }
    public static String getString(){
        return "Aaaaaa";
    }
}
class B extends A{
    @Override
    public String toString() {
        return "Bbbbb";
    }
    public static String getString(){
        return "Bbbbbb";
    }
}

