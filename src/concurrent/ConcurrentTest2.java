package concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * Created by oleg on 2/28/17
 */
public class ConcurrentTest2 {


    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(false);
        AtomicInteger atomicInteger = new AtomicInteger(1);
        Bulb2 first1 = new Bulb2("first", atomicInteger, 0,1);
        Thread first = new Thread(first1);
        Bulb2 seconds1 = new Bulb2("seconds", atomicInteger, 1, 0);
        Thread seconds = new Thread(seconds1);
        first.start();
        seconds.start();
    }
}
class Bulb2 implements Runnable {

    private final String name;
    private final AtomicInteger atomicInteger;
    private final int src;
    private final int target;


    public Bulb2(String name, AtomicInteger atomicInteger, int src, int target) {
        this.name = name;
        this.atomicInteger = atomicInteger;
        this.src = src;
        this.target = target;
    }

    public void run() {
        Thread self = currentThread();
        while(!self.isInterrupted()) {
            while (atomicInteger.get() != src){}
            System.out.println(name + " bulb is on");
            try {
                sleep(300);
            } catch (InterruptedException e) {
                self.interrupt();
            }
            System.out.println(name + " bulb is off");
            atomicInteger.set(target);
        }
    }
}
