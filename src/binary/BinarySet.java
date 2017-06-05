package binary;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * Created by oleg on 8/16/16
 */
public class BinarySet<T extends Comparable<T>> extends AbstractSet<T> {
    private BinaryTree<T, Object> m = new BinaryTree<>();
    private Object object = new Object();

    @Override
    public Iterator<T> iterator() {
        return m.keySet().iterator();
    }

    @Override
    public int size() {
        return m.size();
    }

    @Override
    public boolean add(T t) {
        return m.put(t, object) != null;
    }
}
