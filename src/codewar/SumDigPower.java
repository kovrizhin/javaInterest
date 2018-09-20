package codewar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class SumDigPower {

    public static List<Long> sumDigPow(long a, long b) {
        // your code
        return LongStream.range(a,b).parallel().filter(SumDigPower::check).boxed().collect(Collectors.toList());

    }

    private static boolean check(long value) {
        String s = String.valueOf(value);
        long res = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
             res += Math.pow(Long.valueOf((String.valueOf(s.charAt(i)))), i + 1);
        }
        return res == value;
    }
}
