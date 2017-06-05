package overloading;

/**
 * Created by oleg on 12/16/16
 */
public class IntOver {
    public static void overload(int a){
        System.out.println("int");
    }

    public static void overload(byte a){
        System.out.println("int");
    }

    public static void main(String[] args) {
        byte a = (byte) 1;
        overload(Byte.valueOf(a));
        overload(a);

    }
}
