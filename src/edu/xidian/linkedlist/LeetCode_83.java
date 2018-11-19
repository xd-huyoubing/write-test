package edu.xidian.linkedlist;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 思路：如果当前节点的下一个节点不为null,则比较当前节点和当前节点的next节点的值，若不想等则不需要删除，当前节点后移即可
 * 若想等，则将当前节点的下一个节点删除，节点不向下一个节点移动，因为还可能相等，
 */
public class LeetCode_83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head;
        while (curNode.next != null) {
            if (curNode.val != curNode.next.val)
                curNode = curNode.next;
            else
                curNode.next = curNode.next.next;
        }
        return head;
    }
}
