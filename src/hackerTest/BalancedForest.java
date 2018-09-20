package hackerTest;

import java.io.IOException;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/*
Greg has a tree of nodes containing integer data. He wants to insert a node with some non-zero integer value somewhere into the tree. His goal is to be able to cut two edges and have the values of each of the three new trees sum to the same amount. This is called a balanced forest. Being frugal, the data value he inserts should be minimal. Determine the minimal amount that a new node can have to allow creation of a balanced forest. If it's not possible to create a balanced forest, return -1.

For example, you are given node values  and . It is the following tree:

image

The blue node is root, the first number in a node is node number and the second is its value. Cuts can be made between nodes  and  and nodes  and  to have three trees with sums ,  and . Adding a new node  of  to the third tree completes the solution.

Function Description

Complete the balancedForest function in the editor below. It must return an integer representing the minimum value of that can be added to allow creation of a balanced forest, or  if it is not possible.

balancedForest has the following parameter(s):

c: an array of integers, the data values for each node
edges: an array of 2 element arrays, the node pairs per edge
Input Format

The first line contains a single integer, , the number of queries.

Each of the following  sets of lines is as follows:

The first line contains an integer, , the number of nodes in the tree.
The second line contains  space-separated integers describing the respective values of , where each denotes the value at node .
Each of the following  lines contains two space-separated integers,  and , describing edge  connecting nodes  and .
Constraints

Each query forms a valid undirected tree.
Subtasks

For  of the maximum score:

For  of the maximum score:

Output Format

For each query, return the minimum value of the integer . If no such value exists, return  instead.

Sample Input

2
5
1 2 2 1 1
1 2
1 3
3 5
1 4
3
1 3 5
1 3
1 2
Sample Output


1
5
1 2 2 1 1
1 2
1 3
3 5
1 4

2
-1
Explanation


5
6
7 7 4 1 1 1
1 2
3 1
2 4
2 5
2 6
8
1 1 1 18 10 11 5 6
1 2
1 4
2 3
1 8
8 7
7 6
5 7
6
12 7 11 17 20 10
1 2
2 3
4 5
6 5
1 4
8
10 4 1 5 6 4 5 5
1 2
2 3
1 4
5 4
5 6
7 8
7 5
6
100 100 99 99 98 98
1 3
3 5
1 2
2 4
4 6


-1
10
13
5
297

1
8
1 1 1 18 10 11 5 6
1 2
1 4
2 3
1 8
8 7
7 6
5 7
6
We perform the following two queries:

The tree initially looks like this:
image
Greg can add a new node  with  and create a new edge connecting nodes  and . Then he cuts the edge connecting nodes  and  and the edge connecting nodes  and . We now have a three-tree balanced forest where each tree has a sum of .

image

In the second query, it's impossible to add a node in such a way that we can split the tree into a three-tree balanced forest so we return .
 */


public class BalancedForest {

  static Set<Integer> first = new HashSet<Integer>();
  static Set<Integer> second = new HashSet<Integer>();
  static Set<Integer> third = new HashSet<Integer>();
  // Complete the balancedForest function below.

  static long balancedForest(int[] c, int[][] edges) {
    first.clear();
    second.clear();
    third.clear();
    for (int[] i : edges) {
      if (i[0] == 1) {
        if (first.isEmpty()) {
          first.add(i[1]);
        } else if (second.isEmpty()) {
          second.add(i[1]);
        } else if (third.isEmpty()) {
          third.add(i[1]);
        }
      } else {
        if (first.contains(i[0])) {
          first.add(i[1]);
        }
        if (second.contains(i[0])) {
          second.add(i[1]);
        }
        if (third.contains(i[0])) {
          third.add(i[1]);
        }
      }


    }
    long sum = IntStream.of(c).sum();
    long avg = (sum / 3);
    long half = (sum / 2) + 1;
    long one = 0;
    long two = 0;
    long three = 0;
    int length = c.length;
    for (int i = length - 1; i > 0; i--) {
      int v = c[i];
      if (first.contains(edges[i - 1][1])) {
        one += v;
        if (one > avg && one < half) {

          long res = test(c, one, sum, two, i + 2);
          if (res > 0) {
            return res;
          }

          res = test(c, one, sum, three, i + 1);
          if (res > 0) {
            return res;
          }

        }
      }
      if (second.contains(edges[i - 1][1])) {
        two += v;
        if (two > avg && two < half) {
          long res = test(c, two, sum, three, i + 2);
          if (res > 0) {
            return res;
          }

          res = test(c, two, sum, one, i + 1);
          if (res > 0) {
            return res;
          }
        }

      }
      if (third.contains(edges[i - 1][1])) {
        three += v;
        if (three > avg && three < half) {
          long res = test(c, three, sum, two, i + 1);
          if (res > 0) {
            return res;
          }

          res = test(c, three, sum, one, i + 2);
          if (res > 0) {
            return res;
          }
        }

      }
    }
    return -1;
  }

  private static long test(int[] c, long pivot, long sum, long otherValue, int startTestIndex) {
    do {
      if (otherValue == pivot) {
        return pivot - Math.abs(sum - (2 * pivot));
      }
      startTestIndex -= 3;
      if (startTestIndex > 0) {
        otherValue += c[startTestIndex];
      } else {
        otherValue += c[0];
        if (otherValue == pivot) {
          return pivot - Math.abs(sum - (2 * pivot));
        }
      }
    }
    while (startTestIndex >= 0 && otherValue <= pivot);
    return -1;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {

    int q = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int qItr = 0; qItr < q; qItr++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[] c = new int[n];

      String[] cItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int cItem = Integer.parseInt(cItems[i]);
        c[i] = cItem;
      }

      int[][] edges = new int[n - 1][2];

      for (int i = 0; i < n - 1; i++) {
        String[] edgesRowItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int j = 0; j < 2; j++) {
          int edgesItem = Integer.parseInt(edgesRowItems[j]);
          edges[i][j] = edgesItem;
        }
      }

      long result = balancedForest(c, edges);

      System.out.println(String.valueOf(result));
    }

    scanner.close();
  }
}
