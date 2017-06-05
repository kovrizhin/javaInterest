package hackerTest;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by oleg on 8/16/16
 */
public class HackString2 {
    public static final double MOD = 10e9 + 7;
    static String input = "kkkkkkz";
    static Integer out = 15;
    static HashMap<Character, Integer> hashMap = new HashMap<>();



    public static void main(String[] args) {

    }

    private static int fact(Integer integer) {
        Integer fac = 1;
        for (int i = 2; i <= integer; i++) {
             fac *= i;
        }
        return fac;
    }
}
