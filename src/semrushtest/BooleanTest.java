package semrushtest;

/**
 * Created by oleg on 10/17/16
 */
public class BooleanTest {
    public static void main(String[] args) {
        boolean b = true;
        if(b = check()){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    private static boolean check() {
        return false;
    }
}
