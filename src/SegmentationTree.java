import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by oleg on 9/17/18.
 */
public class SegmentationTree {
    int INF = Integer.MAX_VALUE;

    static int n = 12;
    static int[] tree = new int[2* n];
    static int[] add = new int[2* n];

    public static void main(String[] args) {
//        int[] test = {3, 8, 6, 4, 2, 5, 9, 0, 7, 1};
        int[] test = {2, 7, 6, 4, 1, 3};
        tree = new int[4 * test.length];
        add = new int[4 * test.length];

        modify(0, 0, test.length - 1, 0, 0, 2);
        modify(0, 0, test.length - 1, 1, 1, 7);
        modify(0, 0, test.length - 1, 2, 2, 6);
        modify(0, 0, test.length - 1, 3, 3, 4);
        modify(0, 0, test.length - 1, 4, 4, 1);
        modify(0, 0, test.length - 1, 5, 5, 3);
//        modify(0, 0, test.length - 1, 0, 1, 2);
//        String tree_str = Arrays.toString(tree);
//        int min = rmq_up(tree, 8, 9);
//        System.out.println(min);
        System.out.println(query(0, 0, test.length -1, 3, 5));
        modify(0, 0, test.length - 1, 4, 4, 5);
        System.out.println(query(0, 0, test.length -1, 3, 5));
        System.out.println(query(0, 0, test.length -1, 0, 5));
        modify(0, 0, test.length - 1, 3, 5, 5);
        System.out.println(query(0, 0, test.length -1, 0, 5));
//        for (int i = 0; i < test.length; i++) {
//            for (int j = i + 1; j < test.length; j++) {
//
//                int ans = rmq_up(tree, i , j );
//                int testAns = Integer.MAX_VALUE;
//                for (int k = i; k <= j; k++) {
//                    testAns = min(testAns, test[k]);
//
//                }
//                System.out.println("i = " + i + " j = " + j + " ans = " + ans + " test = " + testAns);
//            }
//
//        }
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

    static void modify(int v, int vl, int vr, int l, int r, int val){
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

    static int query(int v, int vl, int vr, int l, int r) {
        push(v, vl, vr);
        if(r < vl || vr < l)
            return 0;
        if(l <= vl && vr <= r) {
            return tree[v];
        }
        int vm = vl + (vr - vl) / 2;
        int ql = query(2 * v + 1, vl, vm, l, r);
        int qr = query(2 * v + 2, vm + 1, vr, l, r);
        return max(ql, qr);
    }

}
