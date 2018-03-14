package concurency2.deadlockdemo;// DeadlockDemo.java

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class DeadlockDemo
{
   public static void main (String [] args)
   {

      DeadlockDetector deadlockDetector = new DeadlockDetector(new DeadlockConsoleHandler(), 5, TimeUnit.SECONDS);
      deadlockDetector.start();

      FinTrans ft = new FinTrans ();

      TransThread tt1 = new TransThread (ft, "Deposit Thread");
      TransThread tt2 = new TransThread (ft, "Withdrawal Thread");

      tt1.start ();
      tt2.start ();
   }
}

class FinTrans
{
   public static String transName;
   public static double amount;
}

class TransThread extends Thread
{
   private FinTrans ft;

   private static String anotherSharedLock = "";

   TransThread (FinTrans ft, String name)
   {
      super (name); // Save thread's name.

      this.ft = ft; // Save reference to financial transaction object.
   }

   public void run ()
   {
      for (int i = 0; i < 100; i++)
      {
           if (getName ().equals ("Deposit Thread"))
           {
               synchronized (ft)
               {
                  synchronized (anotherSharedLock)
                  {
                     ft.transName = "Deposit";

                     try
                     {
                        Thread.sleep ((int) (Math.random () * 1000));
                     }
                     catch (InterruptedException e)
                     {
                     }

                     ft.amount = 2000.0;

                     System.out.println (ft.transName + " " + ft.amount);
                  }
               }
           }
           else
           {
               synchronized (anotherSharedLock)
               {
                  synchronized (ft)
                  {
                     ft.transName = "Withdrawal";

                     try
                     {
                        Thread.sleep ((int) (Math.random () * 1000));
                     }
                     catch (InterruptedException e)
                     {
                     }

                     ft.amount = 250.0;

                     System.out.println (ft.transName + " " + ft.amount);
                  }
               }
           }
      }
   }
}


interface DeadlockHandler {
   void handleDeadlock(final ThreadInfo[] deadlockedThreads);
}

class DeadlockDetector {

   private final DeadlockHandler deadlockHandler;
   private final long period;
   private final TimeUnit unit;
   private final ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
   private final ScheduledExecutorService scheduler =
           Executors.newScheduledThreadPool(1);

   final Runnable deadlockCheck = new Runnable() {
      @Override
      public void run() {
         long[] deadlockedThreadIds = DeadlockDetector.this.mbean.findDeadlockedThreads();

         if (deadlockedThreadIds != null) {
            ThreadInfo[] threadInfos =
                    DeadlockDetector.this.mbean.getThreadInfo(deadlockedThreadIds);

            DeadlockDetector.this.deadlockHandler.handleDeadlock(threadInfos);
         }
      }
   };

   public DeadlockDetector(final DeadlockHandler deadlockHandler,
                           final long period, final TimeUnit unit) {
      this.deadlockHandler = deadlockHandler;
      this.period = period;
      this.unit = unit;
   }

   public void start() {
      this.scheduler.scheduleAtFixedRate(
              this.deadlockCheck, this.period, this.period, this.unit);
   }
}

class DeadlockConsoleHandler implements DeadlockHandler {

   @Override
   public void handleDeadlock(final ThreadInfo[] deadlockedThreads) {
      if (deadlockedThreads != null) {
         System.err.println("Deadlock detected!");

         Map<Thread, StackTraceElement[]> stackTraceMap = Thread.getAllStackTraces();
         for (ThreadInfo threadInfo : deadlockedThreads) {

            if (threadInfo != null) {

               for (Thread thread : Thread.getAllStackTraces().keySet()) {

                  if (thread.getId() == threadInfo.getThreadId()) {
                     System.err.println(threadInfo.toString().trim());

                     for (StackTraceElement ste : thread.getStackTrace()) {
                        System.err.println("\t" + ste.toString().trim());
                     }
                  }
               }
            }
         }
      }
   }
}