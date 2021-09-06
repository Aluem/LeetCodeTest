package com.tree.traverse;

import com.tree.TreeNode;

import java.util.*;

//2. 非递归实现二叉树的后序遍历
public class PostOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
//        node6.left = node7;
//        node7.left = node8;

        new PostOrder().postOrder(root);
        System.out.println();
        System.out.println(new PostOrder().postOrder2(root));
    }


    //递归实现
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");

    }

    //非递归实现
    public List<Integer> postOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            stack.push(node.left);
            stack.push(node.right);
            res.add(0, node.val);
        }
        return res;
    }
}
