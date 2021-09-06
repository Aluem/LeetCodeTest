package com.tree.bst;

import com.list.ListNode;
import com.tree.TreeNode;

//109. 有序链表转换二叉搜索树
public class SortedListToBST {

    ListNode globalHead;

    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }

    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ++ret;
            head = head.next;
        }
        return ret;
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) return null;
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }

    //================================================
//    public TreeNode sortedListToBST(ListNode head) {
//        return buildTree(head, null);
//    }
//
//    public TreeNode buildTree(ListNode left, ListNode right) {
//        if (left == right) {
//            return null;
//        }
//        ListNode median = getMedian(left, right);
//        TreeNode root = new TreeNode(median.val);
//        root.left = buildTree(left, median);
//        root.right = buildTree(median.next, right);
//        return root;
//    }
//
//    public ListNode getMedian(ListNode left, ListNode right) {
//        ListNode slow = left;
//        ListNode fast = left;
//        while (fast != right && fast.next != right) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }

    //================================================
//    public TreeNode sortedListToBST(ListNode head) {
//        ListNode tmp = head;
//        int size = getListSize(head);
//        ListNode[] arr = new ListNode[size];
//        for (int i = 0; i < size; i++) {
//            arr[i] = tmp;
//            tmp = tmp.next;
//        }
//        TreeNode bst = createBST(arr, 0, size - 1);
//        return bst;
//    }
//
//    private TreeNode createBST(ListNode[] nodes, int l, int r) {
//        if (l > r) return null;
//        int rootIndex = (l + r) / 2;
//        TreeNode root = new TreeNode(nodes[rootIndex].val);
//        root.left = createBST(nodes, l, rootIndex - 1);
//        root.right = createBST(nodes, rootIndex + 1, r);
//        return root;
//    }
//
//    private int getListSize(ListNode head) {
//        int size = 0;
//        ListNode tmp = head;
//        while (tmp != null) {
//            size++;
//            tmp = tmp.next;
//        }
//        return size;
//    }
}
