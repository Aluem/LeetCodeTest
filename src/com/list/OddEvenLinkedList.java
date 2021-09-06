package com.list;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode left = new ListNode(1);
        ListNode right = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        left.next = right;
//        right.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        ListNode.print(left);
        OddEvenLinkedList test = new OddEvenLinkedList();
        ListNode listNode = test.oddEvenList(left);
        System.out.println();
        ListNode.print(listNode);
    }
    //时间复杂度 O(3n)  空间复杂度O(1)
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tmp = head;
        ListNode pre = null;
        int index = 1;
        ListNode tail = getListLastNode(head);
        int length = getLength(head);
        for (int i = 0; i < length; i++) {
            if (index % 2 == 0) {
                if (tmp.next != null) {
                    pre.next = tmp.next; // 1 指向 3
                    tail.next = tmp; // 尾节点指向当前的偶数结点
                    tail = tail.next; // 更新尾节点
                }
            }
            pre = tmp;
            index++;
            tmp = tmp.next;
        }
        tail.next = null;
        return head;
    }

    private ListNode getListLastNode(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.next == null) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return head;
    }

    private int getLength(ListNode head) {
        ListNode tmp = head;
        int length = 0;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }
}
