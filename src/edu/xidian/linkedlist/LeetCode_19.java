package edu.xidian.linkedlist;

/**
 * 思路：设置两个指针，先将一个指针移动n步，两个指针一起移动，这样先移动n步的指针结束的时候，
 * 另一个指针指向要删除节点的前一个节点,直接删除即可
 */
public class LeetCode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode p1 = dummyNode, p2 = dummyNode;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        p1.next = p1.next.next;
        return dummyNode.next;
    }
}
