package com.aluem;

import java.util.ArrayList;

public class day04 {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        ListNode l1_2 = new ListNode(4);
//        ListNode l1_3 = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        ListNode l2_2 = new ListNode(6);
//        ListNode l2_3 = new ListNode(4);
//
//        l1.next = l1_2;
//        l1_2.next = l1_3;
//
//        l2.next = l2_2;
//        l2_2.next = l2_3;

        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);


        day04 day04 = new day04();
        ListNode head = day04.addTwoNumbers(l1, l2);

        System.out.println("结果为：");

        ListNode temp = head;
        //临时指针
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;

        }


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum; //一个节点的和
        boolean flag = false; //判断上一个节点是否进1

        ListNode head = new ListNode(); //存放结果
        ListNode temp = head; //临时指针


        while (true) {
            if (l1 == null) {
                sum = l2.val;
            } else if (l2 == null) {
                sum = l1.val;
            } else {
                sum = l1.val + l2.val;
            }

            if (flag) {
                sum++;
                flag = false; //进1后重置flag
            }
            if (sum > 9) {
                sum = sum % 10;
                flag = true;
            }

            temp.val = sum;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (l1 == null && l2 == null && !flag) { //一直计算到其中一个链表的最后一个位
                break;
            }
            if (l1 == null && l2 == null && flag) {
                temp.next = new ListNode(1);
                break;
            }
            temp.next = new ListNode();
            temp = temp.next;

        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}