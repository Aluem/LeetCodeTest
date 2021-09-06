package com.aluem;

import java.util.HashMap;
import java.util.HashSet;

public class day11 {
    public static void main(String[] args) {
        String s = new String();
        char[] cs = new char[4];
        char[] cstr = new char[4];
        if (cs[1]==cstr[1]) {

        }
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    /**
     * 哈希表
     * @param head
     * @return
     */
//    public boolean hasCycle(ListNode head) {
//        if (head == null) {
//            return false;
//        }
//
//        ListNode node = head;
//        Set<ListNode> set = new HashSet<>();
//        while (node != null) {
//            if (set.contains(node)) {
//                return true;
//            }
//            set.add(node);
//            node = node.next;
//        }
//        return false;
//    }
}


