package com.tree.recursion;

import com.tree.TreeNode;

// 226. 翻转二叉树
public class InvertTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode right = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);
        root.left = right;
        root.right = node3;
        right.left = node4;
        right.right = node5;
        node3.left = node6;
        node3.right = node7;
        TreeNode treeNode = invertTree(root);
    }


//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        //左右子节点交换
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//        //递归交换
//        invertTree(root.left);
//        invertTree(root.right);
//        return root;
//    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left); //翻转左子树，返回当前节点左节点
        TreeNode right = invertTree(root.right); //翻转右子树，返回当前节点右节点
        root.left = right;
        root.right = left;
        return root;
    }

}
