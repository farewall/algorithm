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
        // ��¼��ת��ʼ�ڵ��ǰһ���ڵ�
        ListNode prev = dummy;
        // ��¼ÿ�鷭ת�����һ���ڵ�
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            // ��ʼ�ڵ���prev.next
            ListNode start = prev.next;
            // ��һ����end.next
            ListNode nextGroup = end.next;
            // �Ͽ����¸��������
            end.next = null;

            // prevָ��ת��������ͷ�ڵ�
            prev.next = reverse(start);

            // start�ڵ�ָ����һ��
            start.next = nextGroup;

            // prevָ����һ��֮ǰ�Ľڵ�
            prev = start;
            // end��prevͬ��
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
