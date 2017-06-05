package binary;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by oleg on 8/15/16
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree<Integer, String> binaryTree = new BinaryTree<>();
        binaryTree.add(10, "10");
        binaryTree.add(6, "6");
        binaryTree.add(3, "3");
        binaryTree.add(8, "8");
        binaryTree.add(7, "7");
        binaryTree.add(14, "14");
        binaryTree.add(2, "2");
        binaryTree.add(21, "21");
        binaryTree.add(12, "12");
        binaryTree.add(9, "9");
        binaryTree.add(30, "30");
        binaryTree.add(18, "18");
        binaryTree.add(1, "1");


        System.out.println(binaryTree.keySet());
        System.out.println(binaryTree.remove(10));
        System.out.println(binaryTree.keySet());
        System.out.println(binaryTree.remove(30));
        System.out.println(binaryTree.keySet());
        System.out.println(binaryTree.remove(8));
        System.out.println(binaryTree.keySet());
        System.out.println(binaryTree.remove(3));
        System.out.println(binaryTree.keySet());
        System.out.println(binaryTree.remove(2));
        System.out.println(binaryTree.keySet());
        System.out.println(binaryTree.remove(6));
        System.out.println(binaryTree.keySet());
        System.out.println(binaryTree.remove(7));
        System.out.println(binaryTree.keySet());
        System.out.println(binaryTree.remove(21));
        System.out.println(binaryTree.keySet());
        System.out.println(binaryTree.remove(1));
        System.out.println(binaryTree.keySet());

        Iterator<Map.Entry<Integer, String>> iterator = binaryTree.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> next = iterator.next();
            if(next.getKey().equals(18)){
                iterator.remove();
            }
        }
        System.out.println(binaryTree.keySet());


        System.out.println(binaryTree.remove(9));
        System.out.println(binaryTree.keySet());
        System.out.println(binaryTree.remove(12));
        System.out.println(binaryTree.keySet());
        System.out.println(binaryTree.remove(14));
        System.out.println(binaryTree.keySet());
//        System.out.println(binaryTree.size());


//        binaryTree.add(7);
//        binaryTree.add(10);
//        binaryTree.add(9);
//        binaryTree.add(8);
//        binaryTree.add(7);
//        binaryTree.add(6);
//        binaryTree.add(5);

//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.stream()

        binaryTree.forEach((k, v) -> System.out.println("key= " + k + " value= " + v));
//        System.out.println(binaryTree);
    }

}
