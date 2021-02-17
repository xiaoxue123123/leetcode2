public class MergeSortLinkedList {
    public ListNode mergeSort(ListNode n) {
        // base case
        if (n == null ) {
            return null;
        }
        if (n.next == null) {
            return new ListNode(n.value);
        }

        ListNode mid = findMid(n);
        ListNode left = n;
        ListNode right = mid.next;
// delink left from right
        mid.next = null;
// recursion
        ListNode leftResult = mergeSort(left);
        ListNode rightResult = mergeSort(right);
// merge
        return merge(leftResult, rightResult);

    }
    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next!= null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //   81       2
    //              r
    // -1->2 -> 81
    //     c

    private ListNode merge(ListNode left, ListNode right) {
        // sanity check
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        // merge
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.value <= right.value) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
// post processing
        if (left != null) {
            cur.next = left;
        } else {
            cur.next = right;
        }

        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode n = new ListNode(81);
        ListNode head = n;
        n.next = new ListNode(2);
        n = n.next;
        n.next = new ListNode(3);
        n = n.next;
        n.next = new ListNode(1);
        n = n.next;
        n.next = new ListNode(2);
        MergeSortLinkedList solution = new MergeSortLinkedList();
        ListNode ret = solution.mergeSort(head);


    }
}
