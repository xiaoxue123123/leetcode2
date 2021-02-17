import java.util.List;

public class ReverseListInPairs {
    public ListNode reverseInPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next.next;
            cur.next.next = cur.next.next.next;
            next.next = cur.next;
            cur.next = next;
            cur = cur.next.next;

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        ListNode head = n;
        n.next = new ListNode(2);
        n = n.next;
        n.next = new ListNode(3);
        n = n.next;
        n.next = new ListNode(4);
        n = n.next;
        n.next = new ListNode(5);
        n = n.next;
        n.next = new ListNode(6);
        n = n.next;
        n.next = new ListNode(7);
        n = n.next;
        n.next = null;
        ReverseListInPairs solution = new ReverseListInPairs();
        ListNode newN = solution.reverseInPairs(head);
    }

}
