package com.tree.bst;

import com.tree.TreeNode;

// 538. 把二叉搜索树转换为累加树
public class ConvertBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node0 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3);
        TreeNode node8 = new TreeNode(8);

        root.left = node1;
        root.right = node6;
        node1.left = node0;
        node1.right= node2;
        node2.right = node3;
        node6.left = node5;
        node6.right = node7;
        node7.right = node8;

        new ConvertBST().convertBST(root);
    }
    //把当前节点的值修改为 ： 当前节点的值 + 右树所有节点值的和
    /*
        当前节点和 = 当前节点值 + 右树和
        先求右树和
            当前节点和=当前节点值 + 右节点值
     */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traver(root);
        return root;
    }

    public void traver(TreeNode node) {
        if (node == null) return;
        traver(node.right);
        sum += node.val;
        node.val = sum;
        traver(node.left);
    }
}
