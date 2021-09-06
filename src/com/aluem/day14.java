package com.aluem;

//a699767
public class day14 {
    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(4);
        ListNode l1_2 = new ListNode(1);
        ListNode l2_1 = new ListNode(5);
        ListNode l2_2 = new ListNode(0);
        ListNode l2_3 = new ListNode(1);


        ListNode l1_3 = new ListNode(8);
        ListNode l1_4 = new ListNode(4);
        ListNode l1_5 = new ListNode(5);
//        l1_1.next = l1_2;
        l1_1.next = l1_3;
//        l1_2.next = l1_3;
//        l1_3.next = l1_4;
//        l1_4.next = l1_5;

        l2_1.next = l2_2;
        l2_2.next = l2_3;
        l2_3.next = l1_3;


        day14 day14 = new day14();
        System.out.println("第1条：");
        day14.print(l1_1);
        System.out.println();
        System.out.println("第2条：");
        day14.print(l2_1);

        ListNode node = day14.getIntersectionNode(l1_1, l2_1);
        System.out.println("\n结果如下:");
        if (node != null)
            System.out.println(node.val);
        else
            System.out.println("null");
    }

    /**
     * 思路：以两个指针相等为终止循环的条件，当两个链表不相交的时候，
     * 会同时到达各自链表的末尾也就是null，此时循环跳出，返回其中一个节点，也就是null就可以了
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode head1 = headA;
        ListNode head2 = headB;

        while (head1 != head2) {
            if (head1 != null) {
                head1 = head1.next;
            } else {
                head1 = headB;
            }

            if (head2 != null) {
                head2 = head2.next;
            } else {
                head2 = headA;
            }
        }
        return head1;

    }

    public ListNode reverse(ListNode head) {
        ListNode newHead = null;
        ListNode pre = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            if (current.next == null) {
                newHead = current;
            }
            current.next = pre;
            pre = current;

            current = next;
        }
        return newHead;

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

