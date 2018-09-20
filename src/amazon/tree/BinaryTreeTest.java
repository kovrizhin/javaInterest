package amazon.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    @Test
    void pushItem() {
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>();
        integerBinaryTree.pushItem(8);
        integerBinaryTree.pushItem(5);
        integerBinaryTree.pushItem(7);
        integerBinaryTree.pushItem(14);
        integerBinaryTree.pushItem(10);
        integerBinaryTree.pushItem(2);
        integerBinaryTree.pushItem(6);
        assertEquals(7, integerBinaryTree.getSize());
    }

    @Test
    void getNext() {
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>();
        integerBinaryTree.pushItem(8);
        integerBinaryTree.pushItem(5);
        integerBinaryTree.pushItem(7);
        integerBinaryTree.pushItem(14);
        integerBinaryTree.pushItem(10);
        integerBinaryTree.pushItem(2);
        integerBinaryTree.pushItem(6);
        assertEquals(7, integerBinaryTree.getSize());
//        assertEquals( -1,integerBinaryTree.stepBetween(1, 2));
        assertEquals( 2,integerBinaryTree.stepBetween(8, 7));
        assertEquals( 4,integerBinaryTree.stepBetween(7, 10));
    }

    public Number[] convert(Integer[] arr){
        return arr;
    }

}