package edu.xidian.linkedlist;

/**
 * 合并两个有序链表
 * <p>
 * 思路：两个指针移动即可
 */
public class LeetCode_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode l = new ListNode(0);
        ListNode head = l;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l.next = new ListNode(l1.val);
                l1 = l1.next;
                l = l.next;
            } else {
                l.next = new ListNode(l2.val);
                l2 = l2.next;
                l = l.next;
            }
        }
        while (l1 != null) {
            l.next = new ListNode(l1.val);
            l = l.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            l.next = new ListNode(l2.val);
            l = l.next;
            l2 = l2.next;
        }
        return head.next;
    }
}
