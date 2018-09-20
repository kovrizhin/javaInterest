package hackerTest;

import sun.reflect.generics.tree.Tree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


/*
*
https://www.hackerrank.com/challenges/similarpair/topics

A pair of nodes, , is a similar pair if both of the following conditions are true:

Node  is the ancestor of node
Given a tree where each node is labeled from  to , can you find the number of similar pairs in the tree?

Input Format

The first line contains two space-separated integers,  (the number of nodes) and  (the similar pair qualifier), respectively.
Each line  of the  subsequent lines contains two space-separated integers defining an edge connecting nodes  and , where node  is a parent to node .

Constraints

Output Format

Print a single integer denoting the number of similar pairs in the tree.

Sample Input

5 2
3 2
3 1
1 4
1 5
Sample Output

4
Explanation

The similar pairs are , , , and , so we print  as our answer. Observe that  and  are not similar pairs because they do not satisfy .



*/

public class SimilarPair {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[][] edges = new int[n-1][2];

        for (int edgesRowItr = 0; edgesRowItr < n-1; edgesRowItr++) {
            String[] edgesRowItems = scanner.nextLine().split(" ");

            for (int edgesColumnItr = 0; edgesColumnItr < 2; edgesColumnItr++) {
                int edgesItem = Integer.parseInt(edgesRowItems[edgesColumnItr].trim());
                edges[edgesRowItr][edgesColumnItr] = edgesItem;

            }
        }
        NodeTree[] nodes = new NodeTree[n + 1];
        Tree tree = new Tree();
        int[] edge1 = edges[0];
        NodeTree root = new NodeTree(edge1[0]);
        NodeTree child = new NodeTree(edge1[1]);
        tree.root = root;
        root.child.add(child);
        nodes[edge1[0]] = root;
        nodes[edge1[1]] = child;


        for (int i = 1; i < edges.length; i++) {
            int[] edge = edges[i];
//            NodeTree parent = new NodeTree(edge[0]);
            NodeTree c = new NodeTree(edge[1]);
//            parent.child.add(child);
            nodes[edge[0]].child.add(c);
            nodes[edge[1]] = c;
        }

        System.out.println(tree.calc(k));
//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
    }


    private static class Tree {
        public NodeTree root;


        public long calc(int k){
            TreeSet<Integer> set = new TreeSet<>();
            long calc = calc(root, new ArrayList<>(), k);
            System.out.println(calc);
            calc = calc(root, new TreeSet<>(), k);
            System.out.println(calc);
            return calc;
        }

//        private long calc(NodeTree node, TreeSet<Integer> set, int k) {
//
//            if(node.child.isEmpty()){
//                return set.subSet(node.id - k, true, node.id + k, true).size();
//            } else {
//                set.add(node.id);
//                long res = 0;
//                for (NodeTree nodeTree : node.child) {
//                    res += calc(nodeTree, set, k);
//                }
//                set.remove(node.id);
//                res +=set.subSet(node.id - k, true, node.id + k, true).size();
//                return res;
//            }
//        }

        private long calc(NodeTree node, TreeSet<Integer> set, int k) {

            if(node.child.isEmpty()){
                int res = set.subSet(node.id - k, true, node.id + k, true).size();
//                System.out.println("id: " + node.id + " " + res +" " + set + "  "  + (node.id - k) + "  "  + (node.id + k));
                return res;
            } else {
                set.add(node.id);
                long res = 0;
                for (NodeTree nodeTree : node.child) {
                    res += calc(nodeTree, set, k);
                }
                set.remove(node.id);
                int res1 = set.subSet(node.id - k, true, node.id + k, true).size();
//                System.out.println("id: " + node.id + " " + res1 +" " + set + "  "  + (node.id - k) + "  "  + (node.id + k));
                res += res1;
//                System.out.println(res);
                return res;
            }
        }
        private long calc(NodeTree node, ArrayList<Integer> set, int k) {
            if(node.child.isEmpty()){
                int res = 0;
                int first = Collections.binarySearch(set, node.id - k);
                int last = Collections.binarySearch(set, node.id + k);
                if(first < 0 && last >= 0){
                    res += 1;
                } else {

                }
///                if(last < 0 && first >= 0){
//                    res -= 1;
//                }

                res += conv(last) - conv(first);
//                System.out.println("id: " + node.id + " " + res +" " + set + "  "  + (node.id - k) + "  "  + (node.id + k));
                return res;
            } else {
                long res = 0;
                int index = Collections.binarySearch(set, node.id);
                set.add(Math.abs(index )-1, node.id);
                for (NodeTree nodeTree : node.child) {
                    res += calc(nodeTree, set, k);
                }
                int i = Collections.binarySearch(set, node.id);
                set.remove(i);
                int first = Collections.binarySearch(set, node.id - k);
                int last = Collections.binarySearch(set, node.id + k);
//                if(first < 0 && last < 0 || first >=0 && last >=0){
                    long  res1 = conv(last) - conv(first);
//                } else
                    if(first < 0 && last >= 0){
                        res += 1;
                    }

//                long res1 = conv(last) - conv(first);
                res += res1;
//                System.out.println("id: " + node.id + " " + res1 +" " + set + "  "  + (node.id - k) + "  "  + (node.id + k));
//                System.out.println(res);
                return res;
            }
        }

        private long conv(int last) {
            if(last < 0){
                return Math.abs(last) -1;
            } else {
                return last;
            }

        }

    }
    private static class NodeTree {
        public final List<NodeTree> child = new ArrayList<>();
        public final Integer id;

        public NodeTree(Integer id) {
            this.id = id;
        }
    }
}
