package other;

/**
 * Created by oleg on 9/29/16
 */
public class TestLazy {

    public static void main(String[] args) {
        boolean a = false;
        a |= getTrue();
        a |= getTrue();
        a |= getTrue();
        a |= getTrue();

    }

    public static boolean getTrue() {
        System.out.println("aaaaa");
        return true;
    }
}
