package hackerTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by oleg on 10/26/16
 *
 *
 * https://www.hackerrank.com/challenges/maximum-subarray-sum
 *
 We define the following:

 A subarray of an -element array, , is a contiguous subset of 's elements in the inclusive range from some index  to some index  where .
 The sum of an array is the sum of its elements.
 Given an -element array of integers, , and an integer, , determine the maximum value of the sum of any of its subarrays modulo . This means that you must find the sum of each subarray modulo , then print the maximum result of this modulo operation for any of the  possible subarrays.

 Input Format

 The first line contains an integer, , denoting the number of queries to perform. Each query is described over two lines:

 The first line contains two space-separated integers describing the respective  (the array length) and  (the right operand for the modulo operations) values for the query.
 The second line contains  space-separated integers describing the respective elements of array  for that query.
 Constraints

 the sum of  over all test cases
 Output Format

 For each query, print the maximum value of  on a new line.

 Sample Input

 1
 5 7
 3 3 9 9 5
 Sample Output

 6
 Explanation

 The subarrays of array  and their respective sums modulo  are ranked in order of length and sum in the following list:

 and
 and






 As you can see, the maximum value for  for any subarray is , so we print  on a new line.

 */
public class TestAlg5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int examples = in.nextInt();

        for (int i = 0; i < examples; i++) {

            int arrLength = in.nextInt();
            long mod = in.nextLong();
            long[] arr = new long[arrLength];
            long l1 = in.nextLong();
            arr[0] = l1 % mod;
            long ans = arr[0];
            for (int j = 1; j < arrLength; j++) {
                long l = in.nextLong();
                arr[j] = (arr[j-1] + l) % mod;
                ans = Math.min(ans, mod - arr[j]);
            }
//            System.out.println(ans);
//            System.out.println(Arrays.toString(arr));
            for (int j = arr.length -1; j >= 1 ; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    long cur = arr[k] - arr[j];
                    if(cur > 0){
                        ans = Math.min(cur, ans);
                    }

                }

            }
            System.out.println(mod - ans);
        }
    }
}
