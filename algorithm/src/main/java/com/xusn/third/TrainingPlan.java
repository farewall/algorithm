package com.xusn.third;

public class TrainingPlan {
     public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode trainingPlan(ListNode head, int cnt) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 1; i < cnt; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2, new ListNode(4, new ListNode(7, new ListNode(8))));
        trainingPlan(listNode, 1);
    }
}
