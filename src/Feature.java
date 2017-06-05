

import sirialization.ClassB;

import java.util.Calendar;
import java.util.concurrent.*;
import java.util.function.Supplier;


/**
 * Created by oleg on 7/2/15.
 */
public class Feature {
//    CompletableFuture
    private class ObjectHolder {
        Integer test;
    }

    private void testFeature(){
        Runnable a = () -> System.out.println("a");
        final ObjectHolder objectHolder = new ObjectHolder();
        Callable<Integer> callable = () -> {
            for (int i = 0; i < 1000000000L; i++) {
                int i1 = i * 2;

            }
            objectHolder.test = 10;
            System.out.println("complete");
            return 1;
        };
        System.out.println(objectHolder.test);
//        FutureTask future = new FutureTask(callable);
        FutureTask<Integer> future = new FutureTask<>(callable);
        Object w = null;
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        try {
//            future.run();
            forkJoinPool.execute(future);
            System.out.println("run");
            w = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(w);
        Calendar instance = Calendar.getInstance();
//        instance.compareTo()


        System.out.println(objectHolder.test);
        System.out.println(future.isDone());
        try {
            Thread.sleep(1000);
            System.out.println(future.isDone());
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        forkJoinPool.execute(future);
        System.out.println(future.isDone());
        try {
            Thread.sleep(1000);
            Object x = future.get();
            System.out.println(x);
        } catch (InterruptedException e) {
            System.out.println(e);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public void testCompleatableFuture(){
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        System.out.println(completableFuture.isDone());
        completableFuture.handle((o, o2) -> 43);
        try {
            System.out.println(completableFuture.get(1l, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        completableFuture.complete(42);
        System.out.println(completableFuture.isDone());
        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    public void testCompleatableFuture2(){
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        CompletableFuture.runAsync(() -> System.out.println(23));

        try {
            System.out.println(completableFuture.isDone());
            System.out.println(completableFuture.get(1l, TimeUnit.SECONDS));
            System.out.println(completableFuture.isDone());
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
//        try {
//            System.out.println(completableFuture.join());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//
//  }
        System.out.println(completableFuture.isDone());
        completableFuture.complete(42);
        System.out.println(completableFuture.isDone());
        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }


    public void testCompleatableFuture3() {
//        CompletableFuture<Integer> completableFuture = new CompletableFuture<Integer>();
         CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
             System.out.println("Suply");
             return 1;
         });

        try {
            Thread.sleep(1000);
            System.out.println(completableFuture.isDone());

            System.out.println(completableFuture.isDone());
            System.out.println(completableFuture.join());
            System.out.println(completableFuture.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }
//        try {
//            System.out.println(completableFuture.join());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//
//  }


        System.out.println(completableFuture.isDone());
        completableFuture.complete(42);
        System.out.println(completableFuture.isDone());
        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void getPrintln(Integer a) {
        System.out.println(a);
    }

    public static void main(String[] args) {
        Feature feature = new Feature();
//        feature.testFeature();
        feature.testFeature();
    }



}
