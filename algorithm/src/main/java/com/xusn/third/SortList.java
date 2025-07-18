package com.xusn.third;

/**
 * 排序链表
 */
public class SortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        // 归并排序（分而治之）
        if (head == null || head.next == null) {
            return head;
        }
        // 1.找到分割点，一般来说都是中点，使用快慢指针
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 断开链表的中点
        prev.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        // 合并两个有序链表
        return merge(left, right);
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                curr.next = node1;
                node1 = node1.next;
            } else {
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }

        if (node1 != null) {
            curr.next = node1;
        }
        if (node2 != null) {
            curr.next = node2;
        }
        return dummy.next;
    }
}
