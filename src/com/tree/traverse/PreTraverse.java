package com.tree.traverse;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//1. 非递归实现二叉树的前序遍历
public class PreTraverse {

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

        new PreTraverse().preTraverse(root);
        System.out.println();
        System.out.println(new PreTraverse().preTraverseNotRecursion(root));

        System.out.println();
    }


    //递归实现
    public void preTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preTraverse(root.left);
        preTraverse(root.right);
    }

    //非递归实现
    public List<Integer> preTraverseNotRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            res.add(node.val);
            stack.push(node.right);// 先右后左，保证左子树先遍历
            stack.push(node.left);
        }
        return res;
    }
}


