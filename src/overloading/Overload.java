package overloading;

public class Overload{
    public void method(Object o) {
        System.out.println("Object");
    }
    public void method(java.io.IOException i) throws Exception {
        System.out.println("IOException");
    }

    public void method(Overload overload){
        System.out.println("overload");
    }
    public void method(java.io.FileNotFoundException f) {
        System.out.println("FileNotFoundException");
    }
    public static void main(String args[]) {
        Overload test = new Overload();
        Object a = null;
        test.method(a);
    }


}