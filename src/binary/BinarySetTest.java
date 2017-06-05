package binary;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by oleg on 8/15/16
 */
public class BinarySetTest {

    public static void main(String[] args) {
        BinarySet<Integer> binaryTree = new BinarySet<>();
        binaryTree.add(10);
        binaryTree.add(6);
        binaryTree.add(3);
        binaryTree.add(8);
        binaryTree.add(14);
        binaryTree.add(2);
        binaryTree.add(21);
        binaryTree.add(12);
        binaryTree.add(30);
        binaryTree.add(18);
        binaryTree.add(1);
//        binaryTree.add(7);
//        binaryTree.add(10);
//        binaryTree.add(9);
//        binaryTree.add(8);
//        binaryTree.add(7);
//        binaryTree.add(6);
//        binaryTree.add(5);

//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.stream()

        binaryTree.forEach(System.out::println);
//        System.out.println(binaryTree);
    }

}
