package edu.xidian.linkedlist;


import java.util.Stack;


public class LeetCode_206 {
    /**
     * 使用栈实现链表的反转
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode currNode = head;
        while (currNode != null) {
            stack.push(currNode);
            currNode = currNode.next;
        }
        ListNode listNode = stack.pop();
       currNode = listNode;
        while (!stack.isEmpty()) {
            currNode.next = stack.pop();
            currNode = currNode.next;
        }
        currNode.next = null;
        return listNode;
    }


    /**
     * 递归实现单链表的翻转
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode curNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return curNode;
    }

    /**
     * 非递归 不使用栈实现链表的反转
     *
     * @param head
     * @return
     */
    public ListNode reverseListNR(ListNode head) {
        if (head == null)
            return head;
        ListNode p1 = head, p2 = head.next, s = head;
        while (p2 != null) {
            p1 = p2;
            p2 = p2.next;
            p1.next = head;
            head = p1;
        }
        s.next = null;
        return p1;
    }

    /**
     * 非递归 不使用栈实现链表的反转
     */
    public ListNode reverseListNR1(ListNode head) {
        if (head == null)
            return head;
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode  next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
