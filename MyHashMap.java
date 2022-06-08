import java.util.Arrays;
import java.util.Map;

public class MyHashMap<K,V>  {
    public static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private Entry<K, V>[] array;
    private int size;

    public MyHashMap() {
        this.array = new Entry[16];
        this.size = 0;
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        return key.hashCode() & 0x7FFFFFFF;
    }

    private boolean equalsKey(K k1, K k2) {
        return k1 == k2 || k1 != null && k1.equals(k2);
    }

    public V get(K key) {
        int index = hash(key) % array.length;
        Entry<K, V> node = array[index];
        while (node != null) {
            if (equalsKey(node.getKey(), key)) {
                return node.getValue();
            }
            node = node.next;
        }
        return null;
    }

    public V put(K key, V value) {
        int index = hash(key) % array.length;
        Entry<K, V> head = array[index];
        Entry<K, V> node = head;
        while (node != null) {
            if (equalsKey(node.getKey(), key)) {
                V result = node.getValue();
                node.setValue(value);
                return result;
            }
            node = node.next;
        }
        Entry<K, V> newEntry = new Entry(key, value);
        newEntry.next = head;
        array[index] = newEntry;
        size++;
        return null;
    }

    public V remove(K key) {
        int index = hash(key) % array.length;
        Entry<K, V> head = array[index];
        if (equalsKey(head.getKey(), key)) {
            V result = head.getValue();
            array[index] = head.next;
            size--;
            return result;
        }
        Entry<K, V> node = head;
        while (node.next != null) {
            if (equalsKey(node.next.getKey(), key)) {
                V result = node.next.getValue();
                node.next = node.next.next;
                size--;
                return result;
            }
            node = node.next;
        }
        return null;
    }

    public void clear() {
        Arrays.fill(this.array, null);
        size = 0;
    }

    public int size() {
        return size;
    }
}
