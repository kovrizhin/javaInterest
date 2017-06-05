package threads;

/**
 * Created with IntelliJ IDEA.
 * User: oleg
 * Date: 4/22/14
 * Time: 4:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadTest {
    private final Object monitor = new Object();


    private class ThreadA extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("Start Thread A");
            synchronized (monitor){
                try {
                    System.out.println("Before Wait");
                    monitor.wait();
                } catch (InterruptedException e) {
                    System.out.println("Exception Wait");
                }
                System.out.println("After waiting");
            }
        }
    }

    private class ThreadB extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("Start Thread B");
            synchronized (monitor){
                try {
                    System.out.println("SLLEEEP");
                    currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Sleep exception");
                }
                monitor.notifyAll();
                System.out.println("After notify");
            }
        }
    }

    public void start(){
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
//        try {
//            Thread.currentThread().sleep(2000);
//        } catch (InterruptedException e) {
//            System.out.println("Thread");
//        }
        threadA.start();
        threadB.start();

    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
    }
}
