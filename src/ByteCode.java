/**
 * Created by oleg on 4/26/16.
 */
public class ByteCode {
    public static void main(String[] args) {
        System.out.println(getString());
    }

    public static String getString(){
        try {
            return "1";
        } finally {
            System.out.println("(\\d{1,4}-\\d{1,2}-\\d{1,2})()");
        }
    }
}
