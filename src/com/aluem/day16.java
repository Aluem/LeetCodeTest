package com.aluem;

public class day16 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode right = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);

        head.next = right;
        right.next = node3;
        node3.next = node4;
        node4.next = node5;

        day16 day16 = new day16();
        day16.deleteDuplicates(head);

        day14 day14 = new day14();
        day14.print(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        ListNode temp = node;

        while (node.next != null) {
            while (temp != null && temp.val == node.val) {
                temp = temp.next;
            }
            node.next = temp;
            if (temp != null)
                node = temp;
        }

        return head;
    }
}
