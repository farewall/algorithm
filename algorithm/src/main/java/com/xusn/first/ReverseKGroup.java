package com.xusn.first;

public class ReverseKGroup {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 记录翻转起始节点的前一个节点
        ListNode prev = dummy;
        // 记录每组翻转的最后一个节点
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            // 开始节点是prev.next
            ListNode start = prev.next;
            // 下一组是end.next
            ListNode nextGroup = end.next;
            // 断开与下个组的连接
            end.next = null;

            // prev指向翻转后的链表的头节点
            prev.next = reverse(start);

            // start节点指向下一组
            start.next = nextGroup;

            // prev指向下一组之前的节点
            prev = start;
            // end和prev同步
            end = prev;

        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
