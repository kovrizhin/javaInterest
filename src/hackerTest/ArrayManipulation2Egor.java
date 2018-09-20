package hackerTest;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Math.max;

public class ArrayManipulation2Egor {
    private static long[] segmentTree;

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        segmentTree = new long[calcLength(n)];

        for (int i = 0; i < queries.length; i++) {
            add(1, 0, n - 1, queries[i][0] - 1, queries[i][1] - 1, queries[i][2]);
        }

        return getMaxValue(1, 0, n - 1, 0, n - 1);
    }

    private static int calcLength(int inputLength) {
        int result = 1;
        while (result < inputLength) {
            result<<=1;
        }
        return result<<1;
    }

    private static long getMaxValue(int v, int tl, int tr, int l, int r) {
        if (v >= segmentTree.length) return 0;
        if (l > r) return 0;

        int tm = (tl + tr) / 2;

        return segmentTree[v] + Math.max(getMaxValue(v * 2, tl, tm, l, Math.min(r, tm)), getMaxValue(v*2+1, tm+1, tr, Math.max(l, tm + 1), r));
    }

    private static void add(int v, int tl, int tr, int l, int r, int add) {
        if (l > r)
            return;
        if (l == tl && tr == r)
            segmentTree[v] += add;
        else {
            int tm = (tl + tr) / 2;
            add(v*2, tl, tm, l, Math.min(r, tm), add);
            add(v*2+1, tm+1, tr, Math.max(l, tm + 1), r, add);
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.in));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.println(result);
        scanner.close();
    }
}
