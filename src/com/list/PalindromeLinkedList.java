package com.list;

//递归
public class PalindromeLinkedList {
    private ListNode frontPointer;

    public static void main(String[] args) {
        ListNode left = new ListNode(1);
        ListNode right = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        left.next = right;
        right.next = node3;
        node3.next = node4;
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        boolean flag = palindromeLinkedList.isPalindrome(left);
        System.out.println(flag);
//
    }


    private boolean recursivelyCheck(ListNode currentNode) {
        boolean flag = true;
        if (currentNode.next != null) {
            flag = recursivelyCheck(currentNode.next);
        }
        if (currentNode.val == frontPointer.val) {
            frontPointer = frontPointer.next;
        } else {
            return false;
        }
        if (!flag) {
            return false;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
}
