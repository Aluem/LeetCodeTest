package com.tree.bst;

import com.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GetMinimumDifference {
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        root.right = node2;
//
//        int minimumDifference = new GetMinimumDifference().getMinimumDifference(root);
//        System.out.println(minimumDifference);
//    }

    int minSub = Integer.MAX_VALUE;
    private TreeNode preNode = null;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minSub;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        getMinimumDifference(node.left);
        if (preNode != null) minSub = Math.min(Math.abs(node.val - preNode.val), minSub);
        preNode = node;
        getMinimumDifference(node.right);
    }

//==================================================
//    List<TreeNode> list = new ArrayList<>();
//    public int getMinimumDifference(TreeNode root) {
//        inOrder(root);
//        int minSub = Integer.MAX_VALUE;
//        for (int i = 0; i < list.size() - 1; i++) {
//            int sub = Math.abs(list.get(i).val - list.get(i + 1).val);
//            if (sub < minSub) {
//                minSub = sub;
//            }
//        }
//        return minSub;
//    }
//
//    public void inOrder(TreeNode root) {
//        if (root == null) return;
//        inOrder(root.left);
//        list.add(root);
//        inOrder(root.right);
//    }
}
