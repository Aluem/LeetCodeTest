package com.list;

import java.util.LinkedList;

public class AddTwoNumbersII {
    public static void main(String[] args) {
        ListNode left = new ListNode(1);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        node5.next = node6;

//        ListNode left = new ListNode(7);
//        ListNode right = new ListNode(2);
//        ListNode node3 = new ListNode(4);
//        ListNode node4 = new ListNode(3);
//        left.next = right;
//        right.next = node3;
//        node3.next = node4;
//
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
//        ListNode node7 = new ListNode(4);
//        node5.next = node6;
//        node6.next = node7;

        ListNode listNode = addTwoNumbers(left, node5);
        ListNode.print(listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode ans  = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur = cur % 10;
            ListNode curNode = new ListNode(cur);
            curNode.next = ans;
            ans = curNode;
        }
        return ans;
    }


}
