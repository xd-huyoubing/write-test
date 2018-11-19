package edu.xidian.linkedlist;

/**
 * @auther huyoubing
 * @date 2018/11/6 15:23
 */
public class Main {

    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5};
        /*ListNode head = createList(arr);
        printList(head);
        LeetCode_206 leetCode_206 = new LeetCode_206();

        ListNode listNode = leetCode_206.reverseList1(head);
        printList(listNode);*/

        System.out.println(9/10);
    }

    private static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curNode = head;
        for (int i = 1; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        return head;
    }

    private static void printList(ListNode head) {
        ListNode curNode = head;
        while (curNode != null) {
            System.out.print(curNode.val + " -> ");
            curNode = curNode.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
