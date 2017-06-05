package semrushtest;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by oleg on 10/17/16
 */
public class WeakHashMapTest {
    public static void main(String[] args) throws InterruptedException {
        WeakHashMap<Key, String> cache = new WeakHashMap<>();
        Key k1 = new Key(1); cache.put(k1, "A");
        Key k2 = new Key(2); cache.put(k2, "B");
        Key k3 = new Key(3); cache.put(k3, "C");
        k2 = null;

//        Runtime.getRuntime().gc();
//        TimeUnit.SECONDS.sleep(1);
        System.gc();

        System.out.println("Size: " + cache.size());
        System.out.println(cache.get(k1));
        System.out.println(cache.get(k2));
        System.out.println(cache.get(k3));


    }


    private static class Key{
        private int i;

        public Key(int i) {
            this.i = i;
        }

        @Override
        public String toString() {
            return "Key{" +
                    "i=" + i +
                    '}';
        }
    }
}