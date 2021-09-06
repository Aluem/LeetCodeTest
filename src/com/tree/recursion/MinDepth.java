package com.tree.recursion;

import com.tree.TreeNode;

public class MinDepth {
    public int minDepth(TreeNode root) {
        while (root == null) {
            return 0;
        }
        //求左树最小深度
        int minLeft = minDepth(root.left);
        //右树最小深度
        int minRight = minDepth(root.right);
        //返回左右子树中最小深度+1
        if (minLeft == 0) {
            return minRight + 1;
        }
        if (minRight == 0) {
            return minLeft + 1;
        }
        return Math.min(minLeft, minRight) + 1;
    }
}
