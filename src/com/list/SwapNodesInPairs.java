package com.list;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode left = new ListNode(1);
        ListNode right = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        left.next = right;
        right.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode.print(left);
        ListNode newHead = swapPairs(left);
        System.out.println();
        ListNode.print(newHead);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNewHead = swapPairs(head.next.next);
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = nextNewHead;
        return newHead;
    }
}





