public class RemoveElementII {
    public ListNode removeElementII(ListNode head, int val) {
        ListNode prev = null;
        ListNode newHead = null;
        while (head != null) {
            if (head.value == val) {
                if (prev != null) {
                    prev.next = head.next;
                }
            } else {
                if (newHead == null) {
                    newHead = head;
                }
                prev = head;
            }
            head = head.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(0);
        h.next = new ListNode(1);
        RemoveElementII solution = new RemoveElementII();
       solution.removeElementII(h,0);
    }

}
