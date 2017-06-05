package binary;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by oleg on 8/15/16
 */
public class BinaryTree<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private Node<K, V> root;
    private int size;

    public void add(K key, V value) {
        if (root == null) {
            root = new Node<K, V>(key, value, null);
            size = 1;
        } else {
            addNode(key, value, root);
            size++;
        }
    }


    private void addNode(K key, V value, Node<K, V> p) {
        while (p != null) {
            if (key.compareTo(p.getKey()) < 0) {
                if (p.getLeft() == null) {
                    p.setLeft(new Node<K, V>(key, value, p));
                    p = null;
                } else {
                    p = p.getLeft();
                }

            } else if (key.compareTo(p.getKey()) > 0) {
                if (p.getRight() == null) {
                    p.setRight(new Node<K, V>(key, value, p));
                    p = null;
                } else {
                    p = p.getRight();
                }
            } else {
                p.setValue(value);
                p = null;
            }
        }
    }

//
//        if (key.compareTo(parent.getKey()) < 0) {
//            if (parent.getLeft() != null) {
//                addNode(key, value, parent.getLeft());
//            } else {
//                parent.setLeft(new TreeNode<K, V>(key, value, parent));
//            }
//        } else {
//            if (parent.getRight() != null) {
//                addNode(key, value, parent.getRight());
//            } else {
//                parent.setRight(new TreeNode<K, V>(key, value, parent));
//            }
//        }
//    }

    private void deleteEntity(Node<K, V> item) {
        size--;

        Node<K, V> parent = item.getParent();
        Node<K, V> left = item.getLeft();
        Node<K, V> right = item.getRight();
        if (parent == null) {
            if (right != null) {
                Node<K, V> firstEntry = getFirstEntry(right);
                firstEntry.setLeft(left);
                if (left != null) {
                    left.setParent(firstEntry);
                }
                right.setParent(null);
                root = right;
            } else if (left != null) {
                left.setParent(null);
                root = left;
            } else {
                root = null;
            }
        } else if (left != null && right != null) {
            Node<K, V> firstEntry = getFirstEntry(right);
            firstEntry.setLeft(left);
            left.setParent(firstEntry);
            if (parent.getLeft() == item) {
                parent.setLeft(right);
            } else {
                parent.setRight(right);
            }
            right.setParent(parent);
        } else if (left != null) {
            left.setParent(parent);
            if (parent.getLeft() == item) {
                parent.setLeft(left);
            } else {
                parent.setRight(left);
            }

        } else if (right != null) {
            right.setParent(parent);
            if (parent.getLeft() == item) {
                parent.setLeft(right);
            } else {
                parent.setRight(right);
            }
        } else {
            if (parent.getLeft() == item) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }
        item.setLeft(null);
        item.setParent(null);
        item.setRight(null);
    }

    private Node<K, V> getNextValue(Node<K, V> item) {
        if(item.getRight() != null){
            Node<K, V> next;
            next = item.getRight();
            while (next.getLeft() != null){
                next = next.getLeft();
            }
            return next;
        } else {
            Node<K, V> p = item.getParent();
            Node<K, V> ch = item;
            while (p != null && ch == p.getRight()) {
                ch = p;
                p = p.getParent();
            }
            return p;
        }
    }

    private Node<K, V> getFirstEntry() {
        return getFirstEntry(root);
    }

    private Node<K, V> getFirstEntry(Node<K, V> res) {
        while (res!= null &&
                res.getLeft() != null) {
            res = res.getLeft();
        }
        return res;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root != null;
    }

    @Override
    public boolean containsKey(Object key) {
        return keySet().contains(key);
    }


    @Override
    public V put(K key, V value) {
        add(key, value);
        return value;
    }

    @Override
    public V remove(Object key) {
        Node<K, V> item = getEntity(key);
        V res = null;
        if(item != null){
            res = item.getValue();
            deleteEntity(item);
        }

        return res;
    }

    private Node<K, V> getEntity(Object key) {
        Node<K, V> p = root;
        K k = (K) key;
        while (p != null){
            int cmp = k.compareTo(p.getKey());
            if(cmp < 0){
                p = p.getLeft();
            } else if(cmp > 0) {
                p = p.getRight();
            } else {
                return p;
            }
        }
        return p;
    }

    @Override
    public V get(Object key) {
        Node<K, V> entity = getEntity(key);
        return entity != null ? entity.getValue() : null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        Set<? extends K> ks = m.keySet();
        for (K k : ks) {
            this.put(k, m.get(k));
        }
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        return new KeySet<K>(this);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new EntrySet();
    }

    private final class KeySet<T extends K> extends AbstractSet<T> {
        BinaryTree<K, V> m;

        public KeySet(BinaryTree<K, V> m) {
            this.m = m;
        }

        @Override
        public Iterator<T> iterator() {
            return new KeySetIterator<T>(m.getFirstEntry());
        }

        @Override
        public void forEach(Consumer action) {
            Iterator<T> eIterator = iterator();
            while (eIterator.hasNext()){
                action.accept(eIterator.next());
            }
        }

        @Override
        public boolean removeIf(Predicate filter) {
            boolean modified = false;
            Iterator<T> eIterator = iterator();
            while (eIterator.hasNext()){
                if(filter.test(eIterator.next())){
                    eIterator.remove();
                    modified |= true;
                }

            }
            return modified;
        }

        @Override
        public Stream stream() {
            return StreamSupport.stream(spliterator(), false);
        }

        @Override
        public Stream parallelStream() {
            return stream();
        }

        @Override
        public int size() {
            return m.size();
        }
    }

    private final class KeySetIterator<T extends K> implements Iterator {

        private Node<K, V> next;

        public KeySetIterator(Node<K, V> firstEntry) {
            next = firstEntry;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public K next() {
            Node<K, V> item = next;
            if (item == null)
                throw new NoSuchElementException();
            next = getNextValue(item);
            return item.getKey();
        }
    }

    private final class EntrySetIterator implements Iterator<Map.Entry<K, V>> {
        private Node<K, V> next;
        private Node<K, V> lastReturnedValue;

        public EntrySetIterator(Node<K, V> firstEntry) {
            next = firstEntry;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Node<K, V> next() {
            Node<K, V> item = next;
            if (item == null)
                throw new NoSuchElementException();
            next = getNextValue(item);
            lastReturnedValue = item;
            return item;
        }

        @Override
        public void remove() {
            deleteEntity(lastReturnedValue);
        }
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntrySetIterator(getFirstEntry());
        }

        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Node<?,?> entry = (Node<?,?>) o;
            Object value = entry.getValue();
            Node<K,V> p = getEntity(entry.getKey());
            return p != null && valEquals(p.getValue(), value);
        }

        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?,?> entry = (Map.Entry<?,?>) o;
            Object value = entry.getValue();
            Node<K,V> p = getEntity(entry.getKey());
            if (p != null && valEquals(p.getValue(), value)) {
                deleteEntity(p);
                return true;
            }
            return false;
        }

        public int size() {
            return BinaryTree.this.size();
        }

        public void clear() {
            root = null;
        }

        public Spliterator<Map.Entry<K, V>> spliterator() {
            return spliterator();
        }
    }

    static final boolean valEquals(Object o1, Object o2) {
        return (o1==null ? o2==null : o1.equals(o2));
    }
}
