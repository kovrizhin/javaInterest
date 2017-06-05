package hackerTest;

import java.io.IOException;
import java.util.Arrays;


public class SolutionMap {

    private static final long lim = 1_000_000_007;
    private static final int m = 'b' - 'a' + 1;
    private static final int a = 'a';

    // count -> pairs -> sums -> result
    private static long palindrome(byte[] chars) {
        long result = 0;

        long[] count = new long[m];
        long[][] incs = new long[m][m];
        long[][] pairs = new long[m][m];

        int n = chars.length;
        for (int i=0; i<n; i++) {
            int c = chars[i] - a;

            result = sum(result, sum(pairs[c]));
            for (int j=0; j<m; j++) {
                pairs[j][c] = sum(pairs[j][c], incs[j][c]);
            }
            for (int j=0; j<m; j++) {
                incs[j][c] = sum(incs[j][c], count[j]);
            }


            count[c]++;
            System.out.println(Arrays.toString(count));
        }

        return result;
    }

    private static long sum(long a, long b) {
        a += b;
        if (a >= lim) a -= lim;
        return a;
    }

    private static long sum(long[] array) {
        long result = 0;
        for (int i=0; i<m; i++) {
            result += array[i];
        }
        while (result >= lim) result -= lim;
        return result;
    }

    public static void main(String[] args) throws IOException {


            long result = palindrome("ababab".getBytes());
            System.out.println(result);

    }
}