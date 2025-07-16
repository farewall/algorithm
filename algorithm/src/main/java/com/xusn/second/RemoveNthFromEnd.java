package com.xusn.second;

/**
 * 删除链表倒数第N个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
     public ListNode removeNthFromEnd(ListNode head, int n) {
        // 使用快慢指针，快指针先走N步，走到最后的时候，慢指针正好指向待删除节点的前一个节点
         ListNode dummy = new ListNode(0);
         dummy.next = head;

         ListNode slow = dummy;
         ListNode fast = dummy;

         for (int i = 0; i < n; i++) {
            fast = fast.next;
         }
         while (fast.next != null) {
             slow = slow.next;
             fast = fast.next;
         }
         slow.next = slow.next.next;
         return dummy.next;
     }
}
