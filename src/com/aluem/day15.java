package com.aluem;

public class day15 {
    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);


        ListNode l1_3 = new ListNode(3);
        ListNode l1_4 = new ListNode(4);
        ListNode l1_5 = new ListNode(5);
        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;

        day15 day15 = new day15();
        ListNode listNode = day15.reverseList(l1_1);
        day15.print(listNode);
    }

    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode pre, ListNode cur) {
        ListNode node = null;
        if (cur == null) { //到了链表尾部
            return pre;
        }
        node = reverse(cur, cur.next);
        cur.next = pre;
        return node;
    }

    public void print(ListNode head) {
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
