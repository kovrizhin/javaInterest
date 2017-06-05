package hackerTest;

import java.util.Scanner;

/**
 * Created by oleg on 3/30/17
 *
 *
 Lukas is a Civil Engineer who loves designing road networks to connect  cities numbered from  to . He can build any number of bidirectional roads as long as the resultant network satisfies these constraints:

 It must be possible to reach any city from any other city by traveling along the network of roads.
 No two roads can directly connect the same two cities.
 A road cannot directly connect a city to itself.
 In other words, the roads and cities must form a simple connected labeled graph.

 You must answer  queries, where each query consists of some  denoting the number of cities Lukas wants to design a bidirectional network of roads for. For each query, find and print the number of ways he can build roads connecting  cities on a new line; as the number of ways can be quite large, print it modulo .

 Input Format

 The first line contains an integer, , denoting the number of queries.
 Each of the  subsequent lines contains an integer denoting the value of  for a query.

 Constraints

 Output Format

 For each of the  queries, print the number of ways Lukas can build a network of bidirectional roads connecting  cities, modulo , on a new line.

 Sample Input 0

 3
 1
 3
 10
 Sample Output 0

 1
 4
 201986643
 Explanation 0

 We answer the first two queries like this:

 When , the only option satisfying Lukas' three constraints is to not build any roads at all. Thus, we print the result of  on a new line.
 When , there are four ways for Lukas to build roads that satisfy his three constraints: image

 Thus, we print the result of  on a new line.

 https://www.hackerrank.com/challenges/counting-road-networks?h_r=next-challenge&h_v=zen
 */
public class CountingRoadNetworks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            if(n < 10){
                System.out.println(n);
            }
//
        }
    }
}
