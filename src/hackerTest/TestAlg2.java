package hackerTest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by oleg on 10/26/16
 *
 *
 * https://www.hackerrank.com/challenges/sherlock-and-array
 * Watson gives Sherlock an array  of length . Then he asks him to determine if there exists an element in the array such that the sum of the elements on its left is equal to the sum of the elements on its right. If there are no elements to the left/right, then the sum is considered to be zero.
 Formally, find an , such that, 12i-1 i+1i+2N.

 Input Format

 The first line contains , the number of test cases. For each test case, the first line contains , the number of elements in the array . The second line for each test case contains  space-separated integers, denoting the array .

 Constraints



 i

 Output Format

 For each test case print YES if there exists an element in the array, such that the sum of the elements on its left is equal to the sum of the elements on its right; otherwise print NO.

 Sample Input

 2
 3
 1 2 3
 4
 1 2 3 3
 Sample Output

 NO
 YES
 Explanation

 For the first test case, no such index exists.
 For the second test case, , therefore index  satisfies the given conditions.
 */
public class TestAlg2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int countExamples = in.nextInt();
        int[][] arraySolutions = new int[countExamples][];
        for (int i = 0; i < countExamples; i++) {
            int arrayLength = in.nextInt();
            int[] array = new int[arrayLength];
            for (int j = 0; j < arrayLength; j++) {
                array[j] = in.nextInt();

            }
            arraySolutions[i] = array;


        }

        for (int i = 0; i < arraySolutions.length; i++) {
            String answer = solveArray(arraySolutions[i]);
            System.out.println(answer);

        }


    }

    private static String solveArray(int[] array) {
        int sum = Arrays.stream(array).sum();
        int leftSum = array[0];
        sum = sum - array[0];
        for (int i = 1; i < array.length; i++) {
            sum = sum - array[i];
            if(sum == leftSum){
                return "YES";
            } else if (sum < leftSum){
                return "NO";
            } else {
                leftSum += array[i];
            }

        }
        return "NO";
    }
}
