package com.aluem;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class day17 {
    int count = 0;
    Map<Integer, ListNode> map = new HashMap<>();

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listright = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode.next = listright;
        listright.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        day14 day14 = new day14();
        day14.print(listNode);

        day17 day17 = new day17();
        ListNode listleft = day17.removeNthFromEnd(listNode, 2);
        System.out.println("删除后：");
        day14.print(listleft);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode pre = stack.peek();;
        pre.next = pre.next.next;
        return head;
    }

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode temp = head;
//        while (temp != null) {
//            count++;
//            map.put(count, temp);
//            temp = temp.next;
//        }
//        ListNode pre = map.get(count - n);
//        ListNode next = map.get(count - n + 2);
//        if (pre == null) {
//            head = next;
//        } else {
//            pre.next = next;
//        }
//        return head;
//    }
}
