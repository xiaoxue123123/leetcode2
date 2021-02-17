class MyLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        private ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new ListNode(0); // sentinel node
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        // sanity check
        // 0 based, index [0, size - 1]
        if (index < 0 || index > size) {
            return -1;
        }

        ListNode cur = this.head;
        int cnt = 0;
        // iterate to index + 1 because start from sentinel node
        // which is one node before index 0
        while (cnt < index + 1 && cur != null) {
            cur = cur.next;
            cnt++;
        }

        if (cur != null) {
            return cur.val;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode cur = this.head;
        ListNode add = new ListNode(val);
        add.next = cur.next;
        cur.next = add;
        size++;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode add = new ListNode(val);
        // since there will always be a dummy node, no need to check if head is null
        ListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = add;
        size++;

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        // sanity check
        if (index < 0) {
            return;
        }

        // -1 -> 1 ->2 ->3
        //  d
        //  dh
        // cnt   0.  1.
        // dummy head
        ListNode prev = this.head;
        ListNode cur = this.head.next;

        int cnt = 0;
        while (cnt < index && cur != null) {
            prev = cur;
            cur = cur.next;
            cnt++ ;
        }
        if (cur == null) {
            return;
        } else {
            prev.next = new ListNode(val);
            prev.next.next = cur;
            size++;
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        // sanity check. dummy node will never be deleted because index can't be smaller than 0.
        if (index < 0) {
            return;
        }

        // -1 -> 1 ->2 ->3
        //  d
        //  dh
        // cnt   0.  1.
        // dummy head
        ListNode prev = this.head;
        ListNode cur = this.head.next;

        int cnt = 0;
        while (cnt < index && cur != null) {
            prev = cur;
            cur = cur.next;
            cnt++ ;
        }
        if (cur == null) {
            return;
        } else {
            prev.next = prev.next.next;
            size--;
        }
    }

    public static void main(String[] args) {

        // Your MyLinkedList object will be instantiated and called as such:
        MyLinkedList obj = new MyLinkedList();
        int param_1 = obj.get(0);
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1,2);
        obj.get(1);
        obj.deleteAtIndex(1);

    }




}



