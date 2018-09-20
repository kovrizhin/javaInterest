package hackerTest;

import java.io.*;

public class TaskScheduling6{

    public static void main(String[] args){

        try{
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();

            int t = Integer.parseInt(s);
            RedBlack tree = new RedBlack();
            int delaySoFar = 0;
            for(int i=0; i<t; i++){
                String[] nextpoint = br.readLine().split(" ");
                int d = Integer.parseInt(nextpoint[0]);
                int m = Integer.parseInt(nextpoint[1]);
//				System.out.println(delaySoFar);
                tree.insert(d,m);
                delaySoFar = tree.getMaxOver();
                System.out.println(Math.max(delaySoFar,0));
//				System.out.println(tree);
            }
        }catch (Exception e) {
            System.err.println("Error:" + e.getMessage());
        }
    }
}


/* Java implementation of red-black trees as described in
 **   Alternatives to Two Classic Data Structures
 **   Chris Okasaki
 **   SIGCSE 2005
 **
 ** Implements a set of integers.  Can easily be adapted to other
 ** key types, or to other abstractions such as bags/dictionaries/etc.
 */

class RedBlack {

    public RedBlack() {
        root = null;
    }

    public void insert(int deadline, int minutes) {
        root = insert(deadline, minutes,root);
    }

	/*public boolean member(int key) {
		return member(key, root);
	}

	public int getDurationBefore(int d){
		return getMaxOver(root);
	}*/

    public int getMaxOver(){
        return getMaxOver(root);
    }

    public String toString(){
        return toString(root);
    }

    /***** Implementation details *****/

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private static class Tree {
        int key;
        boolean color;
        Tree left;
        Tree right;
        int minutes;
        int totalDuration;
        int maxOver;
    }

    private Tree root;

    private static Tree insert(int key, int minutes, Tree tree) {
        tree = ins(key, minutes,tree);
        tree.color = BLACK;  // always recolor root black
        return tree;
    }

    private static Tree ins(int key, int minutes, Tree tree) {
        if (tree == null) {
            tree = new Tree();
            tree.key = key;
            tree.color = RED;
            tree.left = null;
            tree.right = null;
            tree.minutes = minutes;
            tree.totalDuration = minutes;
            tree.maxOver = minutes - key;
        }
        else if (key < tree.key) {
            tree.totalDuration += minutes;
            tree.left = ins(key, minutes, tree.left);
        }
        else if (key > tree.key) {
            tree.totalDuration += minutes;
            tree.right = ins(key, minutes, tree.right);
        }else {
            tree.totalDuration += minutes;
            tree.minutes += minutes;
        }
        computeMaxOver(tree);

		/*
		// check for red child and red grandchild
		if (isRed(tree.left) && isRed(tree.left.left)) {
			//       z           y
			//      / \         / \
			//     y   D  ==>  /   \
			//    / \         x     z
			//   x   C       / \   / \
			//  / \         A   B C   D
			// A   B
			tree = balance(tree.left.left, tree.left, tree,              // x,y,z
						   tree.left.left.left, tree.left.left.right,	 // A,B
						   tree.left.right, tree.right);				 // C,D
		}
		else if (isRed(tree.left) && isRed(tree.left.right)) {
			//       z           y
			//      / \         / \
			//     x   D  ==>  /   \
			//    / \         x     z
			//   A   y       / \   / \
			//      / \     A   B C   D
			//     B   C
			tree = balance(tree.left, tree.left.right, tree,             // x,y,z
						   tree.left.left, tree.left.right.left,		 // A B
						   tree.left.right.right, tree.right);			 // C,D
		}
		else if (isRed(tree.right) && isRed(tree.right.left)) {
			//     x             y
			//    / \           / \
			//   A   z    ==>  /   \
			//      / \       x     z
			//     y   D     / \   / \
			//    / \       A   B C   D
			//   B   C
			tree = balance(tree, tree.right.left, tree.right,            // x,y,z
						   tree.left, tree.right.left.left,				 // A,B
 						   tree.right.left.right, tree.right.right);     // C,D
		}
		else if (isRed(tree.right) && isRed(tree.right.right)) {
			//   x               y
			//  / \             / \
			// A   y      ==>  /   \
			//    / \         x     z
			//   B   z       / \   / \
			//      / \     A   B C   D
			//     C   D
			tree = balance(tree, tree.right, tree.right.right,           // x,y,z
						   tree.left, tree.right.left,					 // A,B
						   tree.right.right.left, tree.right.right.right); // C,D
		}*/

        return tree;
    }

    private static void computeMaxOver(Tree tree){
        tree.maxOver = Math.max(getMaxOver(tree.left),
                Math.max(getDuration(tree.left) + tree.minutes-tree.key,
                        getDuration(tree.left) + tree.minutes + getMaxOver(tree.right)));
    }

    private static Tree balance(Tree x, Tree y, Tree z, Tree A, Tree B, Tree C, Tree D) {
        // Rearrange/recolor the tree as
        //       y      <== red
        //      / \
        //     /   \
        //    x     z   <== both black
        //   / \   / \
        //  A   B C   D
        //
        // Note: A and D are not passed in because already in the right place

        x.right = B;
        y.left = x;
        y.right = z;
        z.left = C;
        x.color = BLACK;
        y.color = RED;
        z.color = BLACK;

        computeMaxOver(x);
        computeMaxOver(z);
        computeMaxOver(y);

        return y;
    }

    private static boolean isRed(Tree tree) {
        return tree != null && tree.color == RED;
    }

    private static int getDuration(Tree tree){
        return (tree == null) ? 0 : tree.totalDuration;
    }
    private static int getMinutes(Tree tree){
        return (tree == null) ? 0 : tree.minutes;
    }
    private static int getMaxOver(Tree tree){
        return (tree == null) ? -100001 : tree.maxOver;
    }

	/*
	private static boolean member(int key, Tree tree) {
		while (tree != null) {
			if (key < tree.key) {
				tree = tree.left;
			}
			else if (key > tree.key) {
				tree = tree.right;
			}
			else { // key == tree.key
				return true;
			}
		}

		return false;
	}


	private static int getDurationBefore(int deadline,Tree tree){
		if (tree == null) {
			return 0;
		}
		if (deadline < tree.key) {
			return getDurationBefore(deadline,tree.left);
		}
		else{
			return getDuration(tree.left) + tree.minutes + getDurationBefore(deadline,tree.right);
		}
	}

	private static int getMaxDelayAfter(int deadline, Tree tree){
		if (tree == null) {
			return -100001;
		}
		if (deadline < tree.key) {
			return Math.max(Math.max(tree.minutes-tree.key,getMaxOver(tree.right)),getMaxDelayAfter(deadline,tree.left));
		}
		else {
			return getMaxDelayAfter(deadline,tree.right);
		}
	}*/

    private static String toString(Tree tree){
        String out = "[";
        if (tree.left != null) {
            out += toString(tree.left);
        }
        out += " (" + tree.key + "," + tree.minutes + "), total: " + tree.totalDuration + ", maxOver: " + tree.maxOver + " ";
        if (tree.right != null){
            out += toString(tree.right);
        }
        out += "]";
        return out;
    }

}