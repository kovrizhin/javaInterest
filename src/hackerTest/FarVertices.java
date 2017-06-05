package hackerTest;

import java.util.*;

/**
 * Created by oleg on 3/28/17
 */
public class FarVertices {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int size = in.nextInt();
        TreeNode[] nodes = new TreeNode[n];
        int[] counts = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int first = in.nextInt();
            int second = in.nextInt();
            int min = Math.min(first, second);
            int max = Math.max(first, second);
            System.out.println(min + " " + max);
            if (nodes[min -1] == null) {
                nodes[min -1] = new TreeNode(min);
            }
            if (nodes[max -1] == null) {
                nodes[max -1] = new TreeNode(max);
            }
            nodes[min-1].getChilds().add(nodes[max-1]);
            nodes[max-1].getChilds().add(nodes[min-1]);

        }

        for (int i = 0; i < n -1; i++) {
            countEdges(nodes[i], counts, nodes[i], nodes[i],1, size);
        }
//        System.out.println(Arrays.toString(counts));

        int max = Arrays.stream(counts).max().getAsInt();
        if(max != 0) {
            System.out.println(n - (1  + max ) );
        } else {
            System.out.println(max -2);
        }


    }

    private static void countEdges(TreeNode root, int[] counts, TreeNode current, TreeNode parent, int deep, int maxSize) {
        if(deep < maxSize) {
            counts[root.getId() - 1] += current.getChilds().size();
            for (int i = 0; i < current.getChilds().size(); i++) {
                if(parent.getId() != current.getChilds().get(i).getId()){
                    countEdges(root, counts, current.getChilds().get(i), current,deep+1, maxSize);
                    break;
                } else {
                    counts[root.getId() - 1]--;
                }

            }
        }
    }


}
class Node{
    private int id;
    private List<TreeNode> childs;

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<TreeNode> getChilds() {
        if(childs == null){
            childs = new ArrayList<>();
        }
        return childs;
    }
}
