package com.list;

public class OddEvenLinkedList2 {
    public static void main(String[] args) {
        ListNode left = new ListNode(1);
        ListNode right = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        left.next = right;
        right.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode.print(left);
        OddEvenLinkedList2 test = new OddEvenLinkedList2();
        ListNode listNode = test.oddEvenList(left);
        System.out.println();
        ListNode.print(listNode);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = head, evenHead = head.next;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next; // 1 -> 3
            odd = odd.next; // odd -> 3
            even.next = odd.next;// 2 -> 4
            even = even.next; // even -> 4
        }
        odd.next = evenHead;
        return head;
    }

}
