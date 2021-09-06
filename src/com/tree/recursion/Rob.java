package com.tree.recursion;

import com.tree.TreeNode;

//337. 打家劫舍 III  XXXXX 未完成
public class Rob {
    //只能隔层获取
    /*
        获取树的最大金额
            1.获取左树最大金额
            2.获取右树最大金额
                细节：
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        v1 = recursion(root);
        v2 = recursion(root.left) + recursion(root.right);
        if (root.left != null) {
            v3 = recursion(root.left.left) + recursion(root.left.right) + recursion(root.right);
        }
        if (root.right != null) {
            v4 = recursion(root.right.left) + recursion(root.right.right) + recursion(root.left);
        }
        return Math.max(Math.max(v1, v2),Math.max(v3, v4));
    }

    //隔层遍历求和
    //获取当前节点的值
    public int recursion(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = node.val;
        if (node.left != null) {
            sum += recursion(node.left.left);
            sum += recursion(node.left.right);
        }
        if (node.right != null) {
            sum += recursion(node.right.left);
            sum += recursion(node.right.right);
        }
        return sum;
    }
}
