package edu.xidian.linkedlist;

/**
 * 思路：首先找到需要反转的链表区间的前一个节点，即[m-1,n-1]这个区间，然后将这个区间的子区间[m,n]区间反转，并返回
 * 反转之后区间的头节点和尾节点，让m-1这个节点的next指向反转区间的头节点，让反转区间的尾节点指向n节点的next节点即完成
 */
public class LeetCode_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n)
            return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead, q = dummyHead;
        //经过这次循环找到了需要逆转的区间的前一个节点[m-1,n-1]
        for (int i = 1; i < n; i++) {
            if (i < m)
                p = p.next;
            q = q.next;
        }
        ListNode l = q.next.next;
        ListNode[] retList = reverseLinkedList(p.next, q.next);
        p.next = retList[0];
        retList[1].next = l;
        return dummyHead.next;
    }

    //反转区间[m,n]的链表，并返回反转后这个区间链表的头和尾
    private ListNode[] reverseLinkedList(ListNode p, ListNode q) {
        ListNode cur = p.next;
        ListNode save = p;
        while (cur != q) {
            ListNode next = cur.next;
            cur.next = p;
            p = cur;
            cur = next;
        }
        cur.next = p;
        return new ListNode[]{cur, save};
    }
}
