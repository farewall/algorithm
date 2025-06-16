package com.xusn.second;

import com.xusn.first.ReverseList;

/**
 * 反转链表2
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class ReverseBetween {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween1(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        // prev指向开始翻转节点的前一个节点
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        // prev指向开始翻转节点的前一个节点
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        // 存储区间的第一个节点
        ListNode start = prev.next;

        // 存储区间的最后一个节点
        ListNode end = prev;
        for (int i = 0; i < right - left + 1; i++) {
            end = end.next;
        }
        // 存储后面需要接上的节点
        ListNode next = end.next;

        end.next = null;
        prev.next = reverseAll(start);
        start.next = next;
        return dummy.next;
    }

    public ListNode reverseAll(ListNode head) {
        ListNode prev  = null;
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
