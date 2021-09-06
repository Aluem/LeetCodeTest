package com.tree.bst;

import com.tree.TreeNode;

//669.修剪二叉查找树
public class TrimBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);

        root.left = node1;
        root.right = node4;
        node1.right = node2;

    }

    //二叉搜索树：左树的值比根节点小 右树的值比根节点大
    /*
        修剪当前树 如果当前节点<low 如果当前节点>high
            1.修剪左子树 返回修剪完的根节点
            2.修剪右子树

     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}