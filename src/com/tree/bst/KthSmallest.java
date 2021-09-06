package com.tree.bst;

import com.tree.TreeNode;

//230. 二叉搜索树中第K小的元素
public class KthSmallest {
    int count = 0;
    int value = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        inOrder(root, k);
        return value;
    }
    public void inOrder(TreeNode root, int k) {
        if (root == null || count == k) {
            return;
        }
        inOrder(root.left, k);
        count++;
        if (count == k) {
            value = root.val;
            return;
        }
        inOrder(root.right, k);
    }

}
