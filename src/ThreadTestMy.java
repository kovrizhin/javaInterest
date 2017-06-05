/**
 * Created by oleg on 12/24/15.
 */
public class ThreadTestMy {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                throw new  RuntimeException("Thread xui");
            }
        }

        ).start();
        try {
            Thread.currentThread().sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new  RuntimeException("Xui");
    }
}
