package com.xusn.second;

import java.util.HashSet;
import java.util.Set;

/**
 * �ཻ����
 *
 * ���������������ͷ�ڵ� headA �� headB �������ҳ������������������ཻ����ʼ�ڵ㡣����������������ཻ�ڵ㣬���� null ��
 *
 * ͼʾ���������ڽڵ� c1 ��ʼ�ཻ��
 */
public class IntersectionNode {
    public class ListNode {
        int val;
         ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
