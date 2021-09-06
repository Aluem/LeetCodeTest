package com.list.review;

import com.list.ListNode;

//相交链表
public class IntersectList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while (tmpA != null || tmpB != null) {
            if (tmpA == tmpB) {
                return tmpA;
            }
            if (tmpA == null) {
                tmpA = headB;
                tmpB = tmpB.next;
            } else if (tmpB == null) {
                tmpB = headA;
                tmpA = tmpA.next;
            } else {
                tmpA = tmpA.next;
                tmpB = tmpB.next;
            }

        }
        return null;
    }
}
