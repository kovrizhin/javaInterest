package hackerTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by oleg on 10/26/16
 *
 *
 * https://www.hackerrank.com/challenges/gridland-metro?h_r=next-challenge&h_v=zen
 *
 * The city of Gridland is represented as an  matrix where the rows are numbered from  to and the columns are numbered from  to .

 Gridland has a network of train tracks that always run in straight horizontal lines along a row. In other words, the start and end points of a train track are  and , where  represents the row number,  represents the starting column, and  represents the ending column of the train track.

 The mayor of Gridland is surveying the city to determine the number of locations where lampposts can be placed. A lamppost can be placed in any cell that is not occupied by a train track.

 Given a map of Gridland and its  train tracks, find and print the number of cells where the mayor can place lampposts.

 Note: A train track may (or may not) overlap other train tracks within the same row.

 Input Format

 The first line contains three space-separated integers describing the respective values of  (the number of rows),  (the number of columns), and  (the number of train tracks).
 Each line  of the  subsequent lines contains three space-separated integers describing the respective values of , , and  that define a train track.

 Constraints

 Output Format

 Print a single integer denoting the number of cells where the mayor can install lampposts.

 Sample Input

 4 4 3
 2 2 3
 3 1 4
 4 4 4
 Sample Output


 */
public class TestAlg4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long row = in.nextInt();
        long column = in.nextInt();
        int k = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        long sum = row * column;
        for (int i = 0; i < k; i++) {
            int rowK = in.nextInt();
            int c1 = in.nextInt();
            int c2 = in.nextInt();
            if(map.containsKey(rowK-1) && c1 <= map.get(rowK-1) ){
                long point = map.get(rowK-1);

                long i1 = c2 - point;
                if(i1 > 0) {
                    map.put(rowK-1, c2);
                    sum -= i1;
                }
            } else {
                map.put(rowK-1, c2);
                sum -= (c2 - c1) + 1;
            }
        }
        System.out.println(sum);
    }
}
