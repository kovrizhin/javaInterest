package concurrency.exercises.NamedThreadExecutorDemo;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class NamedThreadExecutorDemo
{
   public static void main(String[] args)
   {
      Runnable r = new Runnable()
                   {
                      @Override
                      public void run()
                      {
                         String name = Thread.currentThread().getName();
                         for (int i = 0; i < 10; i++)
                            System.out.printf("%s: %d%n", name, i);
                      }
                   };
      ExecutorService executor = Executors.newSingleThreadExecutor();
      executor.execute(r);
      executor.shutdown();
   }
}