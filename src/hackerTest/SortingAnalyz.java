package hackerTest;/*
*
*
* Insertion Sort is a simple sorting technique which was covered in previous challenges. Sometimes, arrays may be too large for us to wait around for insertion sort to finish. Is there some other way we can calculate the number of times Insertion Sort shifts each elements when sorting an array?

If  is the number of elements over which the  element of the array has to shift, then the total number of shifts will be   .

Input Format

The first line contains a single integer, , denoting the number of queries to perform. The subsequent lines describe each query over two lines:

The first line contains an integer, , denoting the number of elements to be sorted.
The second line contains  space-separated integers describing the respective values of .
Constraints

Output Format

Print  lines containing the required answer for each query.

Sample Input

2
5
1 1 1 2 2
5
2 1 3 1 2
Sample Output

0
4
Explanation

The first query is already sorted, therefore there's no need to shift any element. In the second case, it will proceed in the following way.

Array: 2 1 3 1 2 -> 1 2 3 1 2 -> 1 1 2 3 2 -> 1 1 2 2 3
Moves:   -        1       -    2         -  1            = 4
*/

import java.io.*;
import java.util.*;

public class SortingAnalyz {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int j = 0; j < n; j++) {
            int m = in.nextInt();
            int[] ar = new int[m];
            for (int i = 0; i < m; i++) {
                ar[i] = in.nextInt();
            }
            System.out.println(analize(ar));
        }
    }

    private static int analize(int[] ar) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;
        for (int key : ar) {
            Integer value = map.get(key);
            if (value != null) {
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }

            SortedMap<Integer, Integer> integerIntegerSortedMap = map.tailMap(key, false);
            integerIntegerSortedMap.size();
            for (Integer values : integerIntegerSortedMap.values()) {
                count += values;
            }
        }
        return count;
    }

//    private static int analize(int[] ar) {
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//
//        int count = 0;
//        for (int key : ar) {
//            Integer value = map.get(key);
//            if (value != null) {
//                map.put(key, value + map.tailMap(key, false).size());
//            } else {
//                map.put(key, map.tailMap(key, false).size());
//            }
//        }
//        for (Integer integer : map.values()) {
//            count += integer;
//        }
//        return count;
//    }

}