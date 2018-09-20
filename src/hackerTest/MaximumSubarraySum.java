package hackerTest;

import java.util.*;

public class MaximumSubarraySum {

    static long maximumSum(long[] a, long m) {
        // Complete this function
        long max = 0;
        long sum = 0;
        int indexStart = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] %= m;
            sum += a[i];
            if(sum < m){
                max = Math.max(max, sum);
            } else {
                while (sum >= m){
                    sum -= a[indexStart++];
                }
            }
        }
        return max;
    }

    static long maximumSum2(long[] a, long m) {
        // Complete this function
        long max = 0;
        long[] res = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            a[i] %= m;
            for (int j = 0; j <= i; j++) {
                res[j] = (a[i] + res[j]) % m;
                max = Math.max(res[j], max);
                if(max ==2960){
//                    System.out.println(i + "    " + j + " ");
//                    System.out.println("sad");
                }
            }


        }
        return max;
    }

    static long maximumSum3(long[] a, long m) {
        // Complete this function
        a[0] = a[0] % m;

        int length = a.length;
        long[] pref = new long[length];
        pref[0] = a[0];

        TreeSet<Long> tree = new TreeSet<>();
//        tree.add(0l);
//        tree.add(pref[0]);
        long ret = 0;
        for (int i = 1; i < length; i++) {
            a[i] %= m;
            pref[i] = (a[i] + pref[i - 1]) % m;
            tree.add(pref[i]);
            Long higher = tree.higher(pref[i]);
//            Iterator<Long> iterator = higher.iterator();
//            while (iterator.hasNext()) {
            if(higher != null) {
                ret = Math.max(ret, (pref[i] - higher + m) % m);
            } else {
                ret = pref[i];
            }
//            }
        }
        return ret;
    }

//    static long maximumSum2(long[] a, long m) {
//        // Complete this function
//
//        for (int i = 0; i < a.length; i++) {
//            long l = a[i];
//
//        }
//    }


    /*
    *


1
15 1804289384
846930887 1681692778 1714636916 1957747794 424238336 719885387 1649760493 596516650 1189641422 1025202363 1350490028 783368691 1102520060 2044897764 1967513927
1
15 3007
846930887 1681692778 1714636916 1957747794 424238336 719885387 1649760493 596516650 1189641422 1025202363 1350490028 783368691 1102520060 2044897764 1967513927

1
11 1804289384
424238336 719885387 1649760493 596516650 1189641422 1025202363 1350490028 783368691 1102520060 2044897764 1967513927


10000
50 1804289384
846930887 1681692778 1714636916 1957747794 424238336 719885387 1649760493 596516650 1189641422 1025202363 1350490028 783368691 1102520060 2044897764 1967513927 1365180541 1540383427 304089173 1303455737 35005212 521595369 294702568 1726956430 336465783 861021531 278722863 233665124 2145174068 468703136 1101513930 1801979803 1315634023 635723059 1369133070 1125898168 1059961394 2089018457 628175012 1656478043 1131176230 1653377374 859484422 1914544920 608413785 756898538 1734575199 1973594325 149798316 2038664371 1129566414
    * */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            long m = in.nextLong();
            long[] a = new long[n];
            for(int a_i = 0; a_i < n; a_i++){
                a[a_i] = in.nextLong();
            }
            long result = maximumSum(a, m);
            System.out.println(result);
            long result2 = maximumSum2(a, m);
            System.out.println(result2);
            long result3 = maximumSum3(a, m);
            System.out.println(result3);

        }
        in.close();
    }
}
/*
1
50 301
846930887 1681692778 1714636916 1957747794 424238336 719885387 1649760493 596516650 1189641422 1025202363 1350490028 783368691 1102520060 2044897764 1967513927 1365180541 1540383427 304089173 1303455737 35005212 521595369 294702568 1726956430 336465783 861021531 278722863 233665124 2145174068 468703136 1101513930 1801979803 1315634023 635723059 1369133070 1125898168 1059961394 2089018457 628175012 1656478043 1131176230 1653377374 859484422 1914544920 608413785 756898538 1734575199 1973594325 149798316 2038664371 1129566414

1
50 369
846930887 1681692778 1714636916 1957747794 424238336 719885387 1649760493 596516650 1189641422 1025202363 1350490028 783368691 1102520060 2044897764 1967513927 1365180541 1540383427 304089173 1303455737 35005212 521595369 294702568 1726956430 336465783 861021531 278722863 233665124 2145174068 468703136 1101513930 1801979803 1315634023 635723059 1369133070 1125898168 1059961394 2089018457 628175012 1656478043 1131176230 1653377374 859484422 1914544920 608413785 756898538 1734575199 1973594325 149798316 2038664371 1129566414


* */