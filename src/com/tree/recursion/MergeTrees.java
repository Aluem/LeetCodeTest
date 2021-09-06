package com.tree.recursion;

import com.tree.TreeNode;

//617. 合并二叉树
public class MergeTrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);

        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(4);
        TreeNode node9 = new TreeNode(7);

        root.left = right;
        root.right = node3;
        right.left = node4;

        node5.left = node6;
        node5.right = node7;
        node6.right = node8;
        node7.right = node9;

        mergeTrees(root, node5);
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode treeNode = new TreeNode(t1.val + t2.val);
        treeNode.left = mergeTrees(t1.left, t2.left);
        treeNode.right = mergeTrees(t1.right, t2.right);
        return treeNode;
    }

//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        if (root1 == null && root2 == null) {
//            return null;
//        }
//        TreeNode treeNode = new TreeNode((root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val));
//        treeNode.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
//        treeNode.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
//        return treeNode;
//    }
}
