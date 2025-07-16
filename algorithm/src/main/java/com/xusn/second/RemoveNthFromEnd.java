package com.xusn.second;

/**
 * ɾ����������N���ڵ�
 * ����һ������ɾ������ĵ����� n ����㣬���ҷ��������ͷ��㡣
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
        // ʹ�ÿ���ָ�룬��ָ������N�����ߵ�����ʱ����ָ������ָ���ɾ���ڵ��ǰһ���ڵ�
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
