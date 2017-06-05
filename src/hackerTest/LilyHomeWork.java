package hackerTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import static java.util.Comparator.reverseOrder;

/**
 * Created by oleg on 3/27/17
 *
 *
 *

 Whenever George asks Lily to hang out, she's busy doing homework. George wants to help her finish it faster, but he's in over his head! Can you help George understand Lily's homework so she can hang out with him?

 Consider an array of  distinct integers, . George can swap any two elements of the array any number of times. An array is beautiful if the sum of  among  is minimal possible (after, possibly, performing some swaps).

 Given the array , find and print the minimum number of swaps that should be performed in order to make the array beautiful.

 Input Format

 The first line contains a single integer, , denoting the number of elements in the array .
 The second line contains  space-separated integers describing the respective distinct values of .

 Constraints

 Output Format

 Print the minimum number of swaps that should be performed in order to make the array beautiful.

 Sample Input

 4
 2 5 3 1
 Sample Output

 2
 Explanation

 Let's define array  to be the beautiful reordering of array , as the sum of the absolute values of differences between its adjacent elements is minimal among all permutations and only two swaps ( with  and then  with ) was performed.

 https://www.hackerrank.com/challenges/lilys-homework?h_r=next-challenge&h_v=zen

 */
public class LilyHomeWork {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        int[] sortedArr = Arrays.copyOf(ar, ar.length);
        HashMap<Integer, Integer> unSortedHashMap = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            unSortedHashMap.put(ar[i], i);
        }   

        Arrays.sort(sortedArr);
        int count = count(Arrays.copyOf(ar, ar.length), sortedArr, unSortedHashMap);
        reverse(sortedArr);
        unSortedHashMap.clear();
        for (int i = 0; i < ar.length; i++) {
            unSortedHashMap.put(ar[i], i);
        }
        int countRev = count(Arrays.copyOf(ar, ar.length), sortedArr, unSortedHashMap);
        System.out.println(Math.min(count, countRev));




    }

    private static void reverse(int[] sortedArr) {
        for(int i = 0; i < sortedArr.length / 2; i++)
        {
            int temp = sortedArr[i];
            sortedArr[i] = sortedArr[sortedArr.length - i - 1];
            sortedArr[sortedArr.length - i - 1] = temp;
        }
    }

    private static int count(int[] ar, int[] sortedArr, HashMap<Integer, Integer> unSortedHashMap) {
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            if(sortedArr[i] != ar[i]){
                count++;
                Integer sortedIndex = unSortedHashMap.get(sortedArr[i]);
                ar[sortedIndex] = ar[i];
                ar[i] = sortedArr[i];
                unSortedHashMap.put(ar[i], i);
                unSortedHashMap.put(ar[sortedIndex], sortedIndex);
            }

        }
        return count;
    }
}
