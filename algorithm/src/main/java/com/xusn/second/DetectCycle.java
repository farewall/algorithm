package com.xusn.second;

/**
 * ª∑–Œ¡¥±Ì II
 *
 */
public class DetectCycle {
      class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode detectCycle(ListNode head) {
          ListNode slow = head;
          ListNode fast = head;

          while (true) {
              if (fast == null || fast.next == null) {
                  return null;
              }
              slow = slow.next;
              fast = fast.next.next;
              if (slow == fast) {
                  break;
              }
          }

          ListNode curr = head;
          while (curr != slow) {
              curr = curr.next;
              slow = slow.next;
          }
          return curr;
    }
}
