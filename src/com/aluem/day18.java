package com.aluem;

public class day18 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode right = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = right;
        right.next = node3;
        node3.next = node4;
        day14 day14 = new day14();
        day18 day18 = new day18();
        ListNode listNode = day18.swapPairs(head);
        day14.print(listNode);
    }

    //递归
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode nextCur = head.next.next;
        newHead.next = head;
        head.next = swapPairs(nextCur);
        return newHead;
    }

//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode cur = head;
//        head = cur.next;
//        while (cur != null) {
//            if (cur.next == null) {
//                break;
//            } else {
//                ListNode nextCur = cur.next.next;
//                cur.next.next = cur;
//                if (nextCur != null && nextCur.next != null) {
//                    cur.next = nextCur.next;
//                } else {
//                    cur.next = nextCur;
//                }
//                cur = nextCur;
//            }
//        }
//        return head;
//    }
}
