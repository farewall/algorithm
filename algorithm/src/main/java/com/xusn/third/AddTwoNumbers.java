package com.xusn.third;

/**
 * �������
 * �������� �ǿ� ��������ʾ�����Ǹ�������������ÿλ���ֶ��ǰ��� ���� �ķ�ʽ�洢�ģ�����ÿ���ڵ�ֻ�ܴ洢 һλ ���֡�
 *
 * ���㽫��������ӣ�������ͬ��ʽ����һ����ʾ�͵�����
 *
 * ����Լ���������� 0 ֮�⣬���������������� 0 ��ͷ��
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
