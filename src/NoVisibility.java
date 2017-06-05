public class NoVisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread {
        public void run() {
            int count = 0;
            while (!ready) {
                Thread.yield();
                Thread.yield();
                Thread.yield();
                Thread.yield();
                Thread.yield();
                Thread.yield();
                Thread.yield();
                Thread.yield();
                count++;

            }
//            Thread.yield();
            System.out.println(count);
            System.out.println(number);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.currentThread().sleep(1000l);
        number = 42;
        ready = true;
    }
}