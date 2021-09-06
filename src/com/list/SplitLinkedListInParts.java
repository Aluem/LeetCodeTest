package com.list;

public class SplitLinkedListInParts {
    public static void main(String[] args) {
        ListNode left = new ListNode(1);
        ListNode right = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        left.next = right;
        right.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        SplitLinkedListInParts splitLinkedListInParts = new SplitLinkedListInParts();
        ListNode[] listNodes = splitLinkedListInParts.splitListToParts(left, 2);
        for (int i = 0; i < listNodes.length; i++) {
            ListNode.print(listNodes[i]);
            System.out.println();
        }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = getListLength(root);
        int a = length / k; //每个链表应该包含多少个元素
        int b = length % k; //前面有多少个链表应该多包含一个元素

        ListNode[] heads = new ListNode[k];
        ListNode tmp = root;
        for (int j = 0; j < k; ++j) {
            ListNode head = null;
            ListNode t = null;
            for (int i = 0; i < a + (j < b ? 1 : 0); i++) {
                ListNode listNode = new ListNode(tmp.val);
                if (i == 0) {
                    head = listNode;
                    t = head;
                } else {
                    t.next = listNode;
                    t = t.next;
                }
                tmp = tmp.next;
            }
            heads[j] = head;
        }
        return heads;
    }

    //计算链表长度
    private int getListLength(ListNode head) {
        int num = 0;
        ListNode tmp = head;
        while (tmp != null) {
            num++;
            tmp = tmp.next;
        }
        return num;
    }
}
