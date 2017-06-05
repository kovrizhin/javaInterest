package hackerTest;

import java.util.*;

/**
 * Created by oleg on 3/28/17
 *
 *
 You are given a tree that has N vertices and N-1 edges. Your task is to mark as small number of vertices as possible, such that, the maximum distance between two unmarked vertices is less than or equal to K. Output this value. Distance between two vertices i and j is defined as the minimum number of edges you have to pass in order to reach vertex i from vertex j.

 Input Format
 The first line of input contains two integers N and K. The next N-1 lines contain two integers (ui,vi) each, where 1 <= ui,vi <= N. Each of these lines specifies an edge.
 N is no more than 100. K is less than N.

 Output Format
 Print an integer that denotes the result of the test.

 Sample Input:

 5 1
 1 2
 1 3
 1 4
 1 5
 Sample Output:

 3
 Sample Input:

 5 2
 1 2
 1 3
 1 4
 1 5
 Sample Output:

 0
 Explanation:

 In the first case you have to mark at least 3 vertices, and in the second case you don't need to mark any vertices.

 Submissions: 523
 Max Score: 70
 Difficulty: Hard
 Rate This Challenge:

 More
 Current Buffer (saved locally, editable)

 https://www.hackerrank.com/challenges/far-vertices

 */
public class FarVertices2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int maxDeep = in.nextInt();
        TreeNode[] nodes = new TreeNode[n];
        int[] counts = new int[n];
        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int first = in.nextInt();
            int second = in.nextInt();
            int min = Math.min(first, second);
            int max = Math.max(first, second);
            System.out.println(min + " " + max);
            if (nodes[min - 1] == null) {
                nodes[min - 1] = new TreeNode(min);
            }
            if (nodes[max - 1] == null) {
                nodes[max - 1] = new TreeNode(max);
            }
            nodes[min - 1].getChilds().add(nodes[max - 1]);
            nodes[max - 1].getChilds().add(nodes[min - 1]);
            pairs.add(Arrays.asList(min, max));
        }

        int count = 0;
        if(maxDeep % 2 == 0) {
            int radius = maxDeep / 2;
            for (int i = 0; i < n -1; i++) {
                count = Math.max(countEdges(nodes[i], nodes[i], 0, radius), count);
            }
        } else {

            int radius = maxDeep - maxDeep / 2;
            for (List<Integer> pair : pairs) {
                int curCount = countEdges(nodes[pair.get(0) -1], nodes[pair.get(1) - 1], 1, radius);
                curCount += countEdges(nodes[pair.get(1) - 1], nodes[pair.get(0) - 1], 1, radius);
                curCount += 1;
                count = Math.max(count, curCount);

            }

        }


        System.out.println((n -1) - count);


    }

    private static int countEdges( TreeNode current, TreeNode parent, int deep, int maxDeep) {
        if (deep < maxDeep) {
            int count = current.getChilds().size();
            for (TreeNode treeNode : current.getChilds()) {
                if (treeNode.getId() != parent.getId()) {
                    count += countEdges( treeNode, current, deep + 1, maxDeep);
                } else {
                    count -= 1;
                }
            }
            return count;
        } else if (deep == maxDeep) {
            return current == parent ? 1 : 0;
        } else {
            return 0;
        }
    }


}

class TreeNode {
    private int id;
    private List<TreeNode> childs;

    public TreeNode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<TreeNode> getChilds() {
        if (childs == null) {
            childs = new ArrayList<>();
        }
        return childs;
    }
}
