package threads;

import java.util.concurrent.*;

/**
 * Created by oleg on 3/1/17
 */
public class Thread1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Void> future = executor.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                System.out.println("** Started");
                Thread.sleep(2000);
                throw new NullPointerException("exception from thread");
            }
        });
        try {
            future.get(); // raises ExecutionException for any uncaught exception in child
        } catch (ExecutionException e) {
            System.out.println("** RuntimeException from thread ");
            e.getCause().printStackTrace(System.out);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println("** Main stopped");


        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    throw new ArrayIndexOutOfBoundsException();
                }
            }).start();

        } catch (Throwable e) {
            System.out.println("error");
        }
    }
}



