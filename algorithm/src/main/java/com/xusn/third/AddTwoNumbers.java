package com.xusn.third;

/**
 * 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class AddTwoNumbers {
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          int carry = 0;
          ListNode dummy = new ListNode(-1);
          ListNode curr = dummy;
          while (l1 != null || l2 != null || carry != 0) {
              int l1Value = l1 == null ? 0 : l1.val;
              int l2Value = l2 == null ? 0 : l2.val;
              int value = (l1Value + l2Value + carry) % 10;
              carry = (l1Value + l2Value + carry) / 10;
              curr.next = new ListNode(value);
              curr = curr.next;
              if (l1 != null) {
                  l1 = l1.next;
              }
              if (l2 != null) {
                  l2 = l2.next;
              }
          }
          return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        addTwoNumbers(l1, l2);
    }
}
