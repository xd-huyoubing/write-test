package edu.xidian.linkedlist;

public class LeetCode_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode next = null;
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            next = cur.next;
            head.next = cur;
            cur.next = pre;
            pre.next = next;
            head = pre;


        }
        return dummyHead.next;
    }
}
