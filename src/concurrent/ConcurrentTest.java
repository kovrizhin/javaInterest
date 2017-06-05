package concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * Created by oleg on 2/28/17
 */
public class ConcurrentTest {


    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(false);

        Semaphore semaphore = new Semaphore(2, true);


        new Thread(new Bulb("first", reentrantLock)).start();
        new Thread(new Bulb("seconds", reentrantLock)).start();
    }
}
class Bulb implements Runnable {

    private final String name;
    private final ReentrantLock lock;

    public Bulb(String name, ReentrantLock reentrantLock) {
        this.name = name;
        this.lock = reentrantLock;
    }

    public void run() {
        Thread self = currentThread();
        while(!self.isInterrupted()) {
            lock.lock();
            System.out.println(name + " bulb is on");
            try {
                sleep(300);
            } catch (InterruptedException e) {
                self.interrupt();
            }
            System.out.println(name + " bulb is off");
            lock.unlock();
        }
    }
}
