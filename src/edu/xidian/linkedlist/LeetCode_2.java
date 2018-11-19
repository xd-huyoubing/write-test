package edu.xidian.linkedlist;

public class LeetCode_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode head = l;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = sum > 9 ? 1 : 0;
            l.next = new ListNode(sum % 10);
            l = l.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry == 1) {
            l.next = new ListNode(1);
        }
        return head.next;
    }
}
