package codewar;

import java.lang.reflect.Array;
import java.util.Collections;

public class AreSame {

    public static boolean comp(int[] a, int[] b) {
        if(a != null && a.length > 0 && b != null && b.length > 0 && a.length == b.length) {
            int length = a.length;
            for (int i = 0; i < length; i++) {
                int first = a[((length - 1) + i) % length];
                int second = b[i];
                if(first * first != second){
                    return false;
                };
            }
            return true;
        } else {
            return false;
        }
    }
}
