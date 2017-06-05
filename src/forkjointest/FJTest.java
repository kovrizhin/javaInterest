package forkjointest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by oleg on 5/19/16.
 */
public class FJTest {



    public static void main(String[] args) {
        Node root = getRootNode();

        Long invoke = new ForkJoinPool().invoke(new ValueSumCounter(root));
        System.out.println(invoke);
    }


    public static Node getRootNode() {
        Node node = new NodeImpl();
        node.getChildren().add(new NodeImpl());
        node.getChildren().add(new NodeImpl());
        node.getChildren().add(new NodeImpl());
        node.getChildren().add(new NodeImpl());
        node.getChildren().add(new NodeImpl());
        return node;
    }
}
