import java.util.HashMap;
import java.util.Map;

public class NonRepeating {

    Node head;
    Node tail;
    Map<Character, Node> map;
    static class Node {
        char key;
        char value;
        Node next;
        Node prev;
        Node(char ch) {
            this.key = ch;
            this.value = ch;
        }
    }

    public NonRepeating() {
        // Initialize the class.
        map = new HashMap<>();
    }

    public void read(char ch) {
        // Implement this method here.
        if (map.size() == 0) {
            Node node = new Node(ch);
            head = tail = node;
            map.put(ch,node);
        } else if (!map.containsKey(ch)) {
            Node node = new Node(ch);
            map.put(ch, node);
            node.prev = tail;
            tail.next = node;
            tail = node;
        } else {
            Node node = map.get(ch);
            if (node == null) {
                return;
            }
            map.put(ch, null);
            remove(node);
        }
    }

    private void remove(Node node) {
        if (node == null) {
            return;
        }
        if (node == tail) {
            tail = node.prev;
        }
        if (node == head) {
            head = node.next;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.next = null;
        node.prev = null;

    }

    public Character firstNonRepeating() {
        // Implement this method here.
        if (head == null) {
            return null;
        }
        return head.key;
    }

    public static void main(String[] args) {
        NonRepeating s = new NonRepeating();
        s.read('a');
        System.out.println(s.firstNonRepeating());
        s.read('b');
        System.out.println(s.firstNonRepeating());
        s.read('c');
        System.out.println(s.firstNonRepeating());
        s.read('b');
        System.out.println(s.firstNonRepeating());
        s.read('a');
        System.out.println(s.firstNonRepeating());
        s.read('d');
        System.out.println(s.firstNonRepeating());
        s.read('c');
        System.out.println(s.firstNonRepeating());
        s.read('d');
        System.out.println(s.firstNonRepeating());
        s.read('a');
        System.out.println(s.firstNonRepeating());

        s.read('e');
        System.out.println(s.firstNonRepeating());


    }
}
