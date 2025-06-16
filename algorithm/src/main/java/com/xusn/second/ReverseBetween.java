package com.xusn.second;

import com.xusn.first.ReverseList;

/**
 * ��ת����2
 * ���㵥�����ͷָ�� head ���������� left �� right ������ left <= right �����㷴ת��λ�� left ��λ�� right ������ڵ㣬���� ��ת������� ��
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
        // prevָ��ʼ��ת�ڵ��ǰһ���ڵ�
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
        // prevָ��ʼ��ת�ڵ��ǰһ���ڵ�
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        // �洢����ĵ�һ���ڵ�
        ListNode start = prev.next;

        // �洢��������һ���ڵ�
        ListNode end = prev;
        for (int i = 0; i < right - left + 1; i++) {
            end = end.next;
        }
        // �洢������Ҫ���ϵĽڵ�
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
