package com.list;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void print(ListNode head) {
        ListNode temp = head;
        if (temp == null) {
            System.out.println("单链表为空");
            return;
        }
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}