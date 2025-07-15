package com.xusn.second;

/**
 * 合并K个排序链表
 */
public class MergeKLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
  }

  public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;
        ListNode node1 = merge(lists, left, mid);
        ListNode node2 = merge(lists, mid + 1, right);
        return mergeTwoLists(node1, node2);
  }

  public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                current.next = node1;
                node1 = node1.next;
            } else {
                current.next = node2;
                node2 = node2.next;
            }
            current = current.next;
        }

        if (node1 == null) {
            current.next = node2;
        } else {
            current.next = node1;
        }
        return dummy.next;
  }
}
