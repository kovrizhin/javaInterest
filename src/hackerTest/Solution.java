package hackerTest;

import java.io.*;
import java.util.*;




public class Solution {

    private static final long lim = 1_000_000_007;
    private static final int m = 'b' - 'a' + 1;
    private static final int a = 'a';

    // count -> pairs -> sums -> result
    private static long palindrome(byte[] chars) {
        long result = 0;

        long[] count = new long[m];
        long[][] charsAfter = new long[m][m];
        long[][] pairsAfter = new long[m][m];

        int n = chars.length;
        for (int i=0; i<n; i++) {
            int c = chars[i] - a;

            result = sum(result, sum(pairsAfter[c]));
            for (int j=0; j<m; j++) {
                pairsAfter[j][c] = sum(pairsAfter[j][c], charsAfter[j][c]);
            }
            for (int j=0; j<m; j++) {
                charsAfter[j][c] = sum(charsAfter[j][c], count[j]);
            }
            System.out.println("I = " + i);

            System.out.println("charsAfter = ");
            for (int j = 0; j < pairsAfter.length; j++) {
                System.out.println(Arrays.toString(charsAfter[j]));

            }
            System.out.println("pairsAfter = ");
            for (int j = 0; j < pairsAfter.length; j++) {
                System.out.println(Arrays.toString(pairsAfter[j]));

            }
            System.out.println("count = ");

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


            long result = palindrome("ababb".getBytes());
            System.out.println(result);

    }
}