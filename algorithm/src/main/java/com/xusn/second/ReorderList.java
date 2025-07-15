package com.xusn.second;

/**
 * 重排链表
 *
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ReorderList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 分为三步：1.找到链表中点 2.将后半部分链表反转 3.按照顺序合并链表

        //1.找到链表中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 链表长度为单数时，slow指向中间；链表长度为双数时，slow指向第二段的头节点

        // 2.将后半部分链表反转
        ListNode pre = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        // prev指向链表末端


        // 3.按照顺序合并链表
        ListNode first = head;
        ListNode second = pre;
        while (second.next != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode curr = head;

        head.next = new ListNode(2);
        curr = head.next;

        curr.next = new ListNode(3);
        curr = curr.next;

        curr.next = new ListNode(4);
        curr = curr.next;

        curr.next = new ListNode(5);
        curr = curr.next;

        curr.next = new ListNode(6);

        reorderList(head);

    }
}
