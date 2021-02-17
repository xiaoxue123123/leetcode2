import java.util.List;

public class ReOrderLinkedList {



    public ListNode reorder(ListNode head) {
        // Write your solution here
        // sanity check
        if (head == null || head.next == null) {
            return head;
        }

        // 1. find mid
        ListNode mid = findMid(head);
        ListNode one = head;
        ListNode two = mid.next;
        // delink the second half from the list
        mid.next = null;
        // 2. reverse second half of the linked list
        ListNode reversedTwo = reverse(two);
        // 3. merge the two halves
        return merge(one, reversedTwo);

    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode mid) {
        // base
        if (mid == null || mid.next == null) {
            return mid;
        }
        ListNode newHead = reverse(mid.next);
        mid.next.next = mid;
        mid.next = null;
        return newHead;
    }

    private ListNode merge(ListNode head, ListNode newSecondHalf) {

        // merge first half and reversed second half
        // create a dummy head
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head != null && newSecondHalf != null) {
            cur.next = head;
            head = head.next;
            cur = cur.next;
            cur.next = newSecondHalf;
            newSecondHalf = newSecondHalf.next;
            cur = cur.next;
        }
        if (head != null) {
            cur.next = head;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
         ListNode n = new ListNode(0);
         n.next = new ListNode(1);
         n.next.next = new ListNode(2);
         //n.next.next.next = new ListNode(3);
         ReOrderLinkedList solution = new ReOrderLinkedList();
         solution.reorder(n);

    }
}
