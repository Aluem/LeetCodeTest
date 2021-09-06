package com.tree.recursion;

import com.tree.TreeNode;

//110. 平衡二叉树 给定一个二叉树，判断它是否是高度平衡的二叉树。
public class IsBalanced {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return (Math.abs(depth(root.left) - depth(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);

    }

    //求深度
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

}
