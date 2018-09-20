package hackerTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


import static java.lang.Math.max;

public class ArrayManipulation2 {
    static long[] tree;
    static long[] add;
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        tree = new long[4 * n];
        add = new long[4 * n];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            modify(0, 0, n -1, query[0] - 1, query[1] - 1, query[2]);
        }
        return query(0,0, n -1, 0, n - 1);

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

    static void push(int v, int vl, int vr){
        if(add[v] != 0) {
            tree[v] += add[v];
            if(vl != vr) {
                add[2 * v + 1] += add[v];
                add[2 * v + 2] += add[v];
            }
            add[v] = 0;
        }
    }

    static void modify(int v, int vl, int vr, int l, int r, long val){
        push(v, vl, vr);
        if(r < vl || vr < l)
            return;
        if(l <= vl && vr <= r) {
            add[v] = val;
            push(v, vl, vr);
            return;
        }
        int vm = vl + (vr - vl) / 2;
        modify(2 * v + 1, vl, vm, l, r, val);
        modify(2 * v + 2, vm + 1, vr, l, r, val);
        tree[v] = max(tree[2 * v + 1], tree[2 * v +2]);
    }

    static long query(int v, int vl, int vr, int l, int r) {
        push(v, vl, vr);
        if(r < vl || vr < l)
            return 0;
        if(l <= vl && vr <= r) {
            return tree[v];
        }
        int vm = vl + (vr - vl) / 2;
        long ql = query(2 * v + 1, vl, vm, l, r);
        long qr = query(2 * v + 2, vm + 1, vr, l, r);
        return max(ql, qr);
    }
}
