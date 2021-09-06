package com.list;

//203. 移除链表元素
public class RemoveElements {
    public static void main(String[] args) {

    }

    //递归
//    public ListNode removeElements(ListNode head, int val) {
//        if (head == null) {
//            return null;
//        }
//        head.next = removeElements(head.next, val);
//        return head.val == val ? head.next : head;
//    }

    //创建哑结点
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode tmp = dummyHead;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return dummyHead.next;
    }

        //分类判断
//    public ListNode removeElements(ListNode head, int val) {
//        if (head == null) {
//            return null;
//        }
//        ListNode newHead = head;
//        while (newHead != null && newHead.val == val) {
//            newHead = newHead.next;
//        }
//        ListNode pre = newHead;
//        while (pre != null && pre.next != null) {
//            if (pre.next.val == val) {
//                pre.next = pre.next.next;
//            } else {
//                pre = pre.next;
//            }
//        }
//        return newHead;
//    }
}
