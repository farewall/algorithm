package com.xusn.popular;

import java.util.List;

/**
 * 合并两个有序链表
 */
public class MergeTwoLists {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode(-1);
        ListNode curr = listNode;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;
                continue;
            }
            if (list2 == null) {
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
                continue;
            }

            if (list1.val < list2.val) {
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            } else {
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;
            }
        }
        return listNode.next;
    }
}
