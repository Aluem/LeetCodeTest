package com.tree.traverse;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 3. 非递归实现二叉树的中序遍历
public class Inorder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        inOrder(root);
        System.out.println();
        System.out.println(inOrder2(root));
    }


    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.printf(root.val + " ");
        inOrder(root.right);
    }


    public static List<Integer> inOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) { // stack : 1 2 4
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    /*
        1.当前节点还有左节点，则将当前节点进栈 然后转到左节点，直到没有左节点，从栈中取一个节点 将该节点放入队列
        2.否则从栈中取一个节点，将取出的节点放入队列，
        3.判断是取出的节点否有右节点
            有 进入右节点 进入步骤123
            没有 从栈中取出一个节点 进入123
     */
//    public static List<Integer> inOrder2(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        List<Integer> res = new ArrayList<>();
//        TreeNode curr = root;
//        if (root == null) return res;
//        stack.push(curr);
//
//        while (!stack.isEmpty()) {
//            while (curr != null && curr.left != null) {
//                curr = curr.left;
//                stack.push(curr);
//            }
//            curr = stack.pop();
//            res.add(curr.val);
//            while (curr != null && curr.right == null) {
//                if (!stack.isEmpty()) {
//                    curr = stack.pop();
//                    res.add(curr.val);
//                } else {
//                    curr = null;
//                }
//            }
//            if (curr != null) {
//                curr = curr.right;
//                stack.push(curr);
//            }
//        }
//        return res;
//    }
}
