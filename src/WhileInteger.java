/**
 * Created by oleg on 5/19/16.
 */
public class WhileInteger {

    public static void main(String[] args) {
//        final int START = 1_000_000_000;
//        final int START = 16777116;
        final int START = 9_388_808;
        int count = 0;
        float f = START;
        int i = START + 50;
        System.out.println(f < i);
        System.out.println(i);
        for (f = START; f < i; f++) {
            System.out.println(f);
            count++;
        }
        System.out.println(count);
    }
}
