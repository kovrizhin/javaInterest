package hackerTest;

import java.io.IOException;
import java.util.Arrays;


public class SolutionMap2 {

    private static final long lim = 1_000_000_007;
    private static final int m = 'b' - 'a' + 1;
    private static final int a = 'a';

    // count -> pairs -> sums -> result
    private static long palindrome(char[] chars) {
        long result = 0;

        long[] count = new long[m];
        long[][] pairs = new long[m][m];
        long[][] sums = new long[m][m];

        int n = chars.length;
        for (int i=0; i<n; i++) {
            int symbol = chars[i] - a;

            long[] rowSymbol = sums[symbol];
            result = sum(result, sum(rowSymbol));
            for (int testSymbol=0; testSymbol<m; testSymbol++) {
                sums[testSymbol][symbol] = sum(sums[testSymbol][symbol], pairs[testSymbol][symbol]);
            }
            for (int testSymbol=0; testSymbol<m; testSymbol++) {
                pairs[testSymbol][symbol] = sum(pairs[testSymbol][symbol], count[testSymbol]);
            }
            count[symbol]++;
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
        byte[] in  = new byte[1_000_000];
        int n = System.in.read(in);
        if (n >= 0) {
            int[] inI = new int[n];
            for (int i=0; i<n; i++) {
                inI[i] = in[i] & 0xFF;
            }

            long result = palindrome("aaaaaab".toCharArray());
            System.out.println(result);
        }
    }
}