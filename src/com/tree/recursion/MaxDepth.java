package com.tree.recursion;

import com.tree.TreeNode;

//二叉树的最大深度
public class MaxDepth {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}



