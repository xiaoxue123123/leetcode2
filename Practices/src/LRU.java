import java.util.HashMap;
import java.util.Map;

public class LRU<K, V> {
    // limit is the max capacity of the cache
    /**

     **/


    static class Node<K,V> {
        K key;
        V value;
        Node<K,V> next;
        Node<K,V> prev;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int limit;
    private Node<K,V> head;
    private Node<K,V> tail;
    private Map<K,Node<K,V>> map;

    public LRU(int limit) {
        this.limit = limit;
        this.map = new HashMap<>();
    }

    public void set(K key, V value) {
        // if exist, remove and append to tail
        Node<K,V> node = map.get(key);
        if (map.size() == limit) {
            Node<K,V> oldTail = tail;
            tail = tail.prev;
            remove(oldTail);
        }
        if (node != null) {

            remove(node);
            node.value = value;
            append(node);
        } else {
            // if not exist, append to tail
            node = new Node(key, value);
            append(node);
        }

    }

    public V get(K key) {
        // if not exist, return null
        Node<K,V> node = map.get(key);
        // if exist, get its value
        if (node != null) {
            // remove
            remove(node);
            // and append it to tail
            append(node);
            return node.value;
        }
        return null;
    }


    private Node<K,V> remove(Node<K,V> node) {
        // if not exist, return null
        // if exist, remove from list node and remove from hashtable


        map.remove(node.key);
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail = tail.prev;
        }
        node.prev = null;
        node.next = null;

        return node;

    }
    private Node<K,V>  append(Node<K,V> node) {
        //在这里不考虑size, 在put的时候考虑, head和tail不互指。head.prev = null; tail.next = null;
        map.put(node.key, node);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        return node;


    }

    public static void main(String[] args) {
        LRU sol = new LRU(2);

        System.out.println(sol.get(1));
        sol.set(1,1);
        sol.set(2,2);
        System.out.println(sol.get(2));
        System.out.println(sol.get(1));
        sol.set(3,3);
        System.out.println(sol.get(1));
        System.out.println(sol.get(2));
        System.out.println(sol.get(3));
    }


}
