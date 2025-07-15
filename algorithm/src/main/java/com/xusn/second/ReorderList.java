package com.xusn.second;

/**
 * ��������
 *
 * ����һ�������� L ��ͷ�ڵ� head �������� L ��ʾΪ��
 *
 * L0 �� L1 �� �� �� Ln - 1 �� Ln
 * �뽫���������к��Ϊ��
 *
 * L0 �� Ln �� L1 �� Ln - 1 �� L2 �� Ln - 2 �� ��
 * ����ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
 */
public class ReorderList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // ��Ϊ������1.�ҵ������е� 2.����벿������ת 3.����˳��ϲ�����

        //1.�ҵ������е�
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // ������Ϊ����ʱ��slowָ���м䣻������Ϊ˫��ʱ��slowָ��ڶ��ε�ͷ�ڵ�

        // 2.����벿������ת
        ListNode pre = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        // prevָ������ĩ��


        // 3.����˳��ϲ�����
        ListNode first = head;
        ListNode second = pre;
        while (second.next != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode curr = head;

        head.next = new ListNode(2);
        curr = head.next;

        curr.next = new ListNode(3);
        curr = curr.next;

        curr.next = new ListNode(4);
        curr = curr.next;

        curr.next = new ListNode(5);
        curr = curr.next;

        curr.next = new ListNode(6);

        reorderList(head);

    }
}
