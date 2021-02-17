//class MyLinkedListWrong {
//    private int val;
//    private   MyLinkedListWrong next;
//    /** Initialize your data structure here. */
//    public MyLinkedListWrong(int val) {
//        this.val = val;
//    }
//    public MyLinkedListWrong() {
//
//    }
//
//    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
//    public int get(int index) {
//        // sanity check
//        if (index < 0 || this == null) {
//            return -1;
//        }
//
//        MyLinkedListWrong cur = this;
//        int cnt = 0;
//        while (cnt < index && cur != null) {
//            cur = cur.next;
//            cnt++;
//        }
//        if (cur != null) {
//            return cur.val;
//        }
//        return -1;
//    }
//
//    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
//    public void addAtHead(int val) {
//        MyLinkedListWrong cur = this;
//        MyLinkedListWrong add = new MyLinkedListWrong(val);
//        add.next = cur;
//        this = add;
//
//    }
//
//    /** Append a node of value val to the last element of the linked list. */
//    public void addAtTail(int val) {
//        MyLinkedListWrong add = new MyLinkedListWrong(val);
//        // sanity check
//        if (this == null) {
//            return;
//        }
//
//        MyLinkedListWrong head = this;
//        while (this.next != null) {
//            this = this.next;
//        }
//        this.next = add;
//
//    }
//
//    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
//    public void addAtIndex(int index, int val) {
//        // sanity check
//        if (index < 0 || this == null) {
//            return;
//        }
//
//        // -1 -> 1 ->2 ->3
//        //  d
//        //  dh
//        // cnt   0.  1.
//        // dummy head
//        MyLinkedListWrong dummy = new MyLinkedListWrong(-1);
//        dummy.next = this;
//        MyLinkeList prev = dummy;
//        MyLinkedListWrong cur = this;
//
//        int cnt = 0;
//        while (cnt < index && cur != null) {
//            prev = cur;
//            cur = cur.next;
//            cnt++ ;
//        }
//        if (cur == null) {
//            return;
//        } else {
//            prev.next = new MyLinkedListWrong(val);
//            prev.next.next = cur;
//        }
//        this = dummy.next;
//
//    }
//
//    /** Delete the index-th node in the linked list, if the index is valid. */
//    public void deleteAtIndex(int index) {
//        // sanity check
//        if (index < 0 || this == null) {
//            return;
//        }
//
//        MyLinkedListWrong dummy = new MyLinkedListWrong(-1);
//        dummy.next = this;
//        MyLinkeList prev = dummy;
//        MyLinkedListWrong cur = this;
//
//        int cnt = 0;
//        while (cnt < index && cur != null) {
//            prev = cur;
//            cur = cur.next;
//            cnt++ ;
//        }
//        if (cur == null) {
//            return;
//        } else {
//            prev.next = prev.next.next;
//        }
//
//    }
//}
//
///**
// * Your MyLinkedListWrong object will be instantiated and called as such:
// * MyLinkedListWrong obj = new MyLinkedListWrong();
// * int param_1 = obj.get(index);
// * obj.addAtHead(val);
// * obj.addAtTail(val);
// * obj.addAtIndex(index,val);
// * obj.deleteAtIndex(index);
// */