package hackerTest;

import java.io.IOException;
import java.util.*;
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


public class BalancedForest2 {

  static Map<Integer, Item> itemMap = new HashMap<>();
  static HashSet<Integer> visited = new HashSet<>();
  static long sum;
  static long elseSum;

  static long balancedForest(int[] c, int[][] edges) {
    itemMap.put(1, new Item(c[0],1));
    sum = IntStream.of(c).asLongStream().sum();
    for (int i = 1; i < c.length; i++) {
      if(itemMap.containsKey(edges[i-1][0])) {
        Item item = new Item(c[i], edges[i - 1][1]);
        Item parentItem = itemMap.get(edges[i - 1][0]);
        parentItem.child.add(item);
        item.child.add(parentItem);
        itemMap.put(edges[i-1][1], item);
      } else if(itemMap.containsKey(edges[i-1][1])) {
        Item item = new Item(c[i], edges[i - 1][0]);
        Item parentItem = itemMap.get(edges[i - 1][1]);
        parentItem.child.add(item);
        item.child.add(parentItem);
        itemMap.put(edges[i-1][0], item);
      }
    }
    Item first = findFirst(itemMap.get(1));
    visited.add(first.id);
    elseSum = sum - first.value;
    calcEnd(first);

    return -1;
  }

  private static int calcEnd(Item first) {
    for (Item item : first.child) {
      if(!visited.contains(item.id)){
        visited.add(item.id);
        HashSet<Integer> visitedSecond = new HashSet<>();
        visitedSecond.add(item.id);
        secondCalc(item, visitedSecond, elseSum);
        elseSum = elseSum - item.value;
        calcEnd(item);
      }
    }
    elseSum += first.value;
    return -1;
  }

  private static void secondCalc(Item item, HashSet<Integer> visitedSecond, long elseSum) {
    for (Item childItem : item.child) {
      if(!visitedSecond.contains(childItem.id)) {
        visitedSecond.add(childItem.id);
        secondCalc(childItem, visitedSecond, elseSum);
      }
    }
  }

  private static Item findFirst(Item itemMap) {
    if(itemMap.child.size() == 0)
      return itemMap;
    else
      return itemMap.child.get(0);

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

  private static class Item {
    int value = 0;
    int id = 0;
    List<Item> child = new ArrayList<>();

    public Item(int value, int id) {
      this.value = value;
      this.id = id;
    }
  }
}
